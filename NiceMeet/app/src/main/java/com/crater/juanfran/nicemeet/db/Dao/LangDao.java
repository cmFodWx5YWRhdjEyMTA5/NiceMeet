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

    public void delete(int id) {
        try{
            final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
            sqLiteDatabase.delete(MyContrats.Lang.TABLE_NAME, BaseColumns._ID+"=?",new String[]{(String.valueOf( id))} );
            MyOpenHelper.getInstance().closeDateBase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void set(int id, Lang t) {
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        ContentValues contentValues=createContent(t);
        sqLiteDatabase.update(MyContrats.Lang.TABLE_NAME,contentValues,BaseColumns._ID+"=?",new String[]{ String.valueOf(id)});
        MyOpenHelper.getInstance().closeDateBase();
    }

    private ContentValues createContent(Lang t) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyContrats.Lang.COLUMN_NAME,t.get_name());
        return contentValues;
    }

    public long add(Lang t) {
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        ContentValues contentValuesP=createContent(t);
        long id= sqLiteDatabase.insert(MyContrats.Lang.TABLE_NAME,null,contentValuesP);
        MyOpenHelper.getInstance().closeDateBase();
        return id;
    }
}
