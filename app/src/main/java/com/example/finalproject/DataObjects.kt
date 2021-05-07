package com.example.finalproject

data class Address(
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String)

data class GoogleGeocodeResults(val results : List<GeocodeResult>, val status : String)

data class GeocodeResult(val formattedAddress : String, val geometry: GeocodeResultGeometry)

data class GeocodeResultGeometry(val locaiton : GeocodeLocation)

data class GeocodeLocation(val lat : Double, val lng : Double)

data class SavedAddressItem(val address: Address, val imgURL : String)

