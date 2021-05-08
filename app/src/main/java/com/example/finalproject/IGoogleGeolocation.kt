package com.example.finalproject

import retrofit2.Call
import retrofit2.http.*

interface IGoogleGeolocation {
    @GET("json")
    fun getGeocode(@QueryMap(encoded = true) params : Map<String,String>) : Call<GoogleGeocodeResults>
}