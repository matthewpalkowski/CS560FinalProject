package com.example.finalproject.databaseobjects

import androidx.room.*

@Dao
interface AddressDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress()

    @Update
    fun updateAddress()

    @Delete
    fun deleteAddress()

    @Query("SELECT * FROM address_table")
    fun viewAllAddresses()

    @Query("SELECT * FROM address_table WHERE id LIKE:addressId")
    fun getAddress(addressId: Int) : AddressEntity
}