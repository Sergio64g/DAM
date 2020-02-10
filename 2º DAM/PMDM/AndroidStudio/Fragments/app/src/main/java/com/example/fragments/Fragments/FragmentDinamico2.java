package com.example.fragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentDinamico2 extends Fragment {

    TextView texto;
    public static  String KEY_ARG = "KEY";
    private String nombre;


    @Override
    public void onAttach(@NonNull Context context) {
        if(this.getArguments() != null) {
            nombre = this.getArguments().getString(KEY_ARG);
        } else {
            nombre = "Sin nombre";
        }
        super.onAttach(context);
    }

    public static FragmentDinamico2 newInstance(String nombre) {

        Bundle args = new Bundle();
        args.putString(KEY_ARG, nombre);

        FragmentDinamico2 fragment = new FragmentDinamico2();

        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dinamico2, container, false);
        texto = v.findViewById(R.id.texto);
        texto.setText(nombre);
        return v;
    }


}
