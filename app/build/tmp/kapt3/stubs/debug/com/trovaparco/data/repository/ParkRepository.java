package com.trovaparco.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J<\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository;", "", "apiService", "Lcom/trovaparco/data/network/ParkApiService;", "apiKey", "", "(Lcom/trovaparco/data/network/ParkApiService;Ljava/lang/String;)V", "getNearbyParks", "Lkotlin/Result;", "", "Lcom/trovaparco/data/model/Park;", "latitude", "", "longitude", "radius", "", "getNearbyParks-BWLJW6A", "(DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getParkDetails", "parkId", "getParkDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class ParkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.network.ParkApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = null;
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.trovaparco.data.repository.ParkRepository instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.data.repository.ParkRepository.Companion Companion = null;
    
    private ParkRepository(com.trovaparco.data.network.ParkApiService apiService, java.lang.String apiKey) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/trovaparco/data/repository/ParkRepository$Companion;", "", "()V", "instance", "Lcom/trovaparco/data/repository/ParkRepository;", "getInstance", "apiKey", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.trovaparco.data.repository.ParkRepository getInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String apiKey) {
            return null;
        }
    }
}