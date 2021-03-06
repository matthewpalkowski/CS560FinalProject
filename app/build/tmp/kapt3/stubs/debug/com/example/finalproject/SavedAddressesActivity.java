package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/finalproject/SavedAddressesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/finalproject/SavedAddressAdapter;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "savedAddresses", "Ljava/util/ArrayList;", "Lcom/example/finalproject/databaseobjects/AddressEntity;", "txtNoAddresses", "Landroid/widget/TextView;", "manageVisibility", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class SavedAddressesActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.finalproject.SavedAddressAdapter adapter;
    private androidx.recyclerview.widget.RecyclerView recycler;
    private android.widget.TextView txtNoAddresses;
    private final java.util.ArrayList<com.example.finalproject.databaseobjects.AddressEntity> savedAddresses = null;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void manageVisibility() {
    }
    
    public SavedAddressesActivity() {
        super();
    }
}