package com.example.finalproject.databaseobjects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    //TODO add all relevant params
)