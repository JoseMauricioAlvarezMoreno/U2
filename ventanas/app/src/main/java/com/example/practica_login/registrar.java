package com.example.practica_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registrar extends AppCompatActivity {

    private Button bsr;
    private Button bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        bsr=findViewById(R.id.bsr);
        bmp=findViewById(R.id.bmp);
    }

    public void salir (View view)

    {

        Intent salida = new Intent(registrar.this,Salida.class);
        startActivity(salida);


    }
    public void regresarmp (View view)

    {

        Intent regmp = new Intent(registrar.this,MainActivity.class);
        startActivity(regmp);


    }
}