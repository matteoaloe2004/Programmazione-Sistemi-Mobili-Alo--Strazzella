package com.trovaparco.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ<\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository;", "", "apiService", "Lcom/trovaparco/data/network/ParkApiService;", "weatherApiService", "Lcom/trovaparco/data/network/WeatherApiService;", "apiKey", "", "weatherApiKey", "(Lcom/trovaparco/data/network/ParkApiService;Lcom/trovaparco/data/network/WeatherApiService;Ljava/lang/String;Ljava/lang/String;)V", "getNearbyParks", "Lkotlin/Result;", "", "Lcom/trovaparco/data/model/Park;", "latitude", "", "longitude", "radius", "", "getNearbyParks-BWLJW6A", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParkDetails", "parkId", "getParkDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParkWeather", "Lcom/trovaparco/data/network/WeatherResponse;", "getParkWeather-0E7RQCE", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class ParkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.network.ParkApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.network.WeatherApiService weatherApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String weatherApiKey = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.trovaparco.data.repository.ParkRepository instance;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.String> typeToItalianMap = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.data.repository.ParkRepository.Companion Companion = null;
    
    private ParkRepository(com.trovaparco.data.network.ParkApiService apiService, com.trovaparco.data.network.WeatherApiService weatherApiService, java.lang.String apiKey, java.lang.String weatherApiKey) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository$Companion;", "", "()V", "instance", "Lcom/trovaparco/data/repository/ParkRepository;", "typeToItalianMap", "", "", "getInstance", "apiKey", "weatherApiKey", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.trovaparco.data.repository.ParkRepository getInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
        java.lang.String weatherApiKey) {
            return null;
        }
    }
}