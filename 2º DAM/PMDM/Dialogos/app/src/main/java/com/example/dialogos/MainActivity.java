package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dialogos.Dialogos.DialogoFecha;
import com.example.dialogos.Dialogos.DialogoInformacion;
import com.example.dialogos.Dialogos.DialogoItem;
import com.example.dialogos.Dialogos.DialogoMultiple;
import com.example.dialogos.Dialogos.DialogoOpcion;
import com.example.dialogos.Dialogos.DialogoPersonalizado;
import com.example.dialogos.Dialogos.DialogoSingle;
import com.example.dialogos.Dialogos.DialogoXML;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoOpcion.OnResultInterface,
        DialogoItem.OnItemInterface, DialogoSingle.OnSingleInterface, DialogoMultiple.OnMultipleInterface, DialogoXML.OnUsuarioInterface, DatePickerDialog.OnDateSetListener {

    Button boton, boton2, boton3, boton4, boton5, boton6, boton7, boton8;
    TextView opciones, opciones3, opciones4, opciones5, opciones6, opciones7, opciones8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        instancias();
        acciones();
    }

    private void acciones() {
        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
    }

    private void instancias() {
        boton = this.findViewById(R.id.botonDialogo);
        boton2 = this.findViewById(R.id.botonDialogo2);
        boton3 = this.findViewById(R.id.botonDialogo3);
        boton4 = this.findViewById(R.id.botonDialogo4);
        boton5 = this.findViewById(R.id.botonDialogo5);
        boton6 = this.findViewById(R.id.botonDialogo6);
        boton7 = this.findViewById(R.id.botonDialogo7);
        boton8 = this.findViewById(R.id.botonDialogo8);
        opciones = this.findViewById(R.id.opciones);
        opciones3 = this.findViewById(R.id.opciones3);
        opciones4 = this.findViewById(R.id.opciones4);
        opciones5 = this.findViewById(R.id.opciones5);
        opciones6 = this.findViewById(R.id.opciones6);
        opciones7 = this.findViewById(R.id.opciones7);
        opciones8 = this.findViewById(R.id.opciones8);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonDialogo:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "Ejemplo");
                break;
            case R.id.botonDialogo2:
                DialogoOpcion dialogoOpcion = new DialogoOpcion();
                dialogoOpcion.show(getSupportFragmentManager(), "Opcion");
                break;
            case R.id.botonDialogo3:
                DialogoPersonalizado dialogoPersonalizado = DialogoPersonalizado.newInstance("PEPE");
                dialogoPersonalizado.show(getSupportFragmentManager(), "Personalizado");
                break;
            case R.id.botonDialogo4:
                DialogoItem dialogoItem = new DialogoItem();
                dialogoItem.show(getSupportFragmentManager(), "Item");
                break;
            case R.id.botonDialogo5:
                DialogoSingle dialogoSingle = new DialogoSingle();
                dialogoSingle.show(getSupportFragmentManager(), "Single");
                break;
            case R.id.botonDialogo6:
                DialogoMultiple dialogoMultiple = new DialogoMultiple();
                dialogoMultiple.show(getSupportFragmentManager(), "Multiple");
                break;
                case R.id.botonDialogo7:
                    DialogoXML dialogoXML =  new DialogoXML();
                    dialogoXML.show(getSupportFragmentManager(), "XML");
                    break;

                    case R.id.botonDialogo8:
                        DialogoFecha dialogoFecha = new DialogoFecha();
                        dialogoFecha.show(getSupportFragmentManager(), "Fecha");
                        break;

        }
    }

    @Override
    public void onResultSelected(String resultado) {
        if (resultado != "") {
            opciones.setText("Opcion" + resultado);
        } else {
            opciones.setText("Opciones");
        }
    }

    @Override
    public void onItemSelected(String s) {
        opciones4.setText(s);
    }

    @Override
    public void OnSingleSelected(String single) {
        opciones5.setText(single);
    }

    @Override
    public void onMultipleSelected(Integer cont) {
        opciones6.setText(cont + " seleccionados");
    }

    @Override
    public void OnUsuarioRegistred(String nombre, String password) {
        opciones7.setText(nombre + " " + password);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }
}
