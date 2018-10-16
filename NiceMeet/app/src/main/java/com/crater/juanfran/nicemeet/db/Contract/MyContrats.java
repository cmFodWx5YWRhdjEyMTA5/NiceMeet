package com.crater.juanfran.nicemeet.db.Contract;

import android.provider.BaseColumns;

public class MyContrats{
public static final String DATABASE_NAME="NiceMeet";
public static final int DATABASE_VERSION=1;

    public static class Tags {
        public static final String TABLE_NAME = "tags";
        public static final String COLUMN_NAME = "name";
        public static final String[] ALL_COLUMN = {BaseColumns._ID, COLUMN_NAME};
        public static final String DEFAULT_SORT = BaseColumns._ID;
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME);


        public static final String SQL_INSERT_ENTRIES = String.format("INSERT INTO %s (%s) VALUES ('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s'),('%s')",
                TABLE_NAME,COLUMN_NAME,"Music","Art","Cinematography","Design","Humor","Healt","Politics","Cooking","Reading","Photography","Coding","Travel","Gaming","Tech","Fantasy","Sci-Fi","Illustration","News","Philosophy","Manga/Anime","Writing","Science","Animation","Language","Nature","Vegan","Space","Feminism","Religion","LGBT");

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
    }

    public static class Lang {
        public static final String TABLE_NAME = "Lang";
        public static final String COLUMN_NAME = "name";
        public static final String[] ALL_COLUMN = {BaseColumns._ID, COLUMN_NAME};
        public static final String DEFAULT_SORT = BaseColumns._ID;
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME);

        public static final String SQL_DELETE_ENTRIES = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
    }
}