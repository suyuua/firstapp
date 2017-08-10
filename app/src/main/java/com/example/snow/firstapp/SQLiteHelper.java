package com.example.snow.firstapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{



private static final int DATABASE_VERSION = 1;
public static final String DATABASE_NAME = "SQLiteDatabase.db";

public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    public static final String TABLE_NAME = "HISTORY";
    public static final String COLUMN_QUESTIONS = "QUESTION";
    public static final String COLUMN_OPTIONS = "OPTIONS";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COLUMN_QUESTIONS + " TEXT,"
                + COLUMN_OPTIONS + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }




}