package com.trovaparco.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\b2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/trovaparco/adapter/ParksAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/trovaparco/adapter/ParksAdapter$ParkViewHolder;", "parks", "", "Lcom/trovaparco/data/model/Park;", "onParkClick", "Lkotlin/Function1;", "", "onRemoveClick", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateParks", "newParks", "ParkViewHolder", "app_debug"})
public final class ParksAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.trovaparco.adapter.ParksAdapter.ParkViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.trovaparco.data.model.Park> parks;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.trovaparco.data.model.Park, kotlin.Unit> onParkClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.trovaparco.data.model.Park, kotlin.Unit> onRemoveClick = null;
    
    public ParksAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.trovaparco.data.model.Park> parks, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.trovaparco.data.model.Park, kotlin.Unit> onParkClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.trovaparco.data.model.Park, kotlin.Unit> onRemoveClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.trovaparco.adapter.ParksAdapter.ParkViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.trovaparco.adapter.ParksAdapter.ParkViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateParks(@org.jetbrains.annotations.NotNull()
    java.util.List<com.trovaparco.data.model.Park> newParks) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/trovaparco/adapter/ParksAdapter$ParkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/trovaparco/adapter/ParksAdapter;Landroid/view/View;)V", "btnRemoveFavorite", "Landroid/widget/ImageButton;", "tvParkName", "Landroid/widget/TextView;", "bind", "", "park", "Lcom/trovaparco/data/model/Park;", "app_debug"})
    public final class ParkViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvParkName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageButton btnRemoveFavorite = null;
        
        public ParkViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.trovaparco.data.model.Park park) {
        }
    }
}