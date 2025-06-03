package com.trovaparco.data.repository

import com.trovaparco.data.model.Park
import com.trovaparco.data.network.ParkApiService
import com.trovaparco.data.network.WeatherApiService
import com.trovaparco.data.network.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ParkRepository private constructor(
    private val apiService: ParkApiService,
    private val weatherApiService: WeatherApiService,
    private val apiKey: String,
    private val weatherApiKey: String
) {

    companion object {
        @Volatile
        private var instance: ParkRepository? = null

        fun getInstance(apiKey: String, weatherApiKey: String): ParkRepository {
            return instance ?: synchronized(this) {
                instance ?: ParkRepository(
                    ParkApiService.create(),
                    WeatherApiService.create(),
                    apiKey,
                    weatherApiKey
                ).also { instance = it }
            }
        }

        private val typeToItalianMap = mapOf(
            "park" to "Parco",
            "point_of_interest" to "Punto di interesse",
            "tourist_attraction" to "Attrazione Turistica",
            "establishment" to "Stabilimento",
            "bar" to "Bar",
            "playground" to "Area giochi",
            "wheelchair_accessible_entrance" to "Accessibile ai disabili",
            "picnic_area" to "Area picnic",
            "restroom" to "Bagni pubblici",
            "parking" to "Parcheggio",
            "trail" to "Sentieri",
            "bicycle_store" to "Noleggio biciclette",
            "dog_park" to "Area cani",
            "garden" to "Giardino",
            "fountain" to "Fontana",
            "campground" to "Campeggio",
            "sports_complex" to "Impianti sportivi",
            "zoo" to "Zoo",
            "museum" to "Museo",
            "library" to "Biblioteca"
        )
    }

    suspend fun getNearbyParks(latitude: Double, longitude: Double, radius: Int = 5000): Result<List<Park>> {
        return withContext(Dispatchers.IO) {
            try {
                val location = "$latitude,$longitude"
                val response = apiService.getNearbyParksFromGoogle(location, radius, "park", apiKey)

                if (response.status == "OK") {
                    val parks = response.results
                        .filter { place ->
                            val types = place.types?.map { it.lowercase() } ?: emptyList()
                            // Escludi i risultati che hanno "store" nei tipi
                            "store" !in types
                        }
                        .map {
                            Park(
                                id = it.place_id,
                                name = it.name,
                                description = "",
                                latitude = it.geometry.location.lat,
                                longitude = it.geometry.location.lng,
                                address = "",
                                facilities = emptyList(),
                                images = emptyList(),
                                openingHours = "",
                                rating = 0f
                            )
                        }
                    Result.success(parks)
                } else {
                    Result.failure(Exception("Errore API Nearby Parks: ${response.status}"))
                }
            } catch (e: Exception) {
                Result.failure(Exception("Eccezione durante chiamata Nearby Parks: ${e.localizedMessage}", e))
            }
        }
    }

    suspend fun getParkDetails(parkId: String): Result<Park> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getParkDetailsFromGoogle(
                    placeId = parkId,
                    apiKey = apiKey
                )
                if (response.status == "OK") {
                    val detail = response.result

                    val facilities = detail.types?.map { type ->
                        val key = type.lowercase()
                        typeToItalianMap[key] ?: type.replace('_', ' ').replaceFirstChar { it.uppercase() }
                    } ?: emptyList()

                    val images = detail.photos?.map { photo ->
                        "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${photo.photo_reference}&key=$apiKey"
                    } ?: emptyList()

                    val park = Park(
                        id = detail.place_id,
                        name = detail.name,
                        description = "",
                        latitude = detail.geometry.location.lat,
                        longitude = detail.geometry.location.lng,
                        address = detail.formatted_address ?: "",
                        facilities = facilities,
                        images = images,
                        openingHours = detail.opening_hours?.weekday_text?.joinToString("\n") ?: "",
                        rating = detail.rating ?: 0f
                    )
                    Result.success(park)
                } else {
                    Result.failure(Exception("Errore API dettagli parco: ${response.status}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    // Metodo per ottenere meteo attuale
    suspend fun getParkWeather(latitude: Double, longitude: Double): Result<WeatherResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = weatherApiService.getCurrentWeather(
                    lat = latitude,
                    lon = longitude,
                    apiKey = weatherApiKey
                )
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(Exception("Errore chiamata API meteo: ${e.localizedMessage}", e))
            }
        }
    }
}
