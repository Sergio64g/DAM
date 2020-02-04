package com.example.fragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments.R;

public class FragmentDinamico extends Fragment {

    EditText edit;
    Button btnComunicar;
    OnDatoListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

            listener = (OnDatoListener) getContext();


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dinamico, container, false);
        edit = v.findViewById(R.id.edit);
        btnComunicar = v.findViewById(R.id.btnComunicar);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        btnComunicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDatoComunicado(edit.getText().toString());
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public interface OnDatoListener {
        public void onDatoComunicado(String text);
    }
}
