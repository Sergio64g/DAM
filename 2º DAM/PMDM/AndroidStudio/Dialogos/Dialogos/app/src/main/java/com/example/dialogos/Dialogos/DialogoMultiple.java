package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoMultiple extends DialogFragment {

    OnMultipleInterface onMultipleInterface;
    int contador;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onMultipleInterface = (OnMultipleInterface) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Titulo del DialogoSimple");
        final String[] opciones = {"Opcion1", "Opcion2", "Opcion3"};
        builder.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                for (int i = 0; i < opciones.length; i++) {
                    if (isChecked) {
                        contador++;
                    } else {
                        contador--;
                    }
                }
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onMultipleInterface.onMultipleSelected(contador);
            }
        });
        return builder.create();
    }

    public interface OnMultipleInterface {
        public void onMultipleSelected(Integer cont);
    }


}
