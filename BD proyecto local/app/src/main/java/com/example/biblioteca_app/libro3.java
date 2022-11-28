package com.example.biblioteca_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.pdfview.PDFView;

import java.io.File;

public class libro3 extends AppCompatActivity {

    PDFView vistapdf;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libro3);

        vistapdf = findViewById(R.id.vistapdf);

        File file = new File(Environment.getExternalStorageDirectory(),"archivo.pdf");
        vistapdf.fromAsset("John Gribbin.pdf");
        vistapdf.isZoomEnabled();

        vistapdf.show();
    }
}