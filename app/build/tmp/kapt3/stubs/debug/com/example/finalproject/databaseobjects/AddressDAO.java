package com.example.finalproject.databaseobjects;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'\u00a8\u0006\r"}, d2 = {"Lcom/example/finalproject/databaseobjects/AddressDAO;", "", "deleteAddress", "", "address", "Lcom/example/finalproject/databaseobjects/AddressEntity;", "getAddress", "", "addressId", "", "insertAddress", "updateAddress", "viewAllAddresses", "app_debug"})
public abstract interface AddressDAO {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAddress(@org.jetbrains.annotations.NotNull()
    com.example.finalproject.databaseobjects.AddressEntity address);
    
    @androidx.room.Update()
    public abstract void updateAddress(@org.jetbrains.annotations.NotNull()
    com.example.finalproject.databaseobjects.AddressEntity address);
    
    @androidx.room.Delete()
    public abstract void deleteAddress(@org.jetbrains.annotations.NotNull()
    com.example.finalproject.databaseobjects.AddressEntity address);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM address_table")
    public abstract java.util.List<com.example.finalproject.databaseobjects.AddressEntity> viewAllAddresses();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM address_table WHERE id LIKE:addressId")
    public abstract java.util.List<com.example.finalproject.databaseobjects.AddressEntity> getAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String addressId);
}