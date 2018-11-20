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

            //Create table Category if its not exists
            String category_creation_sql = "CREATE TABLE IF NOT EXISTS `category_expenditure` (\n" +
                    "\t`id`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t`title`\tTEXT NOT NULL UNIQUE,\n" +
                    "\t`group_id`\tINTEGER NOT NULL,\n" +
                    "\tFOREIGN KEY(`group_id`) REFERENCES `group_expenditure`(`id`)\n" +
                    ");";
            QueryData(category_creation_sql);

            // Create table Category successfully

            //Create table Expenditure if its not exists
            String expenditure_creation_sql = " CREATE TABLE `expenditure` (\n" +
                    "\t`id`\tINTEGER NOT NULL,\n" +
                    "\t`title`\tTEXT,\n" +
                    "\t`time`\tTEXT NOT NULL,\n" +
                    "\t`money`\tINTEGER NOT NULL,\n" +
                    "\t`type`\tINTEGER NOT NULL,\n" +
                    "\t`category_id`\tINTEGER NOT NULL,\n" +
                    "                    FOREIGN KEY(`category_id`) REFERENCES `category_expenditure`(`id`)\n" +
                    ");";
            QueryData(expenditure_creation_sql);

            // Create table Expenditure successfully

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

    // Update the group of expenditure
    public boolean UpdateGroup(String group_title, String new_title_group){
        try {
            String update_group_sql = "UPDATE group_expenditure SET title = '"+ new_title_group +"' WHERE title = '" + group_title + "'";
            QueryData(update_group_sql);
            // Update group of expenditure successfully
            return true;
        }catch (Exception e){
            // Update new group of expenditure failed
            return false;
        }

    }

    // Create category for expenditure
    public boolean addNewCategory(String category_title, int group_id){
        try {
            String add_new_category_sql = "INSERT INTO category_expenditure VALUES(null, '" + category_title + "', " + group_id + ")";
            QueryData(add_new_category_sql);
            // Create new category of expenditure successfully
            return true;
        }catch (Exception e){
            // Create new category of expenditure failed
            return false;
        }

    }

    // Delete the category of expenditure
    public boolean DeleteCategory(String category_title){
        try {
            String add_new_group_sql = "DELETE FROM `category_expenditure` WHERE `title` = '" + category_title + "';";
            QueryData(add_new_group_sql);
            // Delete category of expenditure successfully
            return true;
        }catch (Exception e){
            // Delete category of expenditure failed
            return false;
        }

    }

}
