package com.example.finalproject.databaseobjects;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AddressDAO_Impl implements AddressDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AddressEntity> __insertionAdapterOfAddressEntity;

  private final EntityDeletionOrUpdateAdapter<AddressEntity> __deletionAdapterOfAddressEntity;

  private final EntityDeletionOrUpdateAdapter<AddressEntity> __updateAdapterOfAddressEntity;

  public AddressDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAddressEntity = new EntityInsertionAdapter<AddressEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `address_table` (`id`,`streetAddress`,`city`,`state`,`country`,`zip`,`imageURL`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddressEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getStreetAddress() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStreetAddress());
        }
        if (value.getCity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getState());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCountry());
        }
        if (value.getZip() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getZip());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImageURL());
        }
      }
    };
    this.__deletionAdapterOfAddressEntity = new EntityDeletionOrUpdateAdapter<AddressEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `address_table` WHERE `streetAddress` = ? AND `city` = ? AND `state` = ? AND `country` = ? AND `zip` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddressEntity value) {
        if (value.getStreetAddress() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getStreetAddress());
        }
        if (value.getCity() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getState());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCountry());
        }
        if (value.getZip() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getZip());
        }
      }
    };
    this.__updateAdapterOfAddressEntity = new EntityDeletionOrUpdateAdapter<AddressEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `address_table` SET `id` = ?,`streetAddress` = ?,`city` = ?,`state` = ?,`country` = ?,`zip` = ?,`imageURL` = ? WHERE `streetAddress` = ? AND `city` = ? AND `state` = ? AND `country` = ? AND `zip` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AddressEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getStreetAddress() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStreetAddress());
        }
        if (value.getCity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getState());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCountry());
        }
        if (value.getZip() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getZip());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImageURL());
        }
        if (value.getStreetAddress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStreetAddress());
        }
        if (value.getCity() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getCity());
        }
        if (value.getState() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getState());
        }
        if (value.getCountry() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCountry());
        }
        if (value.getZip() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getZip());
        }
      }
    };
  }

  @Override
  public void insertAddress(final AddressEntity address) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAddressEntity.insert(address);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAddress(final AddressEntity address) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAddressEntity.handle(address);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAddress(final AddressEntity address) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAddressEntity.handle(address);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<AddressEntity> viewAllAddresses() {
    final String _sql = "SELECT * FROM address_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStreetAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "streetAddress");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfZip = CursorUtil.getColumnIndexOrThrow(_cursor, "zip");
      final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "imageURL");
      final List<AddressEntity> _result = new ArrayList<AddressEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddressEntity _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpStreetAddress;
        _tmpStreetAddress = _cursor.getString(_cursorIndexOfStreetAddress);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        final String _tmpZip;
        _tmpZip = _cursor.getString(_cursorIndexOfZip);
        final String _tmpImageURL;
        _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
        _item = new AddressEntity(_tmpId,_tmpStreetAddress,_tmpCity,_tmpState,_tmpCountry,_tmpZip,_tmpImageURL);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AddressEntity> getAddress(final String addressId) {
    final String _sql = "SELECT * FROM address_table WHERE id LIKE?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (addressId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, addressId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStreetAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "streetAddress");
      final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
      final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
      final int _cursorIndexOfCountry = CursorUtil.getColumnIndexOrThrow(_cursor, "country");
      final int _cursorIndexOfZip = CursorUtil.getColumnIndexOrThrow(_cursor, "zip");
      final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "imageURL");
      final List<AddressEntity> _result = new ArrayList<AddressEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AddressEntity _item;
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        final String _tmpStreetAddress;
        _tmpStreetAddress = _cursor.getString(_cursorIndexOfStreetAddress);
        final String _tmpCity;
        _tmpCity = _cursor.getString(_cursorIndexOfCity);
        final String _tmpState;
        _tmpState = _cursor.getString(_cursorIndexOfState);
        final String _tmpCountry;
        _tmpCountry = _cursor.getString(_cursorIndexOfCountry);
        final String _tmpZip;
        _tmpZip = _cursor.getString(_cursorIndexOfZip);
        final String _tmpImageURL;
        _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
        _item = new AddressEntity(_tmpId,_tmpStreetAddress,_tmpCity,_tmpState,_tmpCountry,_tmpZip,_tmpImageURL);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
