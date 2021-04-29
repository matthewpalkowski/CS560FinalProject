package com.example.finalproject

data class SavedAddressItem(val address: Address, val imgURL : String)

data class Address(
    val streetAddress: String,
    val city: String,
    val state: String,
    val zipCode: String)
