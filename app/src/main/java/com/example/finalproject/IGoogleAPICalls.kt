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

    @GET("elevation/json")
    fun getElevation(
        @Query("locations") location: String,
        @Query("key") key : String)
        : Observable<ElevationResult>
}