package com.example.practica_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private EditText userr;
    private EditText passwordr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        userr = findViewById(R.id.userr);
        passwordr = findViewById(R.id.passwordr);
    }


    public void altas (View view)
    {



        String user = userr.getText().toString();
        String pass = passwordr.getText().toString();



        // Toast.makeText(this,"Aqui voy  altas " + "nocontrol" + nocontrol + "nombre"+ nombre+ "semestre" + semestre + " carrera "+ carrera ,Toast.LENGTH_SHORT).show();


        ContentValues registro = new ContentValues();
        registro.put(" userr ", user );
        registro.put(" passwordr ", pass );


        this.limpia();
        Toast.makeText(this, " DATOS DEL USUARIO REGISTRADOS CORRECTAMENTE ",Toast.LENGTH_SHORT).show();

    }

    public void limpia()
    {

        userr.setText("");
        passwordr.setText("");

    }

    public void limpiar(View view)

    {
        this.limpia();

    }


}