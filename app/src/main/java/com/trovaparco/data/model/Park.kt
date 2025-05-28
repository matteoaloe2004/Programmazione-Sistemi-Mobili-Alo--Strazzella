package com.trovaparco.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Park(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "latitude") val latitude: Double,
    @Json(name = "longitude") val longitude: Double,
    @Json(name = "address") val address: String = "",
    @Json(name = "facilities") val facilities: List<String> = emptyList(),
    @Json(name = "images") val images: List<String> = emptyList(),
    @Json(name = "opening_hours") val openingHours: String = "",
    @Json(name = "rating") val rating: Float = 0f
)
