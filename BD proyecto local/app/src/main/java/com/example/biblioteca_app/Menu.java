package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }



    public void QR (View view){
        Intent QRW = new Intent(Menu.this,CodigoQR.class);
        startActivity(QRW);
    }

    public void CB (View view){
        Intent CB = new Intent(Menu.this,Codigo_barras.class);
        startActivity(CB);
    }

    public void bio (View view){
        Intent bio = new Intent(Menu.this,biografias.class);
        startActivity(bio);
    }
    public void cien (View view){
        Intent cien = new Intent(Menu.this,ciencias.class);
        startActivity(cien);
    }
    public void enci (View view){
        Intent enc = new Intent(Menu.this,enciclopedias.class);
        startActivity(enc);
    }
    public void len (View view){
        Intent len = new Intent(Menu.this,lenguas.class);
        startActivity(len);
    }
    public void mat (View view){
        Intent mat = new Intent(Menu.this,matematicas.class);
        startActivity(mat);
    }

    public void nov (View view){
        Intent nov = new Intent(Menu.this,novelas.class);
        startActivity(nov);
    }
    public void poe (View view){
        Intent poe = new Intent(Menu.this,poemas.class);
        startActivity(poe);
    }
    public void tec (View view){
        Intent tec = new Intent(Menu.this,tecnologia.class);
        startActivity(tec);
    }
    public void ter (View view){
        Intent ter = new Intent(Menu.this,terror.class);
        startActivity(ter);
    }


}