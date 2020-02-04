package com.example.examen_tr1_pmdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.examen_tr1_pmdm.Utils.Coche;

import java.text.Normalizer;
import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button btn;
    TextView textMarca, textModelo, textCV;
    ArrayList<Coche> coches;
    ArrayAdapter adaptadorCoches;
    final static int REQ_CODE = 1;
    final static int RES_CODE_OK = 1;
    final static int RES_CODE_FAIL = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        instancias();
        acciones();
    }

    private void instancias() {
        spinner = this.findViewById(R.id.spinner);
        btn = this.findViewById(R.id.btn);
        textMarca = this.findViewById(R.id.textMarca);
        textModelo = this.findViewById(R.id.textModelo);
        textCV = this.findViewById(R.id.textCV);
        coches = new ArrayList();
        adaptadorCoches = new ArrayAdapter(this, android.R.layout.simple_spinner_item, coches);
        spinner.setAdapter(adaptadorCoches);
    }

    private void acciones() {
        btn.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE && resultCode == RES_CODE_OK) {
            Coche c = (Coche) data.getExtras().get(FormScreen.COCHE);
            adaptadorCoches.add(c);

        } else if (requestCode == REQ_CODE && resultCode == RES_CODE_FAIL) {
            Toast.makeText(getApplicationContext(), "Se ha vuelto a la pantalla principal", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(getApplicationContext(), FormScreen.class);
        switch (v.getId()) {
            case R.id.btn:
                startActivityForResult(i, REQ_CODE);
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Coche c = (Coche) adaptadorCoches.getItem(position);
        textModelo.setText("Marca: " + c.getModelo());
        textMarca.setText("Modelo: " + c.getMarca());
        textCV.setText("CV: " + (String.valueOf(c.getCv())));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
