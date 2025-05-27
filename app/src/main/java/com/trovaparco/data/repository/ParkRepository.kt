package com.trovaparco.data.repository

import com.trovaparco.data.model.Park
import com.trovaparco.data.network.ParkApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.UUID

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
                            description = "", // Google Places non fornisce direttamente una descrizione
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
                    Result.failure(Exception("Errore API: ${response.status}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    // Placeholder per getParkDetails – puoi espandere con un'altra API call o cache
    suspend fun getParkDetails(parkId: String): Result<Park> {
        return withContext(Dispatchers.IO) {
            try {
                val dummy = Park(
                    id = parkId,
                    name = "Parco Dettagliato",
                    description = "Descrizione dettagliata non disponibile.",
                    latitude = 45.0,
                    longitude = 9.0,
                    address = "Indirizzo non disponibile",
                    facilities = listOf("Panchine", "Area giochi", "Fontanelle"),
                    images = listOf("https://source.unsplash.com/800x600/?park"),
                    openingHours = "08:00 - 20:00",
                    rating = 4.2f
                )
                Result.success(dummy)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
