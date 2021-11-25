package com.example.mueblesnunez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Materiales;

public class Materiales_act extends AppCompatActivity {
    private Materiales mat = new Materiales();
    private Spinner material;
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiales);

        material = findViewById(R.id.spnmateriales);
        result = findViewById(R.id.result);
        estrella =findViewById(R.id.rbestrella);

        //Recibo los extras

       Bundle bun = getIntent().getExtras(); //Recibo extrar y se guarda en un bundle.
       String[] listado = bun.getStringArray("material"); //Reciblo el arreglo por la referencia

        ArrayAdapter adaptMateriales = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        material.setAdapter(adaptMateriales);
    }

    //Método para calcular materiales...

    public void Calculo(View view)
    {
        String opcion = material.getSelectedItem().toString(); // Obtener la seleccion del spinner
        int precio = 0;
        int preciofinal= 0;
        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(mat.getMaterial()[i])) // segun el insumo seleccionado...
            {
               precio = mat.getPrecios()[i];//muestro precios
                preciofinal = mat.anadirAdicional(mat.getPrecios()[i],20000);  // Obtengo regla de negocio.
                estrella.setRating(i+1); // pintar estrellas.
                break;
            }
        }

        result.setText("El material escogido es: " + opcion + "\nEl precio referencial es desde: $" + precio+ " para un mueble cocina de 4 mt2. Agregando el valor de transporte correspondiente a $20.000, el valor final es $" +preciofinal);

    }


}