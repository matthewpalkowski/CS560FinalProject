package com.example.finalproject.databaseobjects;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDatabaseAddresses_Impl extends RoomDatabaseAddresses {
  private volatile AddressDAO _addressDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `address_table` (`id` TEXT NOT NULL, `streetAddress` TEXT NOT NULL, `city` TEXT NOT NULL, `state` TEXT NOT NULL, `country` TEXT NOT NULL, `zip` TEXT NOT NULL, `imageURL` TEXT NOT NULL, `elevation` TEXT NOT NULL, PRIMARY KEY(`streetAddress`, `city`, `state`, `country`, `zip`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '92d32aa947157fe7fa63affd0f658467')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `address_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddressTable = new HashMap<String, TableInfo.Column>(8);
        _columnsAddressTable.put("id", new TableInfo.Column("id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("streetAddress", new TableInfo.Column("streetAddress", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("city", new TableInfo.Column("city", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("state", new TableInfo.Column("state", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("country", new TableInfo.Column("country", "TEXT", true, 4, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("zip", new TableInfo.Column("zip", "TEXT", true, 5, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("imageURL", new TableInfo.Column("imageURL", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressTable.put("elevation", new TableInfo.Column("elevation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddressTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddressTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddressTable = new TableInfo("address_table", _columnsAddressTable, _foreignKeysAddressTable, _indicesAddressTable);
        final TableInfo _existingAddressTable = TableInfo.read(_db, "address_table");
        if (! _infoAddressTable.equals(_existingAddressTable)) {
          return new RoomOpenHelper.ValidationResult(false, "address_table(com.example.finalproject.databaseobjects.AddressEntity).\n"
                  + " Expected:\n" + _infoAddressTable + "\n"
                  + " Found:\n" + _existingAddressTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "92d32aa947157fe7fa63affd0f658467", "9df766279c688acdf4c7d89a12a04418");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "address_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `address_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public AddressDAO contactDAO() {
    if (_addressDAO != null) {
      return _addressDAO;
    } else {
      synchronized(this) {
        if(_addressDAO == null) {
          _addressDAO = new AddressDAO_Impl(this);
        }
        return _addressDAO;
      }
    }
  }
}
