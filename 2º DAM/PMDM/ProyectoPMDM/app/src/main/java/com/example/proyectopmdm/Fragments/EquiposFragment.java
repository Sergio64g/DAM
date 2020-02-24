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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectopmdm.Adapters.AdaptadorRecyclerEquipos;
import com.example.proyectopmdm.R;
import com.example.proyectopmdm.Utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EquiposFragment extends Fragment {

    private RecyclerView recyclerEquipos;
    private String urlPeticion;
    private AdaptadorRecyclerEquipos adaptadorEquipos;


    public EquiposFragment() {

    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        urlPeticion = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=4335";
        adaptadorEquipos = new AdaptadorRecyclerEquipos(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_equipos, container, false);
        recyclerEquipos = v.findViewById(R.id.recyclerEquipos);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        realizarConsulta();
        recyclerEquipos.setAdapter(adaptadorEquipos);
        recyclerEquipos.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void realizarConsulta() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlPeticion, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("teams");
                    for (int j = 0; j < jsonArray.length(); j++) {
                        JSONObject object = jsonArray.getJSONObject(j);
                        String nombre = object.getString("strTeam");
                        String imagen = object.getString("strTeamBadge");
                        String detalles = object.getString("strDescriptionES");
                        //TODO if(nombre equals nombre) .setDetalles
                        Equipo equipo = new Equipo(nombre, imagen, detalles);
                        Log.v("test", equipo.getNombre());
                        adaptadorEquipos.agregarEquipos(equipo);
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

}
