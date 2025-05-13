package com.trovaparco.utils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"calculateDistance", "", "lat1", "", "lon1", "lat2", "lon2", "formatDistance", "", "distanceInMeters", "isLocationEnabled", "", "context", "Landroid/content/Context;", "app_debug"})
public final class LocationUtilsKt {
    
    /**
     * Check if location services are enabled on the device.
     *
     * @param context Application context
     * @return true if location services are enabled
     */
    public static final boolean isLocationEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
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
    public static final float calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return 0.0F;
    }
    
    /**
     * Format distance in a human-readable way.
     *
     * @param distanceInMeters Distance in meters
     * @return Formatted distance string
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDistance(float distanceInMeters) {
        return null;
    }
}