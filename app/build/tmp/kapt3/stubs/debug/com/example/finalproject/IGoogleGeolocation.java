package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'\u00a8\u0006\n"}, d2 = {"Lcom/example/finalproject/IGoogleGeolocation;", "", "getGeolocaiton", "Lretrofit2/Call;", "Lcom/example/finalproject/GoogleGeocodeResults;", "address", "", "key", "getReverseGeolocation", "coodinates", "app_debug"})
public abstract interface IGoogleGeolocation {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "json")
    public abstract retrofit2.Call<com.example.finalproject.GoogleGeocodeResults> getGeolocaiton(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "address")
    java.lang.String address, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "key")
    java.lang.String key);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "json")
    public abstract retrofit2.Call<com.example.finalproject.GoogleGeocodeResults> getReverseGeolocation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "latlang")
    java.lang.String coodinates, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "key")
    java.lang.String key);
}