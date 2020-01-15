package com.example.versiones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


import com.example.versiones.R;
import com.example.versiones.Utils.Version;

public class Second_Activity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    TextView textoNombre, textoNumeroVersion, textoFechaSalida;
    Version v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        rellenarDatos();
    }

    private void rellenarDatos() {
        imageView.setImageResource(v.getImagen());
        textView.setText(v.getDescripcion());
        textoNombre.setText(v.getNombreVersion());
        textoFechaSalida.setText(v.getFechaSalida());
        textoNumeroVersion.setText(v.getNumeroVersion());
    }

    private void instancias() {
        if (getIntent().getExtras() != null) {
            v = (Version) getIntent().getExtras().get("TAG1");
            textView = findViewById(R.id.scroll);
            imageView = findViewById(R.id.imagenVersion);
            textoNombre = findViewById(R.id.nombreVersion);
            textoNumeroVersion = findViewById(R.id.numeroVersion);
            textoFechaSalida = findViewById(R.id.fechaVersion);
        }
    }


}
