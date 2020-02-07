package com.example.ejercicio_versiones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejercicio_versiones.utils.Version;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    TextView textoNombre, textoNumeroVersion, textoFechaSalida;
    Version v;
    ScrollView scrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        rellenarDatos();
    }

    private void rellenarDatos() {

        ;
        imageView.setImageResource(v.getIdImagen());
        textView.setText(v.getDescripcion());
        textoNombre.setText(v.getNombreVersion());
        textoFechaSalida.setText(v.getFechaSalida());
        textoNumeroVersion.setText(v.getNumeroVersion());
    }

    private void instancias() {
        scrollView = new ScrollView(getApplicationContext());
        //if(getIntent().getExtras() != null)
        v = (Version)getIntent().getExtras().get("TAG1");
        textView = findViewById(R.id.scroll);
        imageView = findViewById(R.id.imagenVers);
        textoNombre = findViewById(R.id.nombreVers);
        textoNumeroVersion = findViewById(R.id.numeroVers);
        textoFechaSalida = findViewById(R.id.fechaVers);
    }


}
