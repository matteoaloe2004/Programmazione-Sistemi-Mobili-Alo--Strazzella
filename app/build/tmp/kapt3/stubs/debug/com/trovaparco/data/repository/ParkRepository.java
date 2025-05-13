package com.trovaparco.data.repository;

/**
 * Repository for park data.
 * Acts as a single source of truth for park data, abstracting the data source.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository;", "", "apiService", "Lcom/trovaparco/data/network/ParkApiService;", "(Lcom/trovaparco/data/network/ParkApiService;)V", "getNearbyParks", "Lkotlin/Result;", "", "Lcom/trovaparco/data/model/Park;", "latitude", "", "longitude", "radius", "", "getNearbyParks-BWLJW6A", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParkDetails", "parkId", "", "getParkDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class ParkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.network.ParkApiService apiService = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.trovaparco.data.repository.ParkRepository instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.data.repository.ParkRepository.Companion Companion = null;
    
    public ParkRepository(@org.jetbrains.annotations.NotNull()
    com.trovaparco.data.network.ParkApiService apiService) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository$Companion;", "", "()V", "instance", "Lcom/trovaparco/data/repository/ParkRepository;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Get singleton instance of ParkRepository.
         */
        @org.jetbrains.annotations.NotNull()
        public final com.trovaparco.data.repository.ParkRepository getInstance() {
            return null;
        }
    }
}