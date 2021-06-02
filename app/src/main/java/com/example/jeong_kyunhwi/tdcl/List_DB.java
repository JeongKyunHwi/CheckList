package com.example.jeong_kyunhwi.tdcl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class List_DB {
    private List_DB(){}

    public static class CharacterEntry implements BaseColumns {
        public static final String TABLE_NAME = "Character_DB";
        public static final String COLUMN_NAME_TITLE = "Nickname";
        public static final String COLUMN_NAME_FIRST_SUBTITLE = "Class";
        public static final String COLUMN_NAME_SECOND_SUBTITLE = "Itemlevel";
    }

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + CharacterEntry.TABLE_NAME + " ("
            + CharacterEntry.COLUMN_NAME_TITLE + " TEXT, "
            + CharacterEntry.COLUMN_NAME_FIRST_SUBTITLE + " TEXT, "
            + CharacterEntry.COLUMN_NAME_SECOND_SUBTITLE + " TEXT)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + CharacterEntry.TABLE_NAME;

    public static class CharacterDbHelper extends SQLiteOpenHelper{
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "CharacterCheckList.db";

        public  CharacterDbHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }
}
