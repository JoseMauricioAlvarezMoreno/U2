package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class cambios extends AppCompatActivity {

    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambios);

        edt1 = findViewById(R.id.edt1b);
        edt2 = findViewById(R.id.edt2b);
        edt3 = findViewById(R.id.edt3b);
        edt4 = findViewById(R.id.edt4b);


    }


    public void cambios (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, " administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nocontrol = edt1.getText().toString();
        String nombre = edt2.getText().toString();
        String semestre = edt3.getText().toString();
        String carrera = edt4.getText().toString();

        ContentValues registroup = new ContentValues();

        registroup.put(" nombre ", nombre );
        registroup.put(" semestre " , semestre );
        registroup.put(" carrera ", carrera );




        int cant = bd.update(" alumno ", registroup ," nocontrol=" + nocontrol ,null);


        bd.close();

        if(cant == 1)
            Toast.makeText(this,"DATOS MODIFICADOS CON EXITO",Toast.LENGTH_SHORT).show();


        else
            Toast.makeText(this,"NO EXISTE USUARIO",Toast.LENGTH_SHORT).show();





    }
}