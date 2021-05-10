package com.example.finalproject.databaseobjects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table",primaryKeys = arrayOf("streetAddress","city","state","country","zip"))
data class AddressEntity(
    var id : String,
    var streetAddress: String,
    var city: String,
    var state: String,
    var country: String,
    var zip: String,
    var imageURL: String,
    var elevation: String) //Might be just an image directly

//TODO add all other relevant params