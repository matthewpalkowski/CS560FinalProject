package com.example.finalproject

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface IGoogleGeolocation {

    @POST(".")
    fun getGeolocaiton(
        @Field("address") address: String,
        @Field("key") key : String)
        : Call<GoogleGeocodeResults>

    @POST(".")
    fun getReverseGeolocation(
        @Field("latlang") coodinates: String,
        @Field("key") key: String)
        : Call<GoogleGeocodeResults>
}