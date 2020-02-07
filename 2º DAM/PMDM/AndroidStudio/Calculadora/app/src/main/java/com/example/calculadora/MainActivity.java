package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnum1, btnum2, btnum3, btnum4, btnum5, btnum6,
            btnum7, btnum8, btnum9, btnum0, btnsuma, btnresta,
            btnproducto, btndividir, btnreset, btnigual, btndecimal, btnlog, btnsen, btncos, btntan;

    TextView MostrarResultado;
    double resultado;
    String operador, mostrar, reserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void instancias() {
        btnum0 = this.findViewById(R.id.num0);
        btnum1 = this.findViewById(R.id.num1);
        btnum2 = this.findViewById(R.id.num2);
        btnum3 = this.findViewById(R.id.num3);
        btnum4 = this.findViewById(R.id.num4);
        btnum5 = this.findViewById(R.id.num5);
        btnum6 = this.findViewById(R.id.num6);
        btnum7 = this.findViewById(R.id.num7);
        btnum8 = this.findViewById(R.id.num8);
        btnum9 = this.findViewById(R.id.num9);
        btnsuma = this.findViewById(R.id.suma);
        btnresta = this.findViewById(R.id.resta);
        btnproducto = this.findViewById(R.id.multiplicar);
        btndividir = this.findViewById(R.id.dividir);
        btnreset = this.findViewById(R.id.reset);
        btnigual = this.findViewById(R.id.igual);
        btndecimal = this.findViewById(R.id.decimal);
        MostrarResultado = this.findViewById(R.id.mostrarresultado);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            btnlog = this.findViewById(R.id.logaritmo);
            btnsen = this.findViewById(R.id.seno);
            btncos = this.findViewById(R.id.coseno);
            btntan = this.findViewById(R.id.tangente);
        }


    }

    private void acciones() {

        btnum0.setOnClickListener(this);
        btnum1.setOnClickListener(this);
        btnum2.setOnClickListener(this);
        btnum3.setOnClickListener(this);
        btnum4.setOnClickListener(this);
        btnum5.setOnClickListener(this);
        btnum6.setOnClickListener(this);
        btnum7.setOnClickListener(this);
        btnum8.setOnClickListener(this);
        btnum9.setOnClickListener(this);
        btnsuma.setOnClickListener(this);
        btnresta.setOnClickListener(this);
        btnproducto.setOnClickListener(this);
        btndividir.setOnClickListener(this);
        btnreset.setOnClickListener(this);
        btnigual.setOnClickListener(this);
        btndecimal.setOnClickListener(this);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
        btnlog.setOnClickListener(this);
        btnsen.setOnClickListener(this);
        btncos.setOnClickListener(this);
        btntan.setOnClickListener(this);}

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.num0:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "0";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num1:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "1";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num2:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "2";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num3:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "3";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num4:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "4";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num5:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "5";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num6:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "6";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num7:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "7";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num8:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "8";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.num9:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "9";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.suma:
                reserva = MostrarResultado.getText().toString();
                operador = "+";
                MostrarResultado.setText("");
                break;
            case R.id.resta:
                reserva = MostrarResultado.getText().toString();
                operador = "-";
                MostrarResultado.setText("");
                break;
            case R.id.multiplicar:
                reserva = MostrarResultado.getText().toString();
                operador = "*";
                MostrarResultado.setText("");
                break;
            case R.id.dividir:
                reserva = MostrarResultado.getText().toString();
                operador = "/";
                MostrarResultado.setText("");
                break;
            case R.id.reset:
                mostrar = "";
                MostrarResultado.setText(mostrar);
                reserva = "";
                operador = "";
                break;
            case R.id.igual:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + "1";
                if (operador.equals("-")) {
                    resultado = Double.parseDouble(reserva) - Double.parseDouble(MostrarResultado.getText().toString());
                    MostrarResultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("+")) {
                    resultado = Double.parseDouble(reserva) + Double.parseDouble(MostrarResultado.getText().toString());
                    MostrarResultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("/")) {
                    resultado = Double.parseDouble(reserva) / Double.parseDouble(MostrarResultado.getText().toString());
                    MostrarResultado.setText(String.valueOf(resultado));
                }
                if (operador.equals("*")) {
                    resultado = Double.parseDouble(reserva) * Double.parseDouble(MostrarResultado.getText().toString());
                    MostrarResultado.setText(String.valueOf(resultado));
                }
                break;
            case R.id.decimal:
                mostrar = MostrarResultado.getText().toString();
                mostrar = mostrar + ".";
                MostrarResultado.setText(mostrar);
                break;
            case R.id.seno:
                resultado = Math.sin(Double.parseDouble(MostrarResultado.getText().toString()));
                MostrarResultado.setText(String.valueOf(resultado));
                break;
            case R.id.coseno:
                resultado = Math.cos(Double.parseDouble(MostrarResultado.getText().toString()));
                MostrarResultado.setText(String.valueOf(resultado));
                break;
            case R.id.tangente:
                resultado = Math.tan(Double.parseDouble(MostrarResultado.getText().toString()));
                MostrarResultado.setText(String.valueOf(resultado));
                break;
            case R.id.logaritmo:
                resultado = Math.log(Double.parseDouble(MostrarResultado.getText().toString()));
                MostrarResultado.setText(String.valueOf(resultado));
                break;


        }

    }
}
