package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoPersonalizado extends DialogFragment {


    String nombreRecuperado;

    public static DialogoPersonalizado newInstance(String nombre) {
        DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
        Bundle bundle = new Bundle();
        bundle.putString("Nombre", nombre);
        dialogoPersonalizado.setArguments(bundle);
        return dialogoPersonalizado;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(nombreRecuperado + " Personalizado");


        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        this.nombreRecuperado = (String) this.getArguments().get("Nombre");
        super.onAttach(context);
    }
}
