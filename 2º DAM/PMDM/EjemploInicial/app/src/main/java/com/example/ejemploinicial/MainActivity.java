package com.example.ejemploinicial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonPulsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        instancias();

    }

    private void instancias()  {

     botonPulsar = findViewById(R.id.btnPulsar);

    }
}
