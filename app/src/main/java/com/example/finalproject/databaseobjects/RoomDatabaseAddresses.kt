package com.example.finalproject.databaseobjects

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AddressEntity::class], version = 1)
abstract class RoomDatabaseAddresses : RoomDatabase() {
    abstract fun contactDAO() : AddressDAO

    //Enforces singleton policy
    companion object {
        @Volatile
        private var INSTANCE: RoomDatabaseAddresses? = null
        private const val dbName : String = "address_database"

        fun getAddressDatabase(context: Context) : RoomDatabaseAddresses{
            val temp = INSTANCE
            if(temp != null)
                return temp
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabaseAddresses:: class.java,
                    dbName)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}