package com.example.finalproject.databaseobjects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var streetAddress: String,
    var city: String,
    var state: String,
    var country: String,
    var zip: String,
    var imageURL: String) //Might be just an image directly

//TODO add all other relevant params