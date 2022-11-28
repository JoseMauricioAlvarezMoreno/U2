package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ciencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciencias);
    }


    public void libro1 (View view){
        Intent QRW = new Intent(ciencias.this,libro2.class);
        startActivity(QRW);
    }

    public void libro2 (View view){
        Intent QRW = new Intent(ciencias.this,libro3.class);
        startActivity(QRW);
    }
}