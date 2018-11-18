package com.roynguyen147.expenditurecontrol;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {

    MainActivity context;

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Impact database function
    public void QueryData(String sql) {
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

    // Create table group_expenditure for the first time application run
    public boolean createDBForTheFirstTime(){
        try {
            // Create table Group if its not exists
            String group_creation_sql = "CREATE TABLE IF NOT EXISTS `group_expenditure` (\n" +
                    "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t`title`\tTEXT NOT NULL UNIQUE\n" +
                    ");";

            QueryData(group_creation_sql);
            // Create table group_expenditure successfully
            return true;
        }catch (Exception e){
            // Create table group_expenditure failed
            return false;
        }

    }

    // Add new group of expenditure - unique value
    public boolean addNewGroup(String new_group_title){
        try {
            String add_new_group_sql = "INSERT INTO group_expenditure VALUES(null, '" + new_group_title + "')";
            QueryData(add_new_group_sql);
            // Create new group of expenditure successfully
            return true;
        }catch (Exception e){
            // Create new group of expenditure failed
            return false;
        }

    }

    // Delete the group of expenditure
    public boolean DeleteGroup(String group_title){
        try {
            String add_new_group_sql = "DELETE FROM `group_expenditure` WHERE `title` = '" + group_title + "';";
            QueryData(add_new_group_sql);
            // Delete group of expenditure successfully
            return true;
        }catch (Exception e){
            // Delete new group of expenditure failed
            return false;
        }

    }
}
