package com.example.examenpmdm;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        texto = findViewById(R.id.texto);
    }

    private void recuperarDatos() {
        if (getIntent().getExtras() != null) {
            Integer resultado = (Integer) getIntent().getExtras().get(MainActivity.TAG);
            String op = (String) getIntent().getExtras().get(MainActivity.OP);


            String text = String.format("El resultado de la %s es %d", op, resultado);

            texto.setText(text);

        }
    }


}

