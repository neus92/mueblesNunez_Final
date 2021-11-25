package com.example.mueblesnunez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import Objetos.Materiales;

public class Home_activity extends AppCompatActivity {
    private Materiales mat = new Materiales(); //Instacia de materiales
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = findViewById(R.id.vw); //llamo por id el elemento VideoView

        //Obtego la ruta

        String ruta = "android.resource://" + getPackageName()+"/" + R.raw.video;
        Uri uri = Uri.parse(ruta); // Parseo la ruta
        videoView.setVideoURI(uri);// le paso la ruta al VideoView
        videoView.start();
        //Controles para el video
       // MediaController media = new MediaController(this); // controles para video
        //videoView.setMediaController(media);

    }




    //tarea pesada o larga duración
    public void Task(View view)
    {
        try {
            for(int i = 0; i <= 10; i++)
            {
                Thread.sleep(2200); // Duerme un proceso
            }

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void material(View view)
    {
        Intent i = new Intent(this, Materiales_act.class);
        //preparo los extras
        Bundle bun = new Bundle(); //Necesario para enviar arreglos
        bun.putStringArray("material", mat.getMaterial()); // Preparo mi bundle.
        i.putExtras(bun); // Envío el paquete a través del intent.
        startActivity(i);
    }
    public void agregarAgenda(View view)
    {
        Intent i = new Intent (getBaseContext(),Agenda_act.class);
        startActivity(i);
    }

}