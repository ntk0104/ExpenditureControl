package com.roynguyen147.expenditurecontrol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Impact database function
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    // Get-data only function (Non-impact database function)
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDBForTheFirstTime(){
        // Create table Group if its not exists
        String group_creation_sql = "CREATE TABLE IF NOT EXISTS group_expenditure(id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(200) NOT NULL)";
        QueryData(group_creation_sql);
    }

    public void addNewGroup(String new_group_title){
        String add_new_group_sql = "INSERT INTO group_expenditure VALUES(null, '" + new_group_title + "')";
        QueryData(add_new_group_sql);
    }
}
