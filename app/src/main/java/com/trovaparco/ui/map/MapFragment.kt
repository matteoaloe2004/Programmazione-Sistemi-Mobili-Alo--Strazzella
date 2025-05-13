package com.trovaparco.ui.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.trovaparco.R
import com.trovaparco.data.model.Park
import com.trovaparco.utils.isLocationEnabled
import com.trovaparco.viewmodel.MapViewModel

/**
 * Fragment for displaying a map with nearby parks.
 */
class MapFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var viewModel: MapViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var googleMap: GoogleMap? = null
    private val markers = mutableMapOf<String, Marker>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val locationGranted = permissions.entries.all { it.value }
        if (locationGranted) {
            enableMyLocation()
        } else {
            Toast.makeText(
                requireContext(),
                "Location permission is required to show nearby parks",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity())[MapViewModel::class.java]

        // Initialize location services
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        // Set up the map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Observe ViewModel data
        observeViewModel()
    }

    private fun observeViewModel() {
        // Observe nearby parks
        viewModel.nearbyParks.observe(viewLifecycleOwner) { parks ->
            displayParksOnMap(parks)
        }

        // Observe selected park
        viewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            park?.let {
                // Navigate to detail fragment
                val bundle = Bundle().apply {
                    putString("parkId", it.id)
                }
                findNavController().navigate(R.id.action_mapFragment_to_parkDetailFragment, bundle)
            }
        }

        // Observe loading state
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Show/hide loading indicator if needed
        }

        // Observe error state
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        googleMap?.setOnMarkerClickListener(this)

        // Check and request location permissions
        checkLocationPermission()
    }

    private fun checkLocationPermission() {
        when {
            hasLocationPermissions() -> {
                enableMyLocation()
            }
            shouldShowRequestPermissionRationale() -> {
                Toast.makeText(
                    requireContext(),
                    "Location permission is needed to show parks near you",
                    Toast.LENGTH_LONG
                ).show()
                requestLocationPermissions()
            }
            else -> {
                requestLocationPermissions()
            }
        }
    }

    private fun hasLocationPermissions(): Boolean {
        return LOCATION_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun shouldShowRequestPermissionRationale(): Boolean {
        return LOCATION_PERMISSIONS.any {
            shouldShowRequestPermissionRationale(it)
        }
    }

    private fun requestLocationPermissions() {
        requestPermissionLauncher.launch(LOCATION_PERMISSIONS)
    }

    @SuppressLint("MissingPermission")
    private fun enableMyLocation() {
        if (!isLocationEnabled(requireContext())) {
            Toast.makeText(
                requireContext(),
                "Please enable location services to find parks near you",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        googleMap?.isMyLocationEnabled = true

        // Get current location and update map
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let {
                val currentLatLng = LatLng(it.latitude, it.longitude)
                googleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14f))

                // Update ViewModel with current location
                viewModel.updateLocation(it)
            }
        }
    }

    private fun displayParksOnMap(parks: List<Park>) {
        // Clear previous markers
        markers.values.forEach { it.remove() }
        markers.clear()

        // Add markers for each park
        parks.forEach { park ->
            val position = LatLng(park.latitude, park.longitude)
            val marker = googleMap?.addMarker(
                MarkerOptions()
                    .position(position)
                    .title(park.name)
                    .snippet(park.description)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            )

            marker?.let {
                markers[park.id] = it
                it.tag = park.id
            }
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        // Get the park ID from marker tag
        val parkId = marker.tag as? String
        parkId?.let {
            viewModel.selectPark(it)
        }
        return false
    }

    companion object {
        private val LOCATION_PERMISSIONS = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
}
