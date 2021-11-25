package com.example.mueblesnunez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Materiales;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador(); // instancia del administrador
    private Materiales mat = new Materiales(); //Instacia de materiales



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.idUsuario);
        pass = findViewById(R.id.idContrasena);
        msj = findViewById(R.id.idmsj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btnIniciar);

        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Aqui corremos la tarea asincrona
                new Task().execute();

            }
        });

    }


//CONFIGURAMOS LA TAREA ASINCRONA
    class Task extends AsyncTask<String,Void,String>
    {
        //Define configuracion inicial de la tarea asincronica.
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }
        //Procesa la tarea en segundo plano o en largo lapso de tiempo
        @Override
        protected String doInBackground(String... strings) {

            try{
                for(int i = 0; i <=10; i++)
                {
                    Thread.sleep(150);
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }
        // Finaliza la tare asíncrona.
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);


            String usuario = user.getText().toString().trim();
            String password = pass.getText().toString().trim();
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

            String userobj= adm.getUser().trim();
            String passobj= adm.getPass().trim();

            switch (usuario)
            {
                case "e":
                    //inicio de sesion
                    if(usuario.equals(userobj) && password.equals(passobj))
                    {
                        Intent i = new Intent(getBaseContext(),Home_activity.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    // campos vacios
                    if(usuario.equals("") && password.equals(""))
                    {

                        alerta.setMessage("Debe completar ambos campos")
                                .setCancelable(false)
                                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                    }
                                });
                        alerta.show();
                    }
                    break;
                default:
                    //Campos erroneos
                    if(!usuario.equals(userobj) && !password.equals(passobj))
                    {
                        alerta.setMessage("Usuario y/o Contraseña erroneos")
                                .setCancelable(false)
                                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {
                                        dialog.cancel();
                                    }
                                });
                        alerta.show();
                    }
                    break;
            }

        }
    }


    public void FinishSession(View view)
    {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
        alerta.setMessage("¿Esta Seguro de Salir?")
                .setCancelable(false)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        alerta.show();

    }
    public void facebook(View view)
    {
        Uri link = Uri.parse("https://www.facebook.com/Muebles-Nu%C3%B1ez-1463459157297938");
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }
    public void instagram (View view)
    {
        Uri link = Uri.parse("https://www.instagram.com/muebles.nunez.ltda/?hl=es");
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }
    public void youTube (View view)
    {
        Uri link = Uri.parse("https://www.youtube.com/watch?v=lkMI-zYZ6mU");
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }
    public void info (View view)
    {

        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}