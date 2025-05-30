package com.trovaparco.viewmodel

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.trovaparco.data.local.FavoritesStorage
import com.trovaparco.data.model.Park
import com.trovaparco.data.network.WeatherResponse
import com.trovaparco.data.repository.ParkRepository
import kotlinx.coroutines.launch

class MapViewModel(
    application: Application,
    private val repository: ParkRepository
) : AndroidViewModel(application) {

    private val favoritesStorage = FavoritesStorage(application)

    private val _currentLocation = MutableLiveData<Location>()
    fun getCurrentLocation(): LiveData<Location> = _currentLocation

    private val _nearbyParks = MutableLiveData<List<Park>>()
    val nearbyParks: LiveData<List<Park>> = _nearbyParks

    private val _selectedPark = MutableLiveData<Park?>()
    val selectedPark: LiveData<Park?> = _selectedPark

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _weather = MutableLiveData<WeatherResponse?>()
    val weather: LiveData<WeatherResponse?> = _weather

    private val _favoriteParks = MutableLiveData<List<Park>>()
    val favoriteParks: LiveData<List<Park>> = _favoriteParks

    private val favoriteMap = mutableMapOf<String, Park>()

    init {
        loadFavoriteParks()
    }

    fun updateLocation(location: Location) {
        _currentLocation.value = location
        fetchNearbyParks(location.latitude, location.longitude)
        fetchWeatherForPark(location.latitude, location.longitude)
    }

    fun fetchNearbyParks(latitude: Double, longitude: Double, radius: Int = 5000) {
        _isLoading.value = true
        viewModelScope.launch {
            repository.getNearbyParks(latitude, longitude, radius).fold(
                onSuccess = { parks ->
                    _nearbyParks.value = parks
                    _isLoading.value = false
                    updateFavoriteParks()
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
                    fetchWeatherForPark(park.latitude, park.longitude)
                },
                onFailure = { throwable ->
                    _error.value = throwable.message ?: "Error fetching park details"
                    _isLoading.value = false
                }
            )
        }
    }

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

    fun toggleFavorite(park: Park) {
        if (favoriteMap.containsKey(park.id)) {
            favoriteMap.remove(park.id)
        } else {
            favoriteMap[park.id] = park
        }
        saveFavoritesToStorage()
        updateFavoriteParks()
    }

    fun removeFavorite(park: Park) {
        if (favoriteMap.containsKey(park.id)) {
            favoriteMap.remove(park.id)
            saveFavoritesToStorage()
            updateFavoriteParks()
        }
    }

    private fun updateFavoriteParks() {
        _favoriteParks.value = favoriteMap.values.toList()
    }

    private fun saveFavoritesToStorage() {
        favoritesStorage.saveFavorites(favoriteMap.values.toList())
    }

    fun loadFavoriteParks() {
        val loaded = favoritesStorage.loadFavorites()
        favoriteMap.clear()
        loaded.forEach { favoriteMap[it.id] = it }
        updateFavoriteParks()
    }

    fun clearSelectedPark() {
        _selectedPark.value = null
        _weather.value = null
    }
}
