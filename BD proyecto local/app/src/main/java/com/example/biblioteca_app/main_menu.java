package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void QR (View view){
        Intent QRW = new Intent(main_menu.this,CodigoQR.class);
        startActivity(QRW);
    }

    public void CB (View view){
        Intent CB = new Intent(main_menu.this,Codigo_barras.class);
        startActivity(CB);
    }

    public void libros (View view){
        Intent lib = new Intent(main_menu.this,Menu.class);
        startActivity(lib);
    }

    public void camara (View view){
        Intent cam = new Intent(main_menu.this,fotografia.class);
        startActivity(cam);
    }

    public void ubicacion (View view){
        Intent u = new Intent(main_menu.this,Maps.class);
        startActivity(u);
    }

    public void close_sesion (View view){
        Intent cs = new Intent(main_menu.this,login.class);
        startActivity(cs);
    }



}