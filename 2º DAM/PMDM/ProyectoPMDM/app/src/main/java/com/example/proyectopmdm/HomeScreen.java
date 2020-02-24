package com.example.proyectopmdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.proyectopmdm.Adapters.AdaptadorRecyclerEquipos;
import com.example.proyectopmdm.Adapters.FragmentAdapter;
import com.example.proyectopmdm.Fragments.EquiposFragment;
import com.example.proyectopmdm.Fragments.PerfilFragment;
import com.example.proyectopmdm.Utils.Equipo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity implements AdaptadorRecyclerEquipos.OnStarInterface {

    private Toolbar toolBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentAdapter adaptador;
    private ArrayList<Equipo> listaEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        instancias();
        rellenarPager();
        acciones();
        colorearTabLayout();


    }


    private void instancias() {
        listaEquipos = new ArrayList();
        toolBar = this.findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        viewPager = this.findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void rellenarPager() {
        ArrayList<Fragment> listaFragments = new ArrayList();
        EquiposFragment equiposFragment = new EquiposFragment();
        ArrayList<Equipo> equiposFav = listaEquipos;
        //TODO pasar a new Instance listaEquipos
        PerfilFragment perfilFragment = new PerfilFragment();
        listaFragments.add(perfilFragment);
        listaFragments.add(equiposFragment);

        adaptador = new FragmentAdapter(getSupportFragmentManager(), 0, listaFragments);
        viewPager.setAdapter(adaptador);
    }

    private void acciones() {

    }


    public void colorearTabLayout() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            //TODO colorear TabLayout
                Fragment temp = adaptador.getItem(position);
                Drawable drawable = temp.getView().findViewById(R.id.fragmentLayout).getBackground();
                tabLayout.setBackground(drawable);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onStarSelected(Equipo e, boolean selected) {
        if (selected == true) {
            listaEquipos.add(e);
        } else {
            listaEquipos.remove(e);
        }
    }
}
