package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class terror extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terror);
    }


    public void libro1 (View view){
        Intent QRW = new Intent(terror.this,libro6.class);
        startActivity(QRW);
    }
}