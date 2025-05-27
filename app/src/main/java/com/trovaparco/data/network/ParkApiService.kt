package com.trovaparco.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class GooglePlaceResult(
    val place_id: String,
    val name: String,
    val geometry: Geometry,
    val types: List<String>
)

data class Geometry(val location: Location)
data class Location(val lat: Double, val lng: Double)

data class GooglePlacesResponse(
    val results: List<GooglePlaceResult>,
    val status: String
)

interface ParkApiService {

    @GET("place/nearbysearch/json")
    suspend fun getNearbyParksFromGoogle(
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("type") type: String = "park",
        @Query("key") apiKey: String
    ): GooglePlacesResponse

    companion object {
        private const val BASE_URL = "https://maps.googleapis.com/maps/api/"

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
