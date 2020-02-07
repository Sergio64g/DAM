package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoItem extends DialogFragment {

    OnItemInterface onItemInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onItemInterface = (OnItemInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onItemInterface = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Titulo items");
        final String[] opciones = {"Opcion1", "Opcion2", "Opcion3"};


        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onItemInterface.onItemSelected(opciones[which]);
            }
        });

        return builder.create();
    }

    public interface OnItemInterface {
        public void onItemSelected(String s);
    }
}
