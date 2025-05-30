package com.trovaparco.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trovaparco.R
import com.trovaparco.adapter.ParksAdapter
import com.trovaparco.viewmodel.MapViewModel

class FavoriteParksFragment : Fragment() {

    private lateinit var viewModel: MapViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ParksAdapter
    private lateinit var btnBackToMap: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_favorite_parks, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[MapViewModel::class.java]

        recyclerView = view.findViewById(R.id.recycler_favorite_parks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = ParksAdapter(
            parks = emptyList(),
            onParkClick = { park ->
                viewModel.selectPark(park.id)
            },
            onRemoveClick = { park ->
                viewModel.removeFavorite(park)
            }
        )
        recyclerView.adapter = adapter

        btnBackToMap = view.findViewById(R.id.btn_back_to_map)
        btnBackToMap.setOnClickListener {
            viewModel.clearSelectedPark()
            findNavController().navigate(R.id.action_favoriteParksFragment_to_mapFragment)
        }

        viewModel.favoriteParks.observe(viewLifecycleOwner) { parks ->
            adapter.updateParks(parks)
        }

        viewModel.selectedPark.observe(viewLifecycleOwner) { park ->
            park?.let {
                val navController = findNavController()
                val currentDestination = navController.currentDestination?.id
                if (currentDestination == R.id.favoriteParksFragment) {
                    navController.navigate(
                        FavoriteParksFragmentDirections.actionFavoriteParksFragmentToParkDetailFragment(it.id)
                    )
                }
                viewModel.clearSelectedPark()
            }
        }
    }
}
