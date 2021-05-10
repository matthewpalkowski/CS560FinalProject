package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u0000H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0014\u0010\u0019\u001a\u00020\u00132\n\u0010\u000f\u001a\u00060\u0002R\u00020\u0000H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/finalproject/SavedAddressAdapter$AddressHolder;", "addressList", "", "Lcom/example/finalproject/databaseobjects/AddressEntity;", "(Ljava/util/List;)V", "applicationContext", "Landroid/app/Application;", "getApplicationContext", "()Landroid/app/Application;", "setApplicationContext", "(Landroid/app/Application;)V", "generateAddress", "Lcom/example/finalproject/Address;", "holder", "getItemCount", "", "onBindViewHolder", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeItem", "AddressHolder", "app_debug"})
public final class SavedAddressAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.finalproject.SavedAddressAdapter.AddressHolder> {
    public android.app.Application applicationContext;
    private final java.util.List<com.example.finalproject.databaseobjects.AddressEntity> addressList = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApplicationContext() {
        return null;
    }
    
    public final void setApplicationContext(@org.jetbrains.annotations.NotNull()
    android.app.Application p0) {
    }
    
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
    
    private final com.example.finalproject.Address generateAddress(com.example.finalproject.SavedAddressAdapter.AddressHolder holder) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    private final void removeItem(com.example.finalproject.SavedAddressAdapter.AddressHolder holder) {
    }
    
    public SavedAddressAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.finalproject.databaseobjects.AddressEntity> addressList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/example/finalproject/SavedAddressAdapter$AddressHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/finalproject/SavedAddressAdapter;Landroid/view/View;)V", "addressEntity", "Lcom/example/finalproject/databaseobjects/AddressEntity;", "getAddressEntity", "()Lcom/example/finalproject/databaseobjects/AddressEntity;", "setAddressEntity", "(Lcom/example/finalproject/databaseobjects/AddressEntity;)V", "imgAddressThumbnail", "Landroid/widget/ImageView;", "getImgAddressThumbnail", "()Landroid/widget/ImageView;", "txtCity", "Landroid/widget/TextView;", "getTxtCity", "()Landroid/widget/TextView;", "txtCountryAndZip", "getTxtCountryAndZip", "txtState", "getTxtState", "txtStreetAddress", "getTxtStreetAddress", "app_debug"})
    public final class AddressHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgAddressThumbnail = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtStreetAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtCity = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtState = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtCountryAndZip = null;
        public com.example.finalproject.databaseobjects.AddressEntity addressEntity;
        
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
        public final android.widget.TextView getTxtCountryAndZip() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.finalproject.databaseobjects.AddressEntity getAddressEntity() {
            return null;
        }
        
        public final void setAddressEntity(@org.jetbrains.annotations.NotNull()
        com.example.finalproject.databaseobjects.AddressEntity p0) {
        }
        
        public AddressHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}