package com.example.finalproject.databaseobjects

import androidx.room.*

@Dao
interface AddressDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(address : AddressEntity)

    @Update
    fun updateAddress(address : AddressEntity)

    @Delete
    fun deleteAddress(address: AddressEntity)

    @Query("SELECT * FROM address_table")
    fun viewAllAddresses() : List<AddressEntity>

    @Query("SELECT * FROM address_table WHERE id LIKE:addressId")
    fun getAddress(addressId: String) : List<AddressEntity>
}