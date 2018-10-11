package com.example.aceahmer.taskfive;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, context.getString(R.string.database_name), null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Employees" + "(Id INTEGER PRIMARY KEY AUTOINCREMENT ,firstName TEXT,lastName TEXT,Occupation TEXT,Age INTEGER,AboutMe TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Employees");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String firstname, String lastname, String occupation,int age,String aboutme) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("firstName", firstname);
        c.put("lastName", lastname);
        c.put("Occupation", occupation);
        c.put("Age",age);
        c.put("AboutMe",aboutme);
        if (db.insert("Employees", null, c) != -1)
            return true;
        else
            return false;

    }

    public boolean deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db.delete("Employees", "Id=?", new String[]{id}) > 0)
            return true;
        else
            return false;

    }

    public boolean updateData(int id, String firstname, String lastname, String occupation,int age,String aboutme) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("Id", id);
        c.put("firstName", firstname);
        c.put("lastName", lastname);
        c.put("Occupation", occupation);
        c.put("Age",age);
        c.put("AboutMe",aboutme);
        if (db.update("Employees", c, "Id=?", new String[]{String.valueOf(id)}) > 0)
            return true;
        else return false;

    }
    public Cursor dataRetreive(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor data=db.rawQuery("select * from Employees",null);
        return data;
    }

}
