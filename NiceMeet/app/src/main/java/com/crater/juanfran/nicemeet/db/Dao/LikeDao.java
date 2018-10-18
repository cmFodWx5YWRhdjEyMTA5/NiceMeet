package com.crater.juanfran.nicemeet.db.Dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.crater.juanfran.nicemeet.db.Contract.MyContrats;
import com.crater.juanfran.nicemeet.db.Contract.MyOpenHelper;
import com.crater.juanfran.nicemeet.db.model.Likes;
import com.crater.juanfran.nicemeet.db.model.Tag;

import java.util.ArrayList;

public class LikeDao {
    public ArrayList<Likes> loadAll() {
        final ArrayList<Likes> CountrysArrayList = new ArrayList<>();
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        Cursor cursor = sqLiteDatabase.query(MyContrats.Likes.TABLE_NAME,
                MyContrats.Likes.ALL_COLUMN,
                null,
                null,
                null,
                null,
                MyContrats.Likes.DEFAULT_SORT,
                null);
        if (cursor.moveToFirst()) {
            do {
                Likes likes = new Likes(cursor.getString(0), cursor.getString(1), cursor.getLong(2));
                CountrysArrayList.add(likes);
            } while (cursor.moveToNext());
        }
        MyOpenHelper.getInstance().closeDateBase();
        return CountrysArrayList;
    }

    public void saveLikes(ArrayList<Likes> likes) {
        for (Likes like: likes) {
            add(like);
        }
    }
    public long add(Likes l) {
        final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
        ContentValues contentValues=createContent(l);
        long id= sqLiteDatabase.insert(MyContrats.Tags.TABLE_NAME,null,contentValues);
        MyOpenHelper.getInstance().closeDateBase();
        return id;
    }
    private ContentValues createContent(Likes t) {
        ContentValues contentValues=new ContentValues();
        contentValues.put(MyContrats.Likes.COLUMN_LIKER,t.getUidLiker());
        contentValues.put(MyContrats.Likes.COLUMN_LIKED,t.getUidLiked());
        contentValues.put(MyContrats.Likes.COLUMN_DATE,t.getDate());
        return contentValues;
    }
    public void deleteLikes(ArrayList<Likes> likes) {
        for (Likes like: likes) {
            delete(like.getUidLiked());
        }
    }
    public void delete(String uid) {
        try{
            final SQLiteDatabase sqLiteDatabase = MyOpenHelper.getInstance().openDateBase();
            sqLiteDatabase.delete(MyContrats.Tags.TABLE_NAME, MyContrats.Likes.COLUMN_LIKED+"=?",new String[]{(String.valueOf( uid))} );
            MyOpenHelper.getInstance().closeDateBase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
