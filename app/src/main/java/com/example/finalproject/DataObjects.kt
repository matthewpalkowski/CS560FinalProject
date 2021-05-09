package com.example.finalproject

import android.os.Parcel
import android.os.Parcelable

    data class Address(
        val streetAddress: String?,
        val city: String?,
        val state: String?,
        val country: String?,
        val zipCode: String?)
    : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(streetAddress)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(country)
        parcel.writeString(zipCode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}

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