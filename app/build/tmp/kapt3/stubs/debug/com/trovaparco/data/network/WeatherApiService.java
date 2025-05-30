package com.trovaparco.data.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ@\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\b2\b\b\u0003\u0010\n\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/trovaparco/data/network/WeatherApiService;", "", "getCurrentWeather", "Lcom/trovaparco/data/network/WeatherResponse;", "lat", "", "lon", "apiKey", "", "units", "lang", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface WeatherApiService {
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.data.network.WeatherApiService.Companion Companion = null;
    
    @retrofit2.http.GET(value = "data/2.5/weather")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentWeather(@retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "units")
    @org.jetbrains.annotations.NotNull()
    java.lang.String units, @retrofit2.http.Query(value = "lang")
    @org.jetbrains.annotations.NotNull()
    java.lang.String lang, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.trovaparco.data.network.WeatherResponse> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/trovaparco/data/network/WeatherApiService$Companion;", "", "()V", "BASE_URL", "", "create", "Lcom/trovaparco/data/network/WeatherApiService;", "app_debug"})
    public static final class Companion {
        @org.jetbrains.annotations.NotNull()
        private static final java.lang.String BASE_URL = "https://api.openweathermap.org/";
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.trovaparco.data.network.WeatherApiService create() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}