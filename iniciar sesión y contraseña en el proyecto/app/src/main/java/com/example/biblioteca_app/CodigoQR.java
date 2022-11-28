package com.example.biblioteca_app;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class CodigoQR extends AppCompatActivity {

    ImageView ivCodigoQR;
    EditText etDatos;
    Button btnGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_qr);

        ivCodigoQR = findViewById(R.id.ivCodigob);
        etDatos = findViewById(R.id.etDatos);
        btnGenerar = findViewById(R.id.btnGenerar);

    }




    public void generar (View view) {

                try {

                    /* DATOS PARA MANEJAR
                     *  TELEFONO ES: tel:
                     *  SMS ES: numero:mensaje
                     *  MAIL: mailto
                     * Jose Mauricio Alvarez Moreno
                     * */


                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap("mail:"+etDatos.getText().toString(), BarcodeFormat.QR_CODE, 750, 750);

                    ivCodigoQR.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



}