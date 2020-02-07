package com.example.ejercicio_versiones.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio_versiones.R;
import com.example.ejercicio_versiones.utils.Version;

import java.util.ArrayList;

public class AdaptadorVersiones extends RecyclerView.Adapter<AdaptadorVersiones.myHolder> {
    ArrayList<Version> lista;
    Context context;
    OnMiRecyclerListener listener;




    public AdaptadorVersiones(ArrayList<Version> lista, Context context) {
        this.lista = lista;
        this.context = context;
        listener = (OnMiRecyclerListener) context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout_versiones, parent, false);
        myHolder holder = new myHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
    final Version version = lista.get(position);
    holder.getNombreVersion().setText(version.getNombreVersion());
    holder.getImagenVersion().setImageResource(version.getIdImagen());
    holder.getNombreVersion().setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listener.llamarVersion(version);
        }
    });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class myHolder extends RecyclerView.ViewHolder{
        ImageView imagenVersion;
        TextView nombreVersion;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            imagenVersion = itemView.findViewById(R.id.imagenVersion);
            nombreVersion = itemView.findViewById(R.id.nombreVersion);
        }

        public ImageView getImagenVersion() {
            return imagenVersion;
        }

        public TextView getNombreVersion() {
            return nombreVersion;
        }
    }


    public interface OnMiRecyclerListener{
        void llamarVersion(Version v);
    }
}





