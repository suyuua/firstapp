package com.example.snow.firstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{



private static final int DATABASE_VERSION = 1;
public static final String DATABASE_NAME = "SQLiteDatabase.db";

public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    public static final String TABLE_NAME = "HISTORY";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_QUESTIONS = "QUESTION";
    public static final String COLUMN_OPTIONS = "OPTIONS";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_QUESTIONS + " TEXT,"
                + COLUMN_OPTIONS + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertQuestion(String question, String options) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_QUESTIONS , question);
        contentValues.put(COLUMN_OPTIONS, options);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }


    public boolean updateQuestion(Integer id, String question, String options) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_QUESTIONS , question);
        contentValues.put(COLUMN_OPTIONS, options);
        db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Cursor getQuestion(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_ID + "=?", new String[] { Integer.toString(id) } );
        return res;
    }
    public Cursor getallQuestions() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + TABLE_NAME, null );
        return res;
    }
    public Integer deleteQuestion(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,
                COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public boolean deleteFirst() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            String rowId = cursor.getString(cursor.getColumnIndex(COLUMN_ID));

            db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{rowId});
        }
        return true;
    }
    public void deleteDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }

}