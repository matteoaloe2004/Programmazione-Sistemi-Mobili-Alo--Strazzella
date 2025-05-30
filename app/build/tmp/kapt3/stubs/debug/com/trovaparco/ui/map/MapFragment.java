package com.trovaparco.ui.map;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0018H\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020\u0018H\u0002J\b\u00100\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/trovaparco/ui/map/MapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "()V", "fabFavorites", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "markers", "", "", "Lcom/google/android/gms/maps/model/Marker;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "tvWeatherConditionMap", "Landroid/widget/TextView;", "tvWeatherTempMap", "viewModel", "Lcom/trovaparco/viewmodel/MapViewModel;", "checkLocationPermission", "", "displayParksOnMap", "parks", "", "Lcom/trovaparco/data/model/Park;", "enableMyLocation", "hasLocationPermissions", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "map", "onMarkerClick", "marker", "onViewCreated", "view", "requestLocationPermissions", "shouldShowRequestPermissionRationale", "Companion", "app_debug"})
public final class MapFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {
    private com.trovaparco.viewmodel.MapViewModel viewModel;
    private com.google.android.gms.location.FusedLocationProviderClient fusedLocationClient;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.GoogleMap googleMap;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, com.google.android.gms.maps.model.Marker> markers = null;
    private com.google.android.material.floatingactionbutton.FloatingActionButton fabFavorites;
    private android.widget.TextView tvWeatherTempMap;
    private android.widget.TextView tvWeatherConditionMap;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] LOCATION_PERMISSIONS = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    @org.jetbrains.annotations.NotNull()
    public static final com.trovaparco.ui.map.MapFragment.Companion Companion = null;
    
    public MapFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeViewModel() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap map) {
    }
    
    private final void checkLocationPermission() {
    }
    
    private final boolean hasLocationPermissions() {
        return false;
    }
    
    private final boolean shouldShowRequestPermissionRationale() {
        return false;
    }
    
    private final void requestLocationPermissions() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void enableMyLocation() {
    }
    
    private final void displayParksOnMap(java.util.List<com.trovaparco.data.model.Park> parks) {
    }
    
    @java.lang.Override()
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/trovaparco/ui/map/MapFragment$Companion;", "", "()V", "LOCATION_PERMISSIONS", "", "", "[Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}