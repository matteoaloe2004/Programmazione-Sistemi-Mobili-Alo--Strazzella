package com.trovaparco.data.network

import com.trovaparco.data.model.Park
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * API service interface for park data.
 * Uses Retrofit to make network requests.
 */
interface ParkApiService {
    /**
     * Get nearby parks based on current location.
     *
     * @param latitude Current latitude
     * @param longitude Current longitude
     * @param radius Search radius in meters
     * @return List of parks
     */
    @GET("parks/nearby")
    suspend fun getNearbyParks(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("radius") radius: Int = 5000
    ): List<Park>

    /**
     * Get details of a specific park.
     *
     * @param parkId ID of the park
     * @return Park details
     */
    @GET("parks/details")
    suspend fun getParkDetails(@Query("id") parkId: String): Park

    companion object {
        private const val BASE_URL = "https://api.parksdata.com/v1/"

        /**
         * Create an instance of ParkApiService.
         */
        fun create(): ParkApiService {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(ParkApiService::class.java)
        }
    }
}
