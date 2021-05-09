package com.example.finalproject.databaseobjects

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AddressEntity::class], version = 1)
abstract class RoomDatabaseAddresses : RoomDatabase() {
    abstract fun contactDAO() : AddressDAO
}