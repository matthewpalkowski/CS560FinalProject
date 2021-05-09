package com.example.finalproject

data class Address(
        val streetAddress: String,
        val city: String,
        val state: String,
        val country: String,
        val zipCode: String)

data class GeoCodeAddressComponent(
        val long_name : String,
        val short_name : String,
        val types : List<String>)

data class GeocodeLocation(val lat : Double, val lng : Double)

data class GoogleGeocodeResults(
        val results : List<GeocodeResult>,
        val status : String)

data class GeocodeResult(
        val address_components : List<GeoCodeAddressComponent>,
        val formatted_address : String,
        val geometry: GeocodeResultGeometry,
        val types : List<String>)

data class GeocodeResultGeometry(val location : GeocodeLocation)

data class GeoCodeSearchableAddress(
        val streetAddress: String,
        val city: String,
        val state: String)

data class SavedAddressItem(val address: Address, val imgURL : String)