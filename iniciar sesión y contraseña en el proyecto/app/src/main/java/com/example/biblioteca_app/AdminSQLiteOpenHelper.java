package com.example.biblioteca_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase biblioteca)
    {
        biblioteca.execSQL(" create Table usuarios ( login Text primary key, nombre Text, email Text, telefono Text, contraseña Text ) " );
    }

    @Override
    public void onUpgrade(SQLiteDatabase biblioteca, int i, int i1)
    {

        biblioteca.execSQL("drop table if exists usuarios");
        biblioteca.execSQL(" create Table usuarios ( login Text primary key, nombre Text, email Text, telefono Text, contraseña Text ) " );

    }

    public Boolean registrardatos ( String login, String nombre, String email,String telefono, String contraseña )
    {
        SQLiteDatabase biblioteca = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(" login ", login );
        contentValues.put(" nombre ", nombre );
        contentValues.put(" email ", email );
        contentValues.put(" telefono ", telefono );
        contentValues.put(" contraseña ", contraseña );
        long result = biblioteca.insert(" usuarios ", null, contentValues);


        if(result == -1)
        {

            return false;
        }
        else
        {
            return true;
        }




    }

    public Boolean comuser (String login)
    {
        SQLiteDatabase biblioteca = this.getWritableDatabase();
        Cursor cursor = biblioteca.rawQuery(" select * from usuarios where login = ? " , new  String [] {login}   );

        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean compuandp (String login, String contraseña){
        SQLiteDatabase biblioteca = this.getWritableDatabase();
        Cursor cursor = biblioteca.rawQuery(" select * from usuarios where login = ? and contraseña = ? " , new  String [] {login,contraseña});

        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }







}
