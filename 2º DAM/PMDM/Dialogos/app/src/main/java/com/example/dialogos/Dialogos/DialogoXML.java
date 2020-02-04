package com.example.dialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;

public class DialogoXML extends DialogFragment {

    Button btn;
    EditText editNombre, editPassword;
    OnUsuarioInterface onUsuarioInterface;


    View view;

    @Override
    public void onAttach(Context context) {
        onUsuarioInterface = (OnUsuarioInterface) context;
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_xml, null);
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        instancias();
        acciones();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setView(view);


        return builder.create();
    }

    private void acciones() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUsuarioInterface.OnUsuarioRegistred(editNombre.getText().toString(), editPassword.getText().toString());

                dismiss();
            }
        });
    }

    private void instancias() {
        btn = view.findViewById(R.id.btn);
        editNombre= view.findViewById(R.id.editTextNombre);
        editPassword= view.findViewById(R.id.editTextPassword);
    }

    public interface OnUsuarioInterface{
        public void OnUsuarioRegistred(String nombre, String password);

    }
}
