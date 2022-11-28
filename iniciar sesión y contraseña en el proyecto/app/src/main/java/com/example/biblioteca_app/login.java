package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText login1;
    EditText password;

    AdminSQLiteOpenHelper biblioteca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login1 = findViewById(R.id.login1);
        password = findViewById(R.id.password);

        biblioteca = new AdminSQLiteOpenHelper(this,"bibliotecas",null,1);


    }

    public void login (View view )
    {
        biblioteca = new AdminSQLiteOpenHelper(this,"bibliotecas",null,1);
        String login = login1.getText().toString();
        String pass = password.getText().toString();

        if(login.equals("")||pass.equals(""))
        {
            Toast.makeText(this, " LOS CAMPOS NO DEBEN ESTAR VACIOS ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Boolean result = biblioteca.compuandp ( login , pass );

            if( result == true )
            {

                Toast.makeText(this, " INICIO DE SESION EXITOSO ",Toast.LENGTH_SHORT).show();
                Intent inicio = new Intent(login.this,main_menu.class);
                startActivity(inicio);

            }
            else
            {
                Toast.makeText(this, " DATOS INCORRECTOS ",Toast.LENGTH_SHORT).show();
                Intent inicio = new Intent(login.this,Menu.class);
                //startActivity(inicio);
            }
        }

    }

    public void nuevouser (View view)
    {
        Intent registrar = new Intent(login.this,MainActivity.class);
        startActivity(registrar);

    }

    public void cerrarapp(View view)
    {
        finish();
    }
}