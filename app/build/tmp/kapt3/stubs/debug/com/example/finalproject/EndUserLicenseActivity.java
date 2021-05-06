package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/finalproject/EndUserLicenseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnAccept", "Landroid/widget/Button;", "btnReject", "eulaTextView", "Landroid/widget/TextView;", "onClickListener", "Landroid/view/View$OnClickListener;", "generateDialog", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ButtonListener", "ScrollListener", "app_debug"})
public final class EndUserLicenseActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.TextView eulaTextView;
    private android.widget.Button btnReject;
    private android.widget.Button btnAccept;
    private android.view.View.OnClickListener onClickListener;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void generateDialog() {
    }
    
    public EndUserLicenseActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/example/finalproject/EndUserLicenseActivity$ButtonListener;", "Landroid/view/View$OnClickListener;", "(Lcom/example/finalproject/EndUserLicenseActivity;)V", "onClick", "", "v", "Landroid/view/View;", "app_debug"})
    final class ButtonListener implements android.view.View.OnClickListener {
        
        @java.lang.Override()
        public void onClick(@org.jetbrains.annotations.Nullable()
        android.view.View v) {
        }
        
        public ButtonListener() {
            super();
        }
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/example/finalproject/EndUserLicenseActivity$ScrollListener;", "Landroid/view/View$OnScrollChangeListener;", "(Lcom/example/finalproject/EndUserLicenseActivity;)V", "onScrollChange", "", "v", "Landroid/view/View;", "scrollX", "", "scrollY", "oldScrollX", "oldScrollY", "app_debug"})
    final class ScrollListener implements android.view.View.OnScrollChangeListener {
        
        @java.lang.Override()
        public void onScrollChange(@org.jetbrains.annotations.Nullable()
        android.view.View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        }
        
        public ScrollListener() {
            super();
        }
    }
}