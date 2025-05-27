package com.trovaparco.data.repository

import com.trovaparco.BuildConfig
import com.trovaparco.data.model.Park
import com.trovaparco.data.network.ParkApiService

class ParkRepository private constructor(private val api: ParkApiService) {

    suspend fun getNearbyParks(
        latitude: Double,
        longitude: Double,
        radius: Int = 5000
    ): Result<List<Park>> {
        return try {
            val response = api.getNearbyParksFromGoogle(
                location = "$latitude,$longitude",
                radius = radius,
                apiKey = BuildConfig.MAPS_API_KEY
            )


            if (response.status != "OK") {
                return Result.failure(Exception("API error: ${response.status}"))
            }

            val parks = response.results
                .filter { it.types.contains("park") }
                .map {
                    Park(
                        id = it.place_id,
                        name = it.name,
                        latitude = it.geometry.location.lat,
                        longitude = it.geometry.location.lng,
                        description = "Parco pubblico"
                    )
                }

            Result.success(parks)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getParkDetails(parkId: String): Result<Park> {
        // TODO: Optional – implementazione avanzata (Places Details API)
        return Result.failure(Exception("Park detail API non ancora implementata"))
    }

    companion object {
        @Volatile
        private var instance: ParkRepository? = null

        fun getInstance(): ParkRepository {
            return instance ?: synchronized(this) {
                instance ?: ParkRepository(ParkApiService.create()).also { instance = it }
            }
        }
    }
}
