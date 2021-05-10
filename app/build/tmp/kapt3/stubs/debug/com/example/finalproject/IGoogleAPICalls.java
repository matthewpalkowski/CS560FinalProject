package com.example.finalproject;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\'J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\'J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0006H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/finalproject/IGoogleAPICalls;", "", "getElevation", "Lio/reactivex/rxjava3/core/Observable;", "", "params", "", "getGeocode", "Lretrofit2/Call;", "Lcom/example/finalproject/GoogleGeocodeResults;", "getStreetViewImage", "app_debug"})
public abstract interface IGoogleAPICalls {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "geocode/json")
    public abstract retrofit2.Call<com.example.finalproject.GoogleGeocodeResults> getGeocode(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap(encoded = true)
    java.util.Map<java.lang.String, java.lang.String> params);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "streetview")
    public abstract io.reactivex.rxjava3.core.Observable<java.lang.String> getStreetViewImage(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap(encoded = true)
    java.util.Map<java.lang.String, java.lang.String> params);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "streetview")
    public abstract io.reactivex.rxjava3.core.Observable<java.lang.String> getElevation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.QueryMap(encoded = true)
    java.util.Map<java.lang.String, java.lang.String> params);
}