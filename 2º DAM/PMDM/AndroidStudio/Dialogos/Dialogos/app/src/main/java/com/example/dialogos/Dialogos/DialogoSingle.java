package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSingle extends DialogFragment {

    OnSingleInterface onSingleInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onSingleInterface = (OnSingleInterface) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Titulo del DialogoSimple");
        final String[] opciones = {"Opcion1", "Opcion2", "Opcion3"};
        builder.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onSingleInterface.OnSingleSelected(opciones[which]);
                dismiss();
            }
        });
        return builder.create();
    }

    public interface OnSingleInterface {
        public void OnSingleSelected(String single);

    }
}
