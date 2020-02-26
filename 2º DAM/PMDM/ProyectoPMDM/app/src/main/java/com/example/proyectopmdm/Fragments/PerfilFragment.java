package com.example.proyectopmdm.Fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectopmdm.Adapters.AdaptadorRecyclerPerfil;
import com.example.proyectopmdm.R;
import com.example.proyectopmdm.Utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {



    private ImageView userImage;
    private TextView userName;
    private ArrayList listaEquipos;
    private RecyclerView recyclerPerfil;
    private AdaptadorRecyclerPerfil adaptadorRecyclerPerfil;
    private String urlPeticion;

    //TODO newInstance con nombre
    public PerfilFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listaEquipos = new ArrayList();
        urlPeticion = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=4335";
        adaptadorRecyclerPerfil = new AdaptadorRecyclerPerfil(context);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_perfil, container, false);
        userImage = v.findViewById(R.id.userImage);
        userName = v.findViewById(R.id.userName);
        recyclerPerfil = v.findViewById(R.id.recyclerPerfil);

        return v;
    }



    public void peticionInicial(){
        JsonObjectRequest request =  new JsonObjectRequest(Request.Method.GET, urlPeticion, null, new Response.Listener<JSONObject>()  {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.v("test", "test");
                    JSONArray jsonArray = response.getJSONArray("teams");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String deporte = jsonObject.getString("strTeam");
                        String imagen = jsonObject.getString("strTeamBadge");
                        String detalles = jsonObject.getString("strDescriptionES");

                        if (deporte.toLowerCase().equals("soccer") && deporte.toLowerCase().length()>0){
                            Equipo equipo = new Equipo(deporte, imagen, detalles);
                            Log.v("test", equipo.getNombre());


                            adaptadorRecyclerPerfil.addEquipo(equipo);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Volley.newRequestQueue(getContext()).add(request);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        peticionInicial();
        //TODO recyclerPerfil
        recyclerPerfil.setAdapter(adaptadorRecyclerPerfil);
        recyclerPerfil.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

}
