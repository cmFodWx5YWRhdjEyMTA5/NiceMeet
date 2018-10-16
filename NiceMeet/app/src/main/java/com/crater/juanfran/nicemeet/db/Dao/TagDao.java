package com.crater.juanfran.nicemeet.db.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.crater.juanfran.nicemeet.db.Contract.MyContrats;
import com.crater.juanfran.nicemeet.db.Contract.MyOpenHelper;
import com.crater.juanfran.nicemeet.db.model.Tag;

import java.util.ArrayList;

public class TagDao {
    
    public ArrayList<Tag> loadAll() {
        final ArrayList<Tag> TagsArrayList = new ArrayList<>();
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(MyContrats.Tags.TABLE_NAME,
                MyContrats.Tags.ALL_COLUMN,
                null,
                null,
                null,
                null,
                MyContrats.Tags.DEFAULT_SORT,
                null);
        if (cursor.moveToFirst()) {
            do {
                Tag Tag = new Tag(cursor.getInt(0), cursor.getString(1));
                TagsArrayList.add(Tag);
            } while (cursor.moveToNext());
        }
        MyOpenHelper.getInstance().closeDateBase();
        return TagsArrayList;
    }

    public void delete(int id) {
        try{
            final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
            sqLiteDatabase.delete(MyContrats.Tags.TABLE_NAME, BaseColumns._ID+"=?",new String[]{(String.valueOf( id))} );
            MyOpenHelper.getInstance().closeDateBase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void set(int id, Tag t) {
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        ContentValues contentValues=createContent(t);
        sqLiteDatabase.update(MyContrats.Tags.TABLE_NAME,contentValues,BaseColumns._ID+"=?",new String[]{ String.valueOf(id)});
        MyOpenHelper.getInstance().closeDateBase();
    }

    private ContentValues createContent(Tag t) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyContrats.Tags.COLUMN_NAME,t.get_name());
        return contentValues;
    }

    public long add(Tag t) {
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        ContentValues contentValuesP=createContent(t);
        long id= sqLiteDatabase.insert(MyContrats.Tags.TABLE_NAME,null,contentValuesP);
        MyOpenHelper.getInstance().closeDateBase();
        return id;
    }
}
