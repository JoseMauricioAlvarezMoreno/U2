package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MENU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void cambios (View view){
        Intent QRW = new Intent(MENU.this,cambios.class);
        startActivity(QRW);
    }

    public void bajas (View view){
        Intent QRW = new Intent(MENU.this,bajas.class);
        startActivity(QRW);
    }
    public void altas (View view){
        Intent QRW = new Intent(MENU.this,altas.class);
        startActivity(QRW);
    }

    public void consultas (View view){
        Intent QRW = new Intent(MENU.this,consultas.class);
        startActivity(QRW);
    }
}