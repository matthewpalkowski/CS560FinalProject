package com.example.finalproject

import retrofit2.http.POST

interface IGoogleGeolocation {

    @POST("")
    fun getGeolocaiton()

    @POST("")
    fun getReverseGeolocation()
}