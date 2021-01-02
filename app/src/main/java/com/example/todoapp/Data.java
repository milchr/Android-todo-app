package com.example.todoapp;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Data extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "ID";
    public static final String TABLE_ROW_TASK = "task";
    private static final String DB_NAME = "todo_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "to_do_table";

    public Data(Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + TABLE_ROW_TASK + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
