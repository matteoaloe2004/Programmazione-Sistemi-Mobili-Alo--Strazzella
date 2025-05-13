package com.trovaparco.viewmodel

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trovaparco.data.model.Park
import com.trovaparco.data.repository.ParkRepository
import kotlinx.coroutines.launch

/**
 * ViewModel for the map screen.
 * Handles data flow between repository and UI.
 */
class MapViewModel(private val repository: ParkRepository = ParkRepository.getInstance()) : ViewModel() {

    // Current user location
    private val _currentLocation = MutableLiveData<Location>()
    val currentLocation: LiveData<Location> = _currentLocation

    // List of nearby parks
    private val _nearbyParks = MutableLiveData<List<Park>>()
    val nearbyParks: LiveData<List<Park>> = _nearbyParks

    // Selected park
    private val _selectedPark = MutableLiveData<Park>()
    val selectedPark: LiveData<Park> = _selectedPark

    // Loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Error state
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    /**
     * Update current location and fetch nearby parks.
     *
     * @param location New location
     */
    fun updateLocation(location: Location) {
        _currentLocation.value = location
        fetchNearbyParks(location.latitude, location.longitude)
    }

    /**
     * Fetch nearby parks from the repository.
     *
     * @param latitude Current latitude
     * @param longitude Current longitude
     * @param radius Search radius in meters
     */
    fun fetchNearbyParks(latitude: Double, longitude: Double, radius: Int = 5000) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getNearbyParks(latitude, longitude, radius).fold(
                onSuccess = { parks ->
                    _nearbyParks.value = parks
                    _isLoading.value = false
                },
                onFailure = { throwable ->
                    _error.value = throwable.message ?: "Error fetching nearby parks"
                    _isLoading.value = false
                }
            )
        }
    }

    /**
     * Select a park to view its details.
     *
     * @param parkId ID of the selected park
     */
    fun selectPark(parkId: String) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getParkDetails(parkId).fold(
                onSuccess = { park ->
                    _selectedPark.value = park
                    _isLoading.value = false
                },
                onFailure = { throwable ->
                    _error.value = throwable.message ?: "Error fetching park details"
                    _isLoading.value = false
                }
            )
        }
    }

    /**
     * Clear the selected park.
     */
    fun clearSelectedPark() {
        _selectedPark.value = null
    }
}
