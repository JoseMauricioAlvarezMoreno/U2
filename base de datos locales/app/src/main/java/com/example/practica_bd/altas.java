package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class altas extends AppCompatActivity {

    private EditText edt1a;
    private EditText edt2a;
    private EditText edt3a;
    private EditText edt4a;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);


        edt1a = findViewById(R.id.edt1b);
        edt2a = findViewById(R.id.edt2b);
        edt3a = findViewById(R.id.edt3b);
        edt4a = findViewById(R.id.edt4a);

    }



    public void altas (View view)
    {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper (this," administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nocontrol = edt1a.getText().toString();
        String nombre = edt2a.getText().toString();
        String semestre = edt3a.getText().toString();
        String carrera = edt4a.getText().toString();


        // Toast.makeText(this,"Aqui voy  altas " + "nocontrol" + nocontrol + "nombre"+ nombre+ "semestre" + semestre + " carrera "+ carrera ,Toast.LENGTH_SHORT).show();


        ContentValues registro = new ContentValues();
        registro.put(" nocontrol ", nocontrol );
        registro.put(" nombre ", nombre );
        registro.put(" semestre " , semestre );
        registro.put(" carrera ", carrera );

        bd.insert(" alumno " ,null, registro );
        bd.close();
        this.limpia();
        Toast.makeText(this, " DATOS DEL USUARIO REGISTRADOS CORRECTAMENTE ",Toast.LENGTH_SHORT).show();

    }

    public void limpia()
    {

        edt1a.setText("");
        edt2a.setText("");
        edt3a.setText("");
        edt4a.setText("");
    }

    public void limpiar(View view)

    {
        this.limpia();

    }
}