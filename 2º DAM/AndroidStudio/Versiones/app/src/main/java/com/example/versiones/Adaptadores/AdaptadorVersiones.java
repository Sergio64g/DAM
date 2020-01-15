package com.example.versiones.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versiones.R;
import com.example.versiones.Utils.Version;

import java.util.ArrayList;

public class AdaptadorVersiones extends RecyclerView.Adapter<AdaptadorVersiones.MiHolder> {

    ArrayList<Version> lista;
    Context contexto;
    OnVersionListener listener;

    public AdaptadorVersiones(ArrayList<Version> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
        listener = (OnVersionListener) contexto;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MiHolder(LayoutInflater.from(contexto).inflate(R.layout.item_versiones, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Version version = lista.get(position);
        holder.getImagen().setImageResource(version.getImagen());
        holder.getNombre().setText(version.getNombreVersion());
        holder.getLinearLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.version(version);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;
        LinearLayout linearLayout;

        public MiHolder(@NonNull View v) {
            super(v);
            imagen = v.findViewById(R.id.imagenVersion);
            nombre = v.findViewById(R.id.nombreVersion);
            linearLayout = v.findViewById(R.id.linearLayout);
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

    }
    public interface OnVersionListener{
        void version(Version v);
    }
}
