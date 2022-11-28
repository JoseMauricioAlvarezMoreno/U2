package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class biografias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biografias);
    }



    public void libro1 (View view){
        Intent QRW = new Intent(biografias.this,libro1.class);
        startActivity(QRW);
    }

    public void CARGAR (View view){
        Intent QRW = new Intent(biografias.this,nuevoslibros.class);
        startActivity(QRW);
    }


}