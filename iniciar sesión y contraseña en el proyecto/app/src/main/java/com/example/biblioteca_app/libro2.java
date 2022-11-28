package com.example.biblioteca_app;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pdfview.PDFView;

public class libro2 extends AppCompatActivity {
    PDFView vistapdf;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro2);

        vistapdf = findViewById(R.id.vistapdf);
        vistapdf.fromAsset(" Ciencias Sociales.pdf");
        vistapdf.isZoomEnabled();

        vistapdf.show();
    }
}