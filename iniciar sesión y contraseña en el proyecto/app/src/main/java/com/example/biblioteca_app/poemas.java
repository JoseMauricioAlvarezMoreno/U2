package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class poemas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poemas);
    }


    public void libro1 (View view){
        Intent QRW = new Intent(poemas.this,libro4.class);
        startActivity(QRW);
    }
}