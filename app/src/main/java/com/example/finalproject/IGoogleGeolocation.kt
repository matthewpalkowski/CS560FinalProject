package com.example.finalproject

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface IGoogleGeolocation {

    //FIXME - failing to build the query - error with the FIELD tag
    @POST("json")
    fun getGeolocaiton(
        @Field("address") address: String,
        @Field("key") key : String)
        : Call<GoogleGeocodeResults>

    //FIXME - failing to build the query - error with the FIELD tag
    @POST("json")
    fun getReverseGeolocation(
        @Field("latlang") coodinates: String,
        @Field("key") key: String)
        : Call<GoogleGeocodeResults>
}