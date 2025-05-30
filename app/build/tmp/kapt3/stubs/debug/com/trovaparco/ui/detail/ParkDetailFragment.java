package com.trovaparco.ui.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J$\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/trovaparco/ui/detail/ParkDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnBackToMap", "Landroid/widget/Button;", "btnToggleFavorite", "ivParkImage", "Landroid/widget/ImageView;", "parkId", "", "tvParkAddress", "Landroid/widget/TextView;", "tvParkDistance", "tvParkFacilities", "tvParkName", "tvParkOpeningHours", "tvParkRating", "tvWeatherCondition", "tvWeatherHumidity", "tvWeatherTemperature", "viewModel", "Lcom/trovaparco/viewmodel/MapViewModel;", "displayParkDetails", "", "park", "Lcom/trovaparco/data/model/Park;", "initializeViews", "view", "Landroid/view/View;", "observeViewModel", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "updateDistance", "userLocation", "Landroid/location/Location;", "app_debug"})
public final class ParkDetailFragment extends androidx.fragment.app.Fragment {
    private com.trovaparco.viewmodel.MapViewModel viewModel;
    private android.widget.TextView tvParkName;
    private android.widget.TextView tvParkAddress;
    private android.widget.TextView tvParkOpeningHours;
    private android.widget.TextView tvParkFacilities;
    private android.widget.TextView tvParkRating;
    private android.widget.TextView tvParkDistance;
    private android.widget.ImageView ivParkImage;
    private android.widget.Button btnBackToMap;
    private android.widget.Button btnToggleFavorite;
    private android.widget.TextView tvWeatherCondition;
    private android.widget.TextView tvWeatherTemperature;
    private android.widget.TextView tvWeatherHumidity;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String parkId = "";
    
    public ParkDetailFragment() {
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void observeViewModel() {
    }
    
    private final void displayParkDetails(com.trovaparco.data.model.Park park) {
    }
    
    private final void updateDistance(android.location.Location userLocation, com.trovaparco.data.model.Park park) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}