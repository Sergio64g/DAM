package com.example.ejercicio_versiones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.ejercicio_versiones.Adaptadores.AdaptadorVersiones;
import com.example.ejercicio_versiones.utils.Version;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorVersiones.OnMiRecyclerListener {
    RecyclerView recyclerVersiones;
    ImageView imagenTitulo, imagenFotter;
    AdaptadorVersiones adaptadorVersiones;
    ArrayList<Version> listaVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurarRecycler();
    }

    private void configurarRecycler() {
        recyclerVersiones.setAdapter(adaptadorVersiones);
        listaVersion.add(new Version(R.drawable.apple_pie, "apple pie", "Descripcion ", "26 Diciembre ", "1.9"));
        listaVersion.add(new Version(R.drawable.gingerbread, "gingerbread", "Descripcion", "26 Diciembre ", "1.9"));
        listaVersion.add(new Version(R.drawable.android_oreo, "oreo", "Descripcion", "27 Diciembre ", "1.3"));
        listaVersion.add(new Version(R.drawable.banana, "banana", "Descripcion", "28 Diciembre ", "1.2"));
        listaVersion.add(new Version(R.drawable.android8, "android 8", "Descripcion", "29 Diciembre ", "1.1"));
        listaVersion.add(new Version(R.drawable.android9, "android 9", "Descripcion", "30 Diciembre ", "1.01"));
        listaVersion.add(new Version(R.drawable.android10, "android 10", "Descripcion", "31 Diciembre ", "1.21"));
        adaptadorVersiones.notifyDataSetChanged();
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        recyclerVersiones.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }

    private void instancias() {
        recyclerVersiones = findViewById(R.id.recyclerVersiones);
        imagenFotter = findViewById(R.id.imagenFotter);
        imagenTitulo = findViewById(R.id.imagenTitulo);
        listaVersion = new ArrayList();
        adaptadorVersiones = new AdaptadorVersiones(listaVersion, MainActivity.this);
    }

    @Override
    public void llamarVersion(Version v) {
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("TAG1", v);
        startActivity(i);
    }
}
