package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class bajas extends AppCompatActivity {

    private EditText edt1b;
    private EditText edt2b;
    private EditText edt3b;
    private EditText edt4b;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        edt1b = findViewById(R.id.edt1b);
        edt2b = findViewById(R.id.edt2b);
        edt3b = findViewById(R.id.edt3b);
        edt4b = findViewById(R.id.edt4b);
    }


    public void bajas (View view)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this," administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nocontrol = edt1b.getText().toString();

        int cant = bd.delete(" alumno "," nocontrol = " + nocontrol,null);

        bd.close();
        edt1b.setText("");
        edt2b.setText("");
        edt3b.setText("");
        edt4b.setText("");

        if ( cant == 1)

            Toast.makeText(this, "USUARIO ELIMINADO", Toast.LENGTH_SHORT).show();

        else

            Toast.makeText(this, "NO EXISTE ESTE USUARIO", Toast.LENGTH_SHORT).show();



    }
}