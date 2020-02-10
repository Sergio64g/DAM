package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments.Fragments.FragmentDinamico;
import com.example.fragments.Fragments.FragmentDinamico2;

public class DinamicosActivity extends AppCompatActivity implements FragmentDinamico.OnDatoListener {

    FragmentManager fg;
    FragmentTransaction ft;
    Button f1, f2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamicos);

        instancias();
        acciones();
    }

    private void acciones() {
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.frameFragment, new FragmentDinamico(), "TAG_FG");
                ft.addToBackStack("TAG_FG");

                ft.commit();

            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.frameFragment, new FragmentDinamico2(), "TAG_FG2");
                ft.addToBackStack("TAG_FG2");
                ft.commit();
            }
        });
    }

    private void instancias() {
        f1 = this.findViewById(R.id.btnFr1);
        f2 = this.findViewById(R.id.btnFr2);
        fg = getSupportFragmentManager();
        ft = fg.beginTransaction();

    }

    @Override
    public void onDatoComunicado(String text) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        System.out.println(text);
        ft.replace(R.id.frameFragment, new FragmentDinamico2().newInstance(text), "TAG_FG2");
        ft.addToBackStack("TAG_FG2");
        ft.commit();


    }
}