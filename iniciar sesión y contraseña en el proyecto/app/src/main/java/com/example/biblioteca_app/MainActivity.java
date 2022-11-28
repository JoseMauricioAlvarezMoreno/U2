package com.example.biblioteca_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText login;
    EditText name;
    EditText email;
    EditText tel;
    EditText pass;
    EditText conpass;
    private Button regis;
    private Button canc;
    private Button limpiar;

    AdminSQLiteOpenHelper biblioteca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        tel = findViewById(R.id.tel);
        pass = findViewById(R.id.pass);
        conpass = findViewById(R.id.conpass);




        biblioteca = new AdminSQLiteOpenHelper( this, "bibliotecas", null, 1);


    }



    public  void altas (View view)
    {

        biblioteca = new AdminSQLiteOpenHelper(this,"bibliotecas",null,1);
        String log = login.getText().toString();
        String nom = name.getText().toString();
        String telef = tel.getText().toString();
        String email2 = email.getText().toString();
        String pas = pass.getText().toString();
        String confi = conpass.getText().toString();


        if(log.equals("")||pas.equals("")||confi.equals(""))
        {
            Toast.makeText(this, " LOS CAMPOS NO DEBEN ESTAR VACIOS ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(pas.equals(confi))
            {
                Boolean usercheck = biblioteca.comuser( log );

                if(usercheck == false)
                {

                    Boolean regisResult = biblioteca.registrardatos( log, nom, email2, telef, pas);

                    if(regisResult == true )
                    {
                        Toast.makeText(this, " USUARIO REGISTRADO CON EXITO ",Toast.LENGTH_SHORT).show();
                        limpia();
                        Intent inicio = new Intent(MainActivity.this,login.class);
                        startActivity(inicio);

                    }
                    else
                    {
                        Toast.makeText(this, " NO SE HA REGISTRADO EL USUARIO ",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(this, " ESTE USUARIO YA EXISTE ",Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, " LAS CONTRASEÑAS NO COINCIDEN ",Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void salir (View view)

    {

        Intent salida = new Intent(MainActivity.this,login.class);
        startActivity(salida);


    }

    public void limpia()
    {

        login.setText("");
        name.setText("");
        email.setText("");
        tel.setText("");
        pass.setText("");
        conpass.setText("");
    }

    public void limpiar(View view)
    {
        limpia();
    }



    public void cerrarapp(View view)
    {
        finish();
    }

}