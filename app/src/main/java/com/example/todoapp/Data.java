package com.example.todoapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class Data extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_TASK = "task";
    private static final String DB_NAME = "todo_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "to_do_table";

    public Data(Context context) {
        super(context, TABLE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASK + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TASK, item);

        Log.i("dodawanie", "dodawanie " + item + " do " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getId(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_NAME + " WHERE " + COLUMN_TASK + " = '" + item + "'";
        Cursor data = db.rawQuery(query, null);

        return data;
    }

    public void updateData(String newTask, String taskToEdit, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_TASK +
                " = '" + newTask + "' WHERE " + COLUMN_ID +
                " = '" + id + "' AND " + COLUMN_TASK + " = '" + taskToEdit + "'";
        db.execSQL(query);
    }

}
