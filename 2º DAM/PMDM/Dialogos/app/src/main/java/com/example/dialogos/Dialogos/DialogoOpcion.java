package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoOpcion extends DialogFragment {

    OnResultInterface resultInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
   resultInterface = (OnResultInterface) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        resultInterface = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Titulo opciones");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resultInterface.onResultSelected(": Si");
                Toast.makeText(getContext(), "Positivo", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resultInterface.onResultSelected(": No");
                Toast.makeText(getContext(), "Negativo", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resultInterface.onResultSelected("");
                Toast.makeText(getContext(), "Nu se", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public interface OnResultInterface {
        public void onResultSelected(String resultado);

    }


}
