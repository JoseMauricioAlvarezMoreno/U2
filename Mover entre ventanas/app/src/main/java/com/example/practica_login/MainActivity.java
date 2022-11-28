package com.example.practica_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button breg;
    String  nombre = "Juan Perez";
    String login = "Juan";
    String pass = "123";
    private EditText user;
    private EditText passw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //b1=findViewById(R.id.b1);
        //breg=findViewById(R.id.breg);

        user = findViewById(R.id.user);
        passw = findViewById(R.id.password);

    }

    public void validar (View view)

    {

        Intent saludo = new Intent(MainActivity.this,bienvenida.class);
        Intent error = new Intent (MainActivity.this,registrar.class);


        String l = user.getText().toString();
        String p = passw.getText().toString();

        if((l.equals(login)) && (p.equals(pass)))
        {
            saludo.putExtra("nombre",nombre);
            startActivity(saludo);
        }
        else
        {
            startActivity(error);
        }



    }

    public void salir (View view)

    {

        Intent salida = new Intent(MainActivity.this,Salida.class);
        startActivity(salida);


    }


    public void regis (View view)

    {

        Intent registra = new Intent(MainActivity.this,registrar.class);
        startActivity(registra);


    }

    public void registro (View view)

    {

        Intent registra = new Intent(MainActivity.this,registro.class);
        startActivity(registra);


    }


    public void limpiar (View view)
    {

    }
}
