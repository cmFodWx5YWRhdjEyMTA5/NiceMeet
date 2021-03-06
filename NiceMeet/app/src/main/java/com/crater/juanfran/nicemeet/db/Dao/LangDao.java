package com.crater.juanfran.nicemeet.db.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.crater.juanfran.nicemeet.db.Contract.MyContrats;
import com.crater.juanfran.nicemeet.db.Contract.MyOpenHelper;
import com.crater.juanfran.nicemeet.db.model.Lang;

import java.util.ArrayList;

public class LangDao {
    public ArrayList<Lang> loadAll() {
        final ArrayList<Lang> LangsArrayList = new ArrayList<>();
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(MyContrats.Lang.TABLE_NAME,
                MyContrats.Lang.ALL_COLUMN,
                null,
                null,
                null,
                null,
                MyContrats.Lang.DEFAULT_SORT,
                null);
        if (cursor.moveToFirst()) {
            do {
                Lang Lang = new Lang(cursor.getInt(0), cursor.getString(1));
                LangsArrayList.add(Lang);
            } while (cursor.moveToNext());
        }
        MyOpenHelper.getInstance().closeDateBase();
        return LangsArrayList;
    }
}
