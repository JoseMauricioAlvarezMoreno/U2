package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class consultas extends AppCompatActivity {


    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        edt1 = findViewById(R.id.edt1b);
        edt2 = findViewById(R.id.edt2b);
        edt3 = findViewById(R.id.edt3b);
        edt4 = findViewById(R.id.edt4b);
    }


    public void consultas(View view)

    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper (this," administracion ", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nocotrol = edt1.getText().toString();



        Cursor fila = bd.rawQuery (" select nombre , semestre ,carrera from alumno where nocontrol = " + nocotrol  ,null);
        //Cursor fila = bd.rawQuery ("select nombre, semestre, carrera from alumno",null);



        if (fila.moveToFirst())
        {

            edt2.setText(fila.getString(0));
            edt3.setText(fila.getString(1));
            edt4.setText(fila.getString(2));

        }

        else
        {

            Toast.makeText(this, "NO EXISTE NINGUN USUARIO CON ESTE NÚMERO DE CONTROL", Toast.LENGTH_SHORT).show();
        }


        bd.close();

    }
}