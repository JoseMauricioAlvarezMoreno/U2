package com.example.biblioteca_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;

public class fotografia extends AppCompatActivity {


    ImageButton btnCamara;
    ImageView imgView;
    String rutaImagen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia);

       // btnCamara = findViewById(R.id.btn_Camara);
        btnCamara = findViewById(R.id.btn_Camara);
        imgView = findViewById(R.id.imageView);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){

            File fotoarchivo = null;
            try{
                fotoarchivo = foto();

            }
            catch(IOException ex){
                Log.e("Error",ex.toString());

            }

            if(fotoarchivo != null){
                Uri fotouri = FileProvider.getUriForFile(this,"com.example.biblioteca_app.fileprovider", fotoarchivo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fotouri);
                startActivityForResult(intent, 1);


            }

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            //Bundle extras = data.getExtras();
            //Bitmap imgBitmap = (Bitmap) extras.get("data");
            Bitmap imgBitmap = BitmapFactory.decodeFile(rutaImagen);
            imgView.setImageBitmap(imgBitmap);
        }
    }

    private File foto() throws IOException{
        String nombreImagen = "Foto";
        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen = File.createTempFile(nombreImagen,".jpg",directorio);

        rutaImagen = imagen.getAbsolutePath();
        return imagen;

    }

}