package com.trovaparco.data.repository

import com.trovaparco.data.model.Park
import com.trovaparco.data.network.ParkApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for park data.
 * Acts as a single source of truth for park data, abstracting the data source.
 */
class ParkRepository(private val apiService: ParkApiService) {

    /**
     * Get nearby parks based on location.
     *
     * @param latitude Current latitude
     * @param longitude Current longitude
     * @param radius Search radius in meters
     * @return List of nearby parks
     */
    suspend fun getNearbyParks(
        latitude: Double,
        longitude: Double,
        radius: Int = 5000
    ): Result<List<Park>> = withContext(Dispatchers.IO) {
        try {
            val parks = apiService.getNearbyParks(latitude, longitude, radius)
            Result.success(parks)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    /**
     * Get details of a specific park.
     *
     * @param parkId ID of the park
     * @return Park details
     */
    suspend fun getParkDetails(parkId: String): Result<Park> = withContext(Dispatchers.IO) {
        try {
            val park = apiService.getParkDetails(parkId)
            Result.success(park)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    companion object {
        @Volatile
        private var instance: ParkRepository? = null

        /**
         * Get singleton instance of ParkRepository.
         */
        fun getInstance(): ParkRepository {
            return instance ?: synchronized(this) {
                instance ?: ParkRepository(ParkApiService.create()).also { instance = it }
            }
        }
    }
}
