package com.example.finalproject.databaseobjects;

import java.lang.System;

@androidx.room.Database(entities = {com.example.finalproject.databaseobjects.AddressEntity.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/finalproject/databaseobjects/RoomDatabaseAddresses;", "Landroidx/room/RoomDatabase;", "()V", "contactDAO", "Lcom/example/finalproject/databaseobjects/AddressDAO;", "Companion", "app_debug"})
public abstract class RoomDatabaseAddresses extends androidx.room.RoomDatabase {
    private static volatile com.example.finalproject.databaseobjects.RoomDatabaseAddresses INSTANCE;
    private static final java.lang.String dbName = "address_database";
    @org.jetbrains.annotations.NotNull()
    public static final com.example.finalproject.databaseobjects.RoomDatabaseAddresses.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.finalproject.databaseobjects.AddressDAO contactDAO();
    
    public RoomDatabaseAddresses() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/finalproject/databaseobjects/RoomDatabaseAddresses$Companion;", "", "()V", "INSTANCE", "Lcom/example/finalproject/databaseobjects/RoomDatabaseAddresses;", "dbName", "", "getAddressDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.finalproject.databaseobjects.RoomDatabaseAddresses getAddressDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}