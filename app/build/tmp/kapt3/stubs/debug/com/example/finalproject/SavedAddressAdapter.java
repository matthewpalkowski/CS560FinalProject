package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0014\u0015\u0016B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/finalproject/SavedAddressAdapter$AddressHolder;", "addressList", "", "Lcom/example/finalproject/SavedAddressItem;", "(Ljava/util/List;)V", "OpenItem", "", "v", "Landroid/view/View;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AddressHolder", "LongPressListener", "ShortPressListener", "app_debug"})
public final class SavedAddressAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.finalproject.SavedAddressAdapter.AddressHolder> {
    private final java.util.List<com.example.finalproject.SavedAddressItem> addressList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.finalproject.SavedAddressAdapter.AddressHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.finalproject.SavedAddressAdapter.AddressHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void OpenItem(android.view.View v) {
    }
    
    public SavedAddressAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.finalproject.SavedAddressItem> addressList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter$AddressHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgAddressThumbnail", "Landroid/widget/ImageView;", "getImgAddressThumbnail", "()Landroid/widget/ImageView;", "txtCity", "Landroid/widget/TextView;", "getTxtCity", "()Landroid/widget/TextView;", "txtState", "getTxtState", "txtStreetAddress", "getTxtStreetAddress", "txtZip", "getTxtZip", "app_debug"})
    public static final class AddressHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgAddressThumbnail = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtStreetAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtCity = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtState = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtZip = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgAddressThumbnail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtStreetAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtCity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtState() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtZip() {
            return null;
        }
        
        public AddressHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter$ShortPressListener;", "Landroid/view/View$OnClickListener;", "(Lcom/example/finalproject/SavedAddressAdapter;)V", "onClick", "", "v", "Landroid/view/View;", "app_debug"})
    final class ShortPressListener implements android.view.View.OnClickListener {
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public ShortPressListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter$LongPressListener;", "Landroid/view/View$OnLongClickListener;", "(Lcom/example/finalproject/SavedAddressAdapter;)V", "onLongClick", "", "v", "Landroid/view/View;", "app_debug"})
    final class LongPressListener implements android.view.View.OnLongClickListener {
        
        @java.lang.Override()
        public boolean onLongClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
            return false;
        }
        
        public LongPressListener() {
            super();
        }
    }
}