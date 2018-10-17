package com.crater.juanfran.nicemeet.db.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crater.juanfran.nicemeet.db.Contract.MyContrats;
import com.crater.juanfran.nicemeet.db.Contract.MyOpenHelper;
import com.crater.juanfran.nicemeet.db.model.Country;

import java.util.ArrayList;

public class CountryDao {
    public ArrayList<Country> loadAll() {
        final ArrayList<Country> CountrysArrayList = new ArrayList<>();
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(MyContrats.Country.TABLE_NAME,
                MyContrats.Country.ALL_COLUMN,
                null,
                null,
                null,
                null,
                MyContrats.Country.DEFAULT_SORT,
                null);
        if (cursor.moveToFirst()) {
            do {
                Country Country = new Country(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                CountrysArrayList.add(Country);
            } while (cursor.moveToNext());
        }
        MyOpenHelper.getInstance().closeDateBase();
        return CountrysArrayList;
    }
}
