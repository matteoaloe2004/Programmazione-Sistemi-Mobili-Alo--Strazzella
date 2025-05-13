package com.trovaparco.viewmodel;

/**
 * ViewModel for the map screen.
 * Handles data flow between repository and UI.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\tJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013\u00a8\u0006\'"}, d2 = {"Lcom/trovaparco/viewmodel/MapViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/trovaparco/data/repository/ParkRepository;", "(Lcom/trovaparco/data/repository/ParkRepository;)V", "_currentLocation", "Landroidx/lifecycle/MutableLiveData;", "Landroid/location/Location;", "_error", "", "_isLoading", "", "_nearbyParks", "", "Lcom/trovaparco/data/model/Park;", "_selectedPark", "currentLocation", "Landroidx/lifecycle/LiveData;", "getCurrentLocation", "()Landroidx/lifecycle/LiveData;", "error", "getError", "isLoading", "nearbyParks", "getNearbyParks", "selectedPark", "getSelectedPark", "clearSelectedPark", "", "fetchNearbyParks", "latitude", "", "longitude", "radius", "", "selectPark", "parkId", "updateLocation", "location", "app_debug"})
public final class MapViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.trovaparco.data.repository.ParkRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<android.location.Location> _currentLocation = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<android.location.Location> currentLocation = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.trovaparco.data.model.Park>> _nearbyParks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.trovaparco.data.model.Park>> nearbyParks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.trovaparco.data.model.Park> _selectedPark = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.trovaparco.data.model.Park> selectedPark = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    
    public MapViewModel(@org.jetbrains.annotations.NotNull()
    com.trovaparco.data.repository.ParkRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<android.location.Location> getCurrentLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.trovaparco.data.model.Park>> getNearbyParks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.trovaparco.data.model.Park> getSelectedPark() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    /**
     * Update current location and fetch nearby parks.
     *
     * @param location New location
     */
    public final void updateLocation(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    /**
     * Fetch nearby parks from the repository.
     *
     * @param latitude Current latitude
     * @param longitude Current longitude
     * @param radius Search radius in meters
     */
    public final void fetchNearbyParks(double latitude, double longitude, int radius) {
    }
    
    /**
     * Select a park to view its details.
     *
     * @param parkId ID of the selected park
     */
    public final void selectPark(@org.jetbrains.annotations.NotNull()
    java.lang.String parkId) {
    }
    
    /**
     * Clear the selected park.
     */
    public final void clearSelectedPark() {
    }
    
    public MapViewModel() {
        super();
    }
}