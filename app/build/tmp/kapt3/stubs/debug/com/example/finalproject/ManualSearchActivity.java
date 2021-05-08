package com.example.finalproject;

import java.lang.System;

/**
 * @author Matthew Palkowski
 */
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00049:;<B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\"H\u0003J\b\u0010&\u001a\u00020\"H\u0003J\u0012\u0010\'\u001a\u00020\"2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010(\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0015J-\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u00062\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040.2\u0006\u0010/\u001a\u000200H\u0016\u00a2\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000fH\u0002J\b\u00104\u001a\u00020 H\u0002J\b\u00105\u001a\u00020 H\u0002J\b\u00106\u001a\u00020 H\u0002J\f\u00107\u001a\u00020\"*\u000208H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Lcom/example/finalproject/ManualSearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "GPS", "", "REQUEST_CODE", "", "TOAST_TEXT", "UPDATE_DIST", "", "UPDATE_TIME", "", "currentAddress", "Lcom/example/finalproject/Address;", "currentLocation", "Landroid/location/Location;", "focusListener", "Lcom/example/finalproject/ManualSearchActivity$OnFocusListener;", "gpsButton", "Landroid/widget/Button;", "spinnerState", "Landroid/widget/Spinner;", "touchListener", "Lcom/example/finalproject/ManualSearchActivity$TouchListener;", "txtInputCity", "Lcom/google/android/material/textfield/TextInputEditText;", "txtInputStreet", "txtLayoutCity", "Lcom/google/android/material/textfield/TextInputLayout;", "txtLayoutStreetAddress", "generateQueryString", "reverseGeo", "", "generateWarningDialog", "", "title", "message", "getGPSListenerResults", "getGPSLocation", "getGeocode", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "updateLocation", "location", "validAddress", "validCity", "validState", "hideKeyboard", "Landroid/view/View;", "ButtonListener", "GPSListener", "OnFocusListener", "TouchListener", "app_debug"})
public final class ManualSearchActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String GPS = "gps";
    private final java.lang.String TOAST_TEXT = "GPS location found";
    private final long UPDATE_TIME = 0L;
    private final float UPDATE_DIST = 0.0F;
    private final int REQUEST_CODE = 10;
    private android.widget.Button gpsButton;
    private android.widget.Spinner spinnerState;
    private com.google.android.material.textfield.TextInputLayout txtLayoutCity;
    private com.google.android.material.textfield.TextInputLayout txtLayoutStreetAddress;
    private com.google.android.material.textfield.TextInputEditText txtInputCity;
    private com.google.android.material.textfield.TextInputEditText txtInputStreet;
    private com.example.finalproject.ManualSearchActivity.TouchListener touchListener;
    private com.example.finalproject.ManualSearchActivity.OnFocusListener focusListener;
    private com.example.finalproject.Address currentAddress;
    private android.location.Location currentLocation;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.String generateQueryString(boolean reverseGeo) {
        return null;
    }
    
    private final void generateWarningDialog(java.lang.String title, java.lang.String message) {
    }
    
    private final void getGeocode(boolean reverseGeo) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void getGPSListenerResults() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final void getGPSLocation() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final boolean validAddress() {
        return false;
    }
    
    private final boolean validCity() {
        return false;
    }
    
    private final boolean validState() {
        return false;
    }
    
    private final void updateLocation(android.location.Location location) {
    }
    
    private final void hideKeyboard(android.view.View $this$hideKeyboard) {
    }
    
    public ManualSearchActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/finalproject/ManualSearchActivity$TouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/example/finalproject/ManualSearchActivity;)V", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_debug"})
    public final class TouchListener implements android.view.View.OnTouchListener {
        
        @java.lang.Override()
        public boolean onTouch(@org.jetbrains.annotations.Nullable()
        android.view.View v, @org.jetbrains.annotations.Nullable()
        android.view.MotionEvent event) {
            return false;
        }
        
        public TouchListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/ManualSearchActivity$ButtonListener;", "Landroid/view/View$OnClickListener;", "(Lcom/example/finalproject/ManualSearchActivity;)V", "onClick", "", "v", "Landroid/view/View;", "app_debug"})
    final class ButtonListener implements android.view.View.OnClickListener {
        
        @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public ButtonListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/finalproject/ManualSearchActivity$OnFocusListener;", "Landroid/view/View$OnFocusChangeListener;", "(Lcom/example/finalproject/ManualSearchActivity;)V", "onFocusChange", "", "v", "Landroid/view/View;", "hasFocus", "", "app_debug"})
    final class OnFocusListener implements android.view.View.OnFocusChangeListener {
        
        @java.lang.Override()
        public void onFocusChange(@org.jetbrains.annotations.Nullable()
        android.view.View v, boolean hasFocus) {
        }
        
        public OnFocusListener() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/ManualSearchActivity$GPSListener;", "Landroid/location/LocationListener;", "(Lcom/example/finalproject/ManualSearchActivity;)V", "onLocationChanged", "", "location", "Landroid/location/Location;", "app_debug"})
    final class GPSListener implements android.location.LocationListener {
        
        @java.lang.Override()
        public void onLocationChanged(@org.jetbrains.annotations.NotNull()
        android.location.Location location) {
        }
        
        public GPSListener() {
            super();
        }
    }
}