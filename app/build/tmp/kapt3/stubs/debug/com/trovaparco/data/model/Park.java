package com.trovaparco.data.model;

/**
 * Data model for park information.
 * This model represents a park with all its attributes.
 */
@com.squareup.moshi.JsonClass(generateAdapter = true)
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0003\u0010\r\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u000fH\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003Jy\u0010)\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\b\b\u0003\u0010\t\u001a\u00020\u00032\u000e\b\u0003\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u000e\b\u0003\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u00060"}, d2 = {"Lcom/trovaparco/data/model/Park;", "", "id", "", "name", "description", "latitude", "", "longitude", "address", "facilities", "", "images", "openingHours", "rating", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;F)V", "getAddress", "()Ljava/lang/String;", "getDescription", "getFacilities", "()Ljava/util/List;", "getId", "getImages", "getLatitude", "()D", "getLongitude", "getName", "getOpeningHours", "getRating", "()F", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Park {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String address = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> facilities = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> images = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String openingHours = null;
    private final float rating = 0.0F;
    
    public Park(@com.squareup.moshi.Json(name = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "description")
    @org.jetbrains.annotations.NotNull()
    java.lang.String description, @com.squareup.moshi.Json(name = "latitude")
    double latitude, @com.squareup.moshi.Json(name = "longitude")
    double longitude, @com.squareup.moshi.Json(name = "address")
    @org.jetbrains.annotations.NotNull()
    java.lang.String address, @com.squareup.moshi.Json(name = "facilities")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> facilities, @com.squareup.moshi.Json(name = "images")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> images, @com.squareup.moshi.Json(name = "opening_hours")
    @org.jetbrains.annotations.NotNull()
    java.lang.String openingHours, @com.squareup.moshi.Json(name = "rating")
    float rating) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getFacilities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getImages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOpeningHours() {
        return null;
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component10() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.trovaparco.data.model.Park copy(@com.squareup.moshi.Json(name = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @com.squareup.moshi.Json(name = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @com.squareup.moshi.Json(name = "description")
    @org.jetbrains.annotations.NotNull()
    java.lang.String description, @com.squareup.moshi.Json(name = "latitude")
    double latitude, @com.squareup.moshi.Json(name = "longitude")
    double longitude, @com.squareup.moshi.Json(name = "address")
    @org.jetbrains.annotations.NotNull()
    java.lang.String address, @com.squareup.moshi.Json(name = "facilities")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> facilities, @com.squareup.moshi.Json(name = "images")
    @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> images, @com.squareup.moshi.Json(name = "opening_hours")
    @org.jetbrains.annotations.NotNull()
    java.lang.String openingHours, @com.squareup.moshi.Json(name = "rating")
    float rating) {
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