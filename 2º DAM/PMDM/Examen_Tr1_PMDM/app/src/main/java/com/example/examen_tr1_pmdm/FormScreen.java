package com.example.examen_tr1_pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.examen_tr1_pmdm.Utils.Coche;

import java.util.ArrayList;

public class FormScreen extends AppCompatActivity implements View.OnClickListener {
    Spinner spinnerMarca;
    EditText editModelo, editCV;
    Button btnAgregar, btnVolver;
    ArrayList<String> marcas;
    ArrayAdapter adaptadorMarcas;
    static final String COCHE = "coche";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_screen);
        instancias();
        acciones();

    }

    private void instancias() {
        spinnerMarca = this.findViewById(R.id.spinnerMarca);
        editModelo = this.findViewById(R.id.editModelo);
        editCV = this.findViewById(R.id.editCV);
        btnAgregar = this.findViewById(R.id.btnAgregar);
        btnVolver = this.findViewById(R.id.btnVolver);
        marcas = new ArrayList();
        rellenarArray();
        adaptadorMarcas = new ArrayAdapter(this, android.R.layout.simple_spinner_item, marcas);
        spinnerMarca.setAdapter(adaptadorMarcas);
    }

    private void rellenarArray() {
        marcas.add("Ford");
        marcas.add("Toyota");
        marcas.add("Mercedes");
        marcas.add("Audi");
        marcas.add("Volkwagen");
        marcas.add("BMW");
        marcas.add("Mini");
        marcas.add("Nissan");
        marcas.add("Otras");
    }

    private void acciones() {
        btnAgregar.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnAgregar:
                if (!editModelo.getText().toString().isEmpty() && !editCV.getText().toString().isEmpty()) {
                    Coche c = new Coche((String) adaptadorMarcas.getItem(spinnerMarca.getSelectedItemPosition()), editModelo.getText().toString(), Integer.valueOf(editCV.getText().toString()));
                    Intent i = new Intent();
                    i.putExtra(COCHE, c);
                    setResult(HomeScreen.RES_CODE_OK, i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Rellene todos los datos", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnVolver:
                setResult(HomeScreen.RES_CODE_FAIL);
                finish();
                break;
        }

    }
}
