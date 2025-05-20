package com.trovaparco.data.network;

/**
 * API service interface for park data.
 * Uses Retrofit to make network requests.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/trovaparco/data/network/ParkApiService;", "", "getNearbyParks", "", "Lcom/trovaparco/data/model/Park;", "latitude", "", "longitude", "radius", "", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParkDetails", "parkId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface ParkApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.data.network.ParkApiService.Companion Companion = null;
    
    /**
     * Get nearby parks based on current location.
     *
     * @param latitude Current latitude
     * @param longitude Current longitude
     * @param radius Search radius in meters
     * @return List of parks
     */
    @retrofit2.http.GET(value = "parks/nearby")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNearbyParks(@retrofit2.http.Query(value = "latitude")
    double latitude, @retrofit2.http.Query(value = "longitude")
    double longitude, @retrofit2.http.Query(value = "radius")
    int radius, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.trovaparco.data.model.Park>> $completion);
    
    /**
     * Get details of a specific park.
     *
     * @param parkId ID of the park
     * @return Park details
     */
    @retrofit2.http.GET(value = "parks/details")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getParkDetails(@retrofit2.http.Query(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String parkId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.trovaparco.data.model.Park> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/trovaparco/data/network/ParkApiService$Companion;", "", "()V", "BASE_URL", "", "create", "Lcom/trovaparco/data/network/ParkApiService;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String BASE_URL = "https://api.trovaparco.repl.co/v1/";
        
        private Companion() {
            super();
        }
        
        /**
         * Create an instance of ParkApiService.
         */
        @org.jetbrains.annotations.NotNull()
        public final com.trovaparco.data.network.ParkApiService create() {
            return null;
        }
    }
    
    /**
     * API service interface for park data.
     * Uses Retrofit to make network requests.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}