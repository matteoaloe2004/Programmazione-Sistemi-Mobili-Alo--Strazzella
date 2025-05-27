package com.trovaparco.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.trovaparco.R
import com.trovaparco.data.model.Park
import com.trovaparco.viewmodel.MapViewModel

class ParkDetailFragment : Fragment() {

    private lateinit var viewModel: MapViewModel

    private lateinit var tvParkName: TextView
    private lateinit var tvParkDescription: TextView
    private lateinit var tvParkAddress: TextView
    private lateinit var tvParkOpeningHours: TextView
    private lateinit var tvParkFacilities: TextView
    private lateinit var tvParkRating: TextView
    private lateinit var ivParkImage: ImageView

    private var parkId: String = ""

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

        observeViewModel()
    }

    private fun initializeViews(view: View) {
        tvParkName = view.findViewById(R.id.tv_park_name)
        tvParkDescription = view.findViewById(R.id.tv_park_description)
        tvParkAddress = view.findViewById(R.id.tv_park_address)
        tvParkOpeningHours = view.findViewById(R.id.tv_park_opening_hours)
        tvParkFacilities = view.findViewById(R.id.tv_park_facilities)
        tvParkRating = view.findViewById(R.id.tv_park_rating)
        ivParkImage = view.findViewById(R.id.iv_park_image)
    }

    private fun observeViewModel() {
        viewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            park?.let { displayParkDetails(it) }
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
        }
    }

    private fun displayParkDetails(park: Park) {
        tvParkName.text = park.name
        tvParkDescription.text = park.description
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearSelectedPark()
    }
}
