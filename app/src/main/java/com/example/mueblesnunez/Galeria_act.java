package com.example.mueblesnunez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mueblesnunez.Adaptador.GaleriaImagenesAdapter;

public class Galeria_act extends AppCompatActivity {
    GridView gridViewImagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        gridViewImagenes = findViewById(R.id.grid_view_imagenes);
        gridViewImagenes.setAdapter(new GaleriaImagenesAdapter(this));

        gridViewImagenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        ImagenFull_act.class);

                //pasar el parametro al intent
                intent.putExtra("idimagen",i);
                startActivity(intent);

            }
        });
    }
}