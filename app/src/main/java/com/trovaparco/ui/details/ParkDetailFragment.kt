package com.trovaparco.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trovaparco.R
import com.trovaparco.data.model.Park
import com.trovaparco.viewmodel.MapViewModel

/**
 * Fragment for displaying park details.
 */
class ParkDetailFragment : Fragment() {

    private lateinit var viewModel: MapViewModel

    // UI elements
    private lateinit var tvParkName: TextView
    private lateinit var tvParkDescription: TextView
    private lateinit var tvParkAddress: TextView
    private lateinit var tvParkOpeningHours: TextView
    private lateinit var tvParkFacilities: TextView
    private lateinit var tvParkRating: TextView

    private var parkId: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_park_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity())[MapViewModel::class.java]

        // Initialize UI elements
        initializeViews(view)

        // Get park ID from arguments bundle
        arguments?.getString("parkId")?.let {
            parkId = it
            loadParkDetails(parkId)
        }

        // Observe ViewModel data
        observeViewModel()
    }

    private fun initializeViews(view: View) {
        tvParkName = view.findViewById(R.id.tv_park_name)
        tvParkDescription = view.findViewById(R.id.tv_park_description)
        tvParkAddress = view.findViewById(R.id.tv_park_address)
        tvParkOpeningHours = view.findViewById(R.id.tv_park_opening_hours)
        tvParkFacilities = view.findViewById(R.id.tv_park_facilities)
        tvParkRating = view.findViewById(R.id.tv_park_rating)
    }

    private fun loadParkDetails(parkId: String) {
        viewModel.selectPark(parkId)
    }

    private fun observeViewModel() {
        // Observe selected park
        viewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            park?.let {
                displayParkDetails(it)
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

    private fun displayParkDetails(park: Park) {
        tvParkName.text = park.name
        tvParkDescription.text = park.description
        tvParkAddress.text = park.address
        tvParkOpeningHours.text = park.openingHours.ifEmpty { "Opening hours not available" }

        // Format facilities as a bullet list
        val facilitiesText = if (park.facilities.isEmpty()) {
            "No facilities information available"
        } else {
            park.facilities.joinToString("\n") { "• $it" }
        }
        tvParkFacilities.text = facilitiesText

        // Display rating
        tvParkRating.text = if (park.rating > 0) {
            String.format("%.1f/5.0", park.rating)
        } else {
            "Rating not available"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear selected park when leaving detail view
        viewModel.clearSelectedPark()
    }
}
