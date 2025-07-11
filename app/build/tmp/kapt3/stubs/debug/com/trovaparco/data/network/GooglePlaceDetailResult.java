package com.trovaparco.data.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\rH\u00c6\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u00c6\u0003Jt\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019\u00a8\u0006/"}, d2 = {"Lcom/trovaparco/data/network/GooglePlaceDetailResult;", "", "place_id", "", "name", "rating", "", "formatted_address", "opening_hours", "Lcom/trovaparco/data/network/OpeningHours;", "types", "", "geometry", "Lcom/trovaparco/data/network/Geometry;", "photos", "Lcom/trovaparco/data/network/Photo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/trovaparco/data/network/OpeningHours;Ljava/util/List;Lcom/trovaparco/data/network/Geometry;Ljava/util/List;)V", "getFormatted_address", "()Ljava/lang/String;", "getGeometry", "()Lcom/trovaparco/data/network/Geometry;", "getName", "getOpening_hours", "()Lcom/trovaparco/data/network/OpeningHours;", "getPhotos", "()Ljava/util/List;", "getPlace_id", "getRating", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lcom/trovaparco/data/network/OpeningHours;Ljava/util/List;Lcom/trovaparco/data/network/Geometry;Ljava/util/List;)Lcom/trovaparco/data/network/GooglePlaceDetailResult;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class GooglePlaceDetailResult {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String place_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float rating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String formatted_address = null;
    @org.jetbrains.annotations.Nullable()
    private final com.trovaparco.data.network.OpeningHours opening_hours = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> types = null;
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.network.Geometry geometry = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.trovaparco.data.network.Photo> photos = null;
    
    public GooglePlaceDetailResult(@org.jetbrains.annotations.NotNull()
    java.lang.String place_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    java.lang.String formatted_address, @org.jetbrains.annotations.Nullable()
    com.trovaparco.data.network.OpeningHours opening_hours, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> types, @org.jetbrains.annotations.NotNull()
    com.trovaparco.data.network.Geometry geometry, @org.jetbrains.annotations.Nullable()
    java.util.List<com.trovaparco.data.network.Photo> photos) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPlace_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFormatted_address() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.trovaparco.data.network.OpeningHours getOpening_hours() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.trovaparco.data.network.Geometry getGeometry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.trovaparco.data.network.Photo> getPhotos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.trovaparco.data.network.OpeningHours component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.trovaparco.data.network.Geometry component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.trovaparco.data.network.Photo> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.trovaparco.data.network.GooglePlaceDetailResult copy(@org.jetbrains.annotations.NotNull()
    java.lang.String place_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.Float rating, @org.jetbrains.annotations.Nullable()
    java.lang.String formatted_address, @org.jetbrains.annotations.Nullable()
    com.trovaparco.data.network.OpeningHours opening_hours, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> types, @org.jetbrains.annotations.NotNull()
    com.trovaparco.data.network.Geometry geometry, @org.jetbrains.annotations.Nullable()
    java.util.List<com.trovaparco.data.network.Photo> photos) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}