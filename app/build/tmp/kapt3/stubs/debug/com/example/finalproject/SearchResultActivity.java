package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/finalproject/SearchResultActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addressThumbnail", "Landroid/widget/ImageView;", "listener", "Lcom/example/finalproject/SearchResultActivity$ButtonListener;", "txtCity", "Landroid/widget/TextView;", "txtCountry", "txtState", "txtStreetAddress", "txtZip", "generateId", "", "address", "Lcom/example/finalproject/Address;", "getSavedAddressesIntent", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "populateResultData", "saveResult", "ButtonListener", "app_debug"})
public final class SearchResultActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.TextView txtCity;
    private android.widget.TextView txtCountry;
    private android.widget.TextView txtState;
    private android.widget.TextView txtStreetAddress;
    private android.widget.TextView txtZip;
    private android.widget.ImageView addressThumbnail;
    private com.example.finalproject.SearchResultActivity.ButtonListener listener;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void populateResultData() {
    }
    
    private final java.lang.String generateId(com.example.finalproject.Address address) {
        return null;
    }
    
    private final void saveResult() {
    }
    
    private final android.content.Intent getSavedAddressesIntent() {
        return null;
    }
    
    public SearchResultActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/SearchResultActivity$ButtonListener;", "Landroid/view/View$OnClickListener;", "(Lcom/example/finalproject/SearchResultActivity;)V", "onClick", "", "v", "Landroid/view/View;", "app_debug"})
    final class ButtonListener implements android.view.View.OnClickListener {
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public ButtonListener() {
            super();
        }
    }
}