package com.trovaparco.utils

import android.content.Context
import android.location.LocationManager

/**
 * Utility functions for location services.
 */

/**
 * Check if location services are enabled on the device.
 *
 * @param context Application context
 * @return true if location services are enabled
 */
fun isLocationEnabled(context: Context): Boolean {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
}

/**
 * Calculate distance between two coordinates in meters.
 *
 * @param lat1 First latitude
 * @param lon1 First longitude
 * @param lat2 Second latitude
 * @param lon2 Second longitude
 * @return Distance in meters
 */
fun calculateDistance(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Float {
    val results = FloatArray(1)
    android.location.Location.distanceBetween(lat1, lon1, lat2, lon2, results)
    return results[0]
}

/**
 * Format distance in a human-readable way.
 *
 * @param distanceInMeters Distance in meters
 * @return Formatted distance string
 */
fun formatDistance(distanceInMeters: Float): String {
    return when {
        distanceInMeters < 1000 -> "${distanceInMeters.toInt()} m"
        else -> String.format("%.1f km", distanceInMeters / 1000)
    }
}
