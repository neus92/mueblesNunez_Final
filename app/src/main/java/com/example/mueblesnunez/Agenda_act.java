package com.example.mueblesnunez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mueblesnunez.dataBase.AdminSQliteOpenHelper;

public class Agenda_act extends AppCompatActivity {

    private EditText code, name, date, direc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        code = findViewById(R.id.code);
        name = findViewById(R.id.name);
        date = findViewById(R.id.date);
        direc = findViewById(R.id.direc);

    }

    //Metodo para agendar
    public void agendar(View view)
    {
        //Obtengo mi dataBase
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this,"MueblesNunez",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Da permiso de sobreescritura

        //obtengo los campos que escribe el cliente
        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String fecha = date.getText().toString();
        String direccion= direc.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !fecha.isEmpty() && !direccion.isEmpty())
        {
            //guardo datos..
            ContentValues cont = new ContentValues(); //Me permite contener valores.
            cont.put("codigo",codigo);
            cont.put("nombre",nombre);
            cont.put("fecha",fecha);
            cont.put("direccion",direccion);

            db.insert("agenda",null,cont);
            db.close();
            clean();
            Toast.makeText(getBaseContext(),"Has Agendado.",Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacíos..",Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para mostrar
    public void mostrar(View view)
    {
        //Obtengo mi dataBase
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this,"MueblesNunez",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Da permiso de sobreescritura

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            //Mostramos datos
            Cursor file = db.rawQuery("SELECT nombre, fecha, direccion FROM agenda where codigo ="+codigo,null);

            if(file.moveToFirst())// VERIFICA SI LA CONSULTA TIENE O NO VALORES
            {
                name.setText(file.getString(0)); // Muestra por posicion
                date.setText(file.getString(1));
                direc.setText(file.getString(2));

            }else
            {
                Toast.makeText(getBaseContext(),"No Hay codigo cliente asociado..",Toast.LENGTH_SHORT).show();
            }


        }else
        {
            Toast.makeText(getBaseContext(),"El codigo esta vacíos..",Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para eliminar
    public void eliminar(View view)
    {
        //Obtengo mi dataBase
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this,"MueblesNunez",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Da permiso de sobreescritura

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            //Eliminamos
            db.delete("agenda","codigo="+codigo,null);
            db.close();
            clean();
            Toast.makeText(getBaseContext(),"Has eliminado una clase",Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getBaseContext(),"El código no debe estar vacío",Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo para actualizar
    public void actualizar(View view)
    {
        //Obtengo mi dataBase
        AdminSQliteOpenHelper admin = new AdminSQliteOpenHelper(this,"MueblesNunez",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Da permiso de sobreescritura

        //obtengo los campos que escribe el cliente
        String codigo = code.getText().toString();
        String nombre = name.getText().toString();
        String fecha = date.getText().toString();
        String direccion= direc.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !fecha.isEmpty() && !direccion.isEmpty())
        {
            //actualizamos
            ContentValues cont =new ContentValues();
            cont.put("codigo",codigo);
            cont.put("nombre",nombre);
            cont.put("fecha",fecha);
            cont.put("direccion",direccion);

            db.update("agenda",cont,"codigo="+codigo,null);
            db.close();
            clean();
            Toast.makeText(getBaseContext(),"Has Actualizado un cliente.",Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"Los campos no debe estar vacío",Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo limpiarCampos
    public void clean()
    {
        code.setText("");
        name.setText("");
        date.setText("");
        direc.setText("");
    }
}