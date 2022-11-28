package com.example.practica_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bienvenida extends AppCompatActivity {

    private Button bs;
    private Button clean;
    private TextView saludo;
    Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        bs=findViewById(R.id.bs);
        clean = findViewById(R.id.limp);
        saludo = findViewById(R.id.biennom);
        datos = getIntent().getExtras();
        saludo.setText("Hola "+ datos.getString("nombre"));

    }


    public void salir (View view)

    {

        Intent salida = new Intent(bienvenida.this,Salida.class);
        startActivity(salida);


    }
    public void limpiar (View view)
    {

    }
}






