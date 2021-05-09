package com.example.finalproject.databaseobjects

import androidx.room.Database

@Database(entities = [AddressEntity::class], version = 1)
abstract class RoomDatabaseAddresses {
    abstract fun contactDAO() : AddressDAO
}