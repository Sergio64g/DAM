package com.example.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button suma, resta, multi, divi, permitir;
    EditText operando1, operando2;
    CheckBox check;
    static final String TAG = "tag", OP = "operacion";
    boolean operac = false;
    Integer operacion = null;
    Integer res = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        suma.setOnClickListener(this);
        resta.setOnClickListener(this);
        multi.setOnClickListener(this);
        divi.setOnClickListener(this);
        permitir.setOnClickListener(this);
    }

    private void instancias() {
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multi = findViewById(R.id.multiplicacion);
        divi = findViewById(R.id.division);
        operando1 = findViewById(R.id.operando1);
        operando2 = findViewById(R.id.operando2);
        check = findViewById(R.id.check);
        permitir = findViewById(R.id.permitir);
    }


    @Override
    public void onClick(View view) {
        String op1 = operando1.getText().toString();
        String op2 = operando2.getText().toString();




        Intent i = new Intent(getApplicationContext(), SecondActivity.class);


        if (!op1.isEmpty() || !op2.isEmpty()) {
            switch (view.getId()) {
                case R.id.suma:
                    res = (Integer.valueOf(op1) + Integer.valueOf(op2));
                    operacion = 1;

                    operac = true;
                    break;
                case R.id.resta:
                    res = (Integer.valueOf(op1) - Integer.valueOf(op2));
                    operacion = 2;
                    operac = true;
                    break;
                case R.id.multiplicacion:
                    res = (Integer.valueOf(op1) * Integer.valueOf(op2));
                    operacion = 3;
                    operac = true;
                    break;
                case R.id.division:
                    res = (Integer.valueOf(op1) / Integer.valueOf(op2));
                    operacion = 4;
                    operac = true;
                    break;
                case R.id.permitir:
                    if (operac) {
                        if (check.isChecked()) {
                            String ope = null;



                            switch (operacion) {
                                case 1:
                                    ope = "suma";
                                    break;
                                case 2:
                                    ope = "resta";
                                    break;
                                case 3:
                                    ope = "multiplicación";
                                    break;
                                case 4:
                                    ope = "division";
                                    break;
                            }
                            System.out.println(res);
                            i.putExtra(TAG, res);
                            i.putExtra(OP, ope);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Permite el paso de datos", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Elige una operación", Toast.LENGTH_LONG).show();


                    }
            }

        } else {
            Toast.makeText(getApplicationContext(), "Rellena los operandos", Toast.LENGTH_LONG).show();
        }


    }
}
