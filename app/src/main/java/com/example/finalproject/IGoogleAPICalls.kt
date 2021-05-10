package com.example.finalproject

import android.media.Image
import android.media.ThumbnailUtils
import android.provider.ContactsContract
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface IGoogleAPICalls {
    @GET("geocode/json")
    fun getGeocode(@QueryMap(encoded = true) params : Map<String,String>) : Call<GoogleGeocodeResults>

    @GET("streetview")
    fun getStreetViewImage(@QueryMap(encoded = true) params: Map<String, String>) : Observable<String>

    @GET("streetview")
    fun getElevation(@QueryMap(encoded = true) params: Map<String, String>) : Observable<ElevationResult>
}