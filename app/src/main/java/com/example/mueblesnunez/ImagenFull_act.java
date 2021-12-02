package com.example.mueblesnunez;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mueblesnunez.Adaptador.GaleriaImagenesAdapter;

public class ImagenFull_act extends AppCompatActivity {
    ImageView imageViewDetalle;
    GaleriaImagenesAdapter galeriaImagenesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_full);
        imageViewDetalle= findViewById(R.id.imagen_detalle);


        //Recibir el id de la imagen mediante intent
        Intent i = getIntent();
        int posicion = i.getExtras().getInt("idimagen");
        galeriaImagenesAdapter = new GaleriaImagenesAdapter(this);
        imageViewDetalle.setImageResource(
              galeriaImagenesAdapter.imagenesArray[posicion]
        );


    }
}