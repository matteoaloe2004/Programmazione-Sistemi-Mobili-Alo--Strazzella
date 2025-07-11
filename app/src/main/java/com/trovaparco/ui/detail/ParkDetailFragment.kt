package com.trovaparco.ui.detail

import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.trovaparco.R
import com.trovaparco.data.model.Park
import com.trovaparco.viewmodel.MapViewModel
import kotlin.math.roundToInt

class ParkDetailFragment : Fragment() {

    private lateinit var viewModel: MapViewModel

    private lateinit var tvParkName: TextView
    private lateinit var tvParkAddress: TextView
    private lateinit var tvParkOpeningHours: TextView
    private lateinit var tvParkFacilities: TextView
    private lateinit var tvParkRating: TextView
    private lateinit var tvParkDistance: TextView
    private lateinit var ivParkImage: ImageView
    private lateinit var btnBackToMap: Button
    private lateinit var btnToggleFavorite: Button

    // Meteo UI
    private lateinit var tvWeatherCondition: TextView
    private lateinit var tvWeatherTemperature: TextView
    private lateinit var tvWeatherHumidity: TextView

    private var parkId: String = ""
    private var currentPark: Park? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_park_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MapViewModel::class.java]
        initializeViews(view)

        arguments?.getString("parkId")?.let {
            parkId = it
            viewModel.selectPark(parkId)
        }

        btnToggleFavorite.setOnClickListener {
            currentPark?.let { park ->
                viewModel.toggleFavorite(park)
                updateFavoriteButton()
                val message = if (viewModel.favoriteParks.value?.any { it.id == park.id } == true)
                    "Parco aggiunto ai preferiti"
                else
                    "Parco rimosso dai preferiti"
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        btnBackToMap.setOnClickListener {
            Log.d("NavDebug", "Back to map clicked - clearing selectedPark and navigating with popUpTo")
            viewModel.clearSelectedPark()
            findNavController().navigate(R.id.action_parkDetailFragment_to_mapFragment)
        }

        observeViewModel()
    }

    private fun initializeViews(view: View) {
        tvParkName = view.findViewById(R.id.tv_park_name)
        tvParkAddress = view.findViewById(R.id.tv_park_address)
        tvParkOpeningHours = view.findViewById(R.id.tv_park_opening_hours)
        tvParkFacilities = view.findViewById(R.id.tv_park_facilities)
        tvParkRating = view.findViewById(R.id.tv_park_rating)
        tvParkDistance = view.findViewById(R.id.tv_park_distance)
        ivParkImage = view.findViewById(R.id.iv_park_image)
        btnBackToMap = view.findViewById(R.id.btn_back_to_map)
        btnToggleFavorite = view.findViewById(R.id.btn_toggle_favorite)

        // Meteo
        tvWeatherCondition = view.findViewById(R.id.tv_weather_condition)
        tvWeatherTemperature = view.findViewById(R.id.tv_weather_temperature)
        tvWeatherHumidity = view.findViewById(R.id.tv_weather_humidity)
    }

    private fun observeViewModel() {
        viewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            if (park != null) {
                currentPark = park
                displayParkDetails(park)
                updateFavoriteButton()
            }
        }

        viewModel.getCurrentLocation().observe(viewLifecycleOwner) { userLocation ->
            currentPark?.let { park ->
                if (userLocation != null) {
                    updateDistance(userLocation, park)
                }
            }
        }

        viewModel.weather.observe(viewLifecycleOwner) { weather ->
            if (weather != null) {
                val condition = weather.weather.firstOrNull()?.description ?: "N/D"
                val temperature = "${weather.main.temp}°C"
                val humidity = "Umidità: ${weather.main.humidity}%"

                tvWeatherCondition.text = condition.replaceFirstChar { it.uppercase() }
                tvWeatherTemperature.text = temperature
                tvWeatherHumidity.text = humidity
            } else {
                tvWeatherCondition.text = "Meteo non disponibile"
                tvWeatherTemperature.text = ""
                tvWeatherHumidity.text = ""
            }
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
        }
    }

    private fun displayParkDetails(park: Park) {
        tvParkName.text = park.name
        tvParkAddress.text = park.address
        tvParkOpeningHours.text = park.openingHours.ifEmpty { "Orari non disponibili" }
        tvParkRating.text = if (park.rating > 0) "${park.rating}/5" else "Non valutato"

        tvParkFacilities.text = if (park.facilities.isEmpty()) {
            "Nessuna informazione sui servizi"
        } else {
            park.facilities.joinToString("\n") { "• $it" }
        }

        if (park.images.isNotEmpty()) {
            Glide.with(requireContext()).load(park.images.first()).into(ivParkImage)
        }

        viewModel.getCurrentLocation().value?.let { location ->
            updateDistance(location, park)
        }
    }

    private fun updateDistance(userLocation: Location, park: Park) {
        val parkLocation = Location("").apply {
            latitude = park.latitude
            longitude = park.longitude
        }

        val distanceMeters = userLocation.distanceTo(parkLocation)

        val distanceText = if (distanceMeters < 1000) {
            "${distanceMeters.toInt()} m"
        } else {
            "%.1f km".format(distanceMeters / 1000)
        }

        // 🚶‍♂️ Calcolo dei minuti a piedi (~1.4 m/s = 5 km/h)
        val averageWalkingSpeedMetersPerSec = 1.4
        val walkingTimeMinutes = (distanceMeters / averageWalkingSpeedMetersPerSec / 60).roundToInt()

        tvParkDistance.text = "Distanza: $distanceText (${walkingTimeMinutes} min)"
    }

    private fun updateFavoriteButton() {
        currentPark?.let { park ->
            val isFavorite = viewModel.favoriteParks.value?.any { it.id == park.id } ?: false
            if (isFavorite) {
                btnToggleFavorite.text = "Rimuovi dai preferiti"
            } else {
                btnToggleFavorite.text = "Aggiungi ai preferiti"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearSelectedPark()
        Log.d("NavDebug", "Cleared selectedPark onDestroyView")
    }
}
