package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.ObjectOutputStream;


public class DatabaseHelper extends SQLiteOpenHelper {



    private static final String databasename = "Database";
    private Object nullColumnHack;

    String createTableEns = "CREATE TABLE if not exists \"Ens\" (\n" +
            "\t\"id\"\tINTEGER,\n"+
            "\t\"nom\"\tTEXT,\n" +
            "\t\"prénom\"\tTEXT,\n" +
            "\t\"DateN\"\tINTEGER,\n" +
            "\t\"E-mail\"\tTEXT,\n" +
            "\t\"Addresse\"\tTEXT,\n" +
            "\t\"Password\"\tTEXT,\n"+
            "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
            ")";
    public DatabaseHelper(Context context) {
        super(context, databasename , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Ens(email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists Ens");

    }

    public boolean insert(String email,String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentvalues =new ContentValues();
        ObjectOutputStream.PutField contentValues = null;
        contentValues.put("email",email);
        contentValues.put("password",password);

        String table;
        long ins =  sqLiteDatabase.insert( null, "user", contentvalues );
        if (ins == -1) return false;
        else return true;

    }
    public boolean Checkemail (String email){
        SQLiteDatabase  sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor =  sqLiteDatabase.rawQuery("Select * from user when email =?", new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }
}
