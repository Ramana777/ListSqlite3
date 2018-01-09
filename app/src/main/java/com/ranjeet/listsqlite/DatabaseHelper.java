package com.ranjeet.listsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by admin on 1/3/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public  void  queryData(String sql){
        SQLiteDatabase  database=getWritableDatabase();
        database.execSQL(sql);
    }
    public  void insert(String name,String dept,String mobileno,byte[] image){
        SQLiteDatabase database=getWritableDatabase();
        String sql= "INSERT INTO DEPARTMENT VALUES(NULL,?,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,dept);
        statement.bindString(3,mobileno);
        statement.bindBlob(4,image);
        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
