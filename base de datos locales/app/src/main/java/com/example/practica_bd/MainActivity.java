package com.example.practica_bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1b);
        edt2 = findViewById(R.id.edt2b);
        edt3 = findViewById(R.id.edt3b);
        edt4 = findViewById(R.id.edt4b);




    }

    public void altas (View view)
    {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper (this," administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nocontrol = edt1.getText().toString();
        String nombre = edt2.getText().toString();
        String semestre = edt3.getText().toString();
        String carrera = edt4.getText().toString();


        // Toast.makeText(this,"Aqui voy  altas " + "nocontrol" + nocontrol + "nombre"+ nombre+ "semestre" + semestre + " carrera "+ carrera ,Toast.LENGTH_SHORT).show();


        ContentValues registro = new ContentValues();
        registro.put(" nocontrol ", nocontrol );
        registro.put(" nombre ", nombre );
        registro.put(" semestre " , semestre );
        registro.put(" carrera ", carrera );

        bd.insert(" alumno " ,null, registro );
        bd.close();
        this.limpia();
        Toast.makeText(this, " DATOS DEL USUARIO REGISTRADOS CORRECTAMENTE ",Toast.LENGTH_SHORT).show();

    }

    public void limpia()
    {

        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
    }

    public void limpiar(View view)

    {
        this.limpia();

    }

    public void consultas(View view)

    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper (this," administracion ", null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nocotrol = edt1.getText().toString();



        Cursor fila = bd.rawQuery (" select nombre , semestre ,carrera from alumno where nocontrol = " + nocotrol  ,null);
        //Cursor fila = bd.rawQuery ("select nombre, semestre, carrera from alumno",null);



        if (fila.moveToFirst())
        {

            edt2.setText(fila.getString(0));
            edt3.setText(fila.getString(1));
            edt4.setText(fila.getString(2));

        }

        else
        {

            Toast.makeText(this, "NO EXISTE NINGUN USUARIO CON ESTE NÚMERO DE CONTROL", Toast.LENGTH_SHORT).show();
        }


        bd.close();

    }


    public void bajas (View view)
    {
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this," administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nocontrol = edt1.getText().toString();

        int cant = bd.delete(" alumno "," nocontrol = " + nocontrol,null);

        bd.close();
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");

        if ( cant == 1)

            Toast.makeText(this, "USUARIO ELIMINADO", Toast.LENGTH_SHORT).show();

        else

            Toast.makeText(this, "NO EXISTE ESTE USUARIO", Toast.LENGTH_SHORT).show();



    }

    public void cambios (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, " administracion ",null,1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nocontrol = edt1.getText().toString();
        String nombre = edt2.getText().toString();
        String semestre = edt3.getText().toString();
        String carrera = edt4.getText().toString();

        ContentValues registroup = new ContentValues();

        registroup.put(" nombre ", nombre );
        registroup.put(" semestre " , semestre );
        registroup.put(" carrera ", carrera );




        int cant = bd.update(" alumno ", registroup ," nocontrol=" + nocontrol ,null);


        bd.close();

        if(cant == 1)
            Toast.makeText(this,"DATOS MODIFICADOS CON EXITO",Toast.LENGTH_SHORT).show();


        else
            Toast.makeText(this,"NO EXISTE USUARIO",Toast.LENGTH_SHORT).show();





    }













}