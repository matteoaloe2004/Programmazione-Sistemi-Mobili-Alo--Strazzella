package com.trovaparco.viewmodel

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trovaparco.data.model.Park
import com.trovaparco.data.network.WeatherResponse
import com.trovaparco.data.repository.ParkRepository
import kotlinx.coroutines.launch

class MapViewModel(
    private val repository: ParkRepository
) : ViewModel() {

    // Current user location
    private val _currentLocation = MutableLiveData<Location>()
    fun getCurrentLocation(): LiveData<Location> = _currentLocation

    // List of nearby parks
    private val _nearbyParks = MutableLiveData<List<Park>>()
    val nearbyParks: LiveData<List<Park>> = _nearbyParks

    // Selected park
    private val _selectedPark = MutableLiveData<Park?>()
    val selectedPark: LiveData<Park?> = _selectedPark

    // Loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    // Error state
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Meteo per il parco selezionato
    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> = _weather

    fun updateLocation(location: Location) {
        _currentLocation.value = location
        fetchNearbyParks(location.latitude, location.longitude)
    }

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

    fun selectPark(parkId: String) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getParkDetails(parkId).fold(
                onSuccess = { park ->
                    _selectedPark.value = park
                    _isLoading.value = false
                    // Quando selezioni un parco, carica anche il meteo
                    fetchWeatherForPark(park.latitude, park.longitude)
                },
                onFailure = { throwable ->
                    _error.value = throwable.message ?: "Error fetching park details"
                    _isLoading.value = false
                }
            )
        }
    }

    // Nuovo metodo per caricare il meteo del parco
    fun fetchWeatherForPark(latitude: Double, longitude: Double) {
        viewModelScope.launch {
            repository.getParkWeather(latitude, longitude).fold(
                onSuccess = { weatherResponse ->
                    _weather.value = weatherResponse
                },
                onFailure = {
                    _weather.value = null
                }
            )
        }
    }

    private val _favoriteParks = MutableLiveData<List<Park>>()
    val favoriteParks: LiveData<List<Park>> = _favoriteParks

    private val favoriteIds = mutableSetOf<String>()

    fun toggleFavorite(park: Park) {
        if (favoriteIds.contains(park.id)) {
            favoriteIds.remove(park.id)
        } else {
            favoriteIds.add(park.id)
        }
        updateFavoriteParks()
    }

    private fun updateFavoriteParks() {
        val current = nearbyParks.value ?: return
        _favoriteParks.value = current.filter { favoriteIds.contains(it.id) }
    }

    fun removeFavorite(park: Park) {
        favoriteIds.remove(park.id)
        updateFavoriteParks()
    }

    fun loadFavoriteParks() {
        updateFavoriteParks()
    }

    fun clearSelectedPark() {
        _selectedPark.value = null
        _weather.value = null
    }
}
