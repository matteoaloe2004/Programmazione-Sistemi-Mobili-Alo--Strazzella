package com.trovaparco.data.repository

import com.trovaparco.data.model.Park
import com.trovaparco.data.network.ParkApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ParkRepository private constructor(
    private val apiService: ParkApiService,
    private val apiKey: String
) {

    companion object {
        @Volatile
        private var instance: ParkRepository? = null

        fun getInstance(apiKey: String): ParkRepository {
            return instance ?: synchronized(this) {
                instance ?: ParkRepository(ParkApiService.create(), apiKey).also { instance = it }
            }
        }
    }

    suspend fun getNearbyParks(latitude: Double, longitude: Double, radius: Int = 5000): Result<List<Park>> {
        return withContext(Dispatchers.IO) {
            try {
                val location = "$latitude,$longitude"
                val response = apiService.getNearbyParksFromGoogle(location, radius, "park", apiKey)

                if (response.status == "OK") {
                    val parks = response.results.map {
                        Park(
                            id = it.place_id,
                            name = it.name,
                            description = "", // Google Places non fornisce descrizione diretta
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

                    // Mappa i tipi in facilities leggibili
                    val facilities = detail.types?.map { type ->
                        when (type) {
                            "Park" -> "Parco"
                            "Point of interest" -> "Punto di interesse"
                            "Establishment" -> "Stabilimenti"
                            "Bar" -> "Bar"
                            "playground" -> "Area giochi"
                            "wheelchair_accessible_entrance" -> "Accessibile ai disabili"
                            "picnic_area" -> "Area picnic"
                            "restroom" -> "Bagni pubblici"
                            "parking" -> "Parcheggio"
                            "trail" -> "Sentieri"
                            "bicycle_store" -> "Noleggio biciclette"
                            "dog_park" -> "Area cani"
                            "garden" -> "Giardino"
                            "fountain" -> "Fontana"
                            "campground" -> "Campeggio"
                            "sports_complex" -> "Impianti sportivi"
                            "zoo" -> "Zoo"
                            "museum" -> "Museo"
                            "library" -> "Biblioteca"
                            else -> type.replace('_', ' ').capitalize() // fallback: tipo "pulito"
                        }
                    } ?: emptyList()

                    // Costruisci lista URL immagini da photo_reference
                    val images = detail.photos?.map { photo ->
                        "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=${photo.photo_reference}&key=$apiKey"
                    } ?: emptyList()

                    val park = Park(
                        id = detail.place_id,
                        name = detail.name,
                        description = "", // Google non fornisce descrizione testuale
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
}
