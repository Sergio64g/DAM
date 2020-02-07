package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.fragments.Fragments.FragmentDinamico;

public class MainActivity extends AppCompatActivity {


    Fragment fragmentEstatico, fragmentEstatico2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        //fragmentEstatico = this.findViewById(R.id.fragmentEstatico);
        FragmentManager fg = getSupportFragmentManager();
    fragmentEstatico = fg.findFragmentById(R.id.fragmentEstatico);
    fragmentEstatico2 = fg.findFragmentById(R.id.fragmentEstatico2);

    }
}
