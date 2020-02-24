package com.example.proyectopmdm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectopmdm.R;
import com.example.proyectopmdm.Utils.Equipo;

import java.util.ArrayList;

public class AdaptadorRecyclerPerfil extends RecyclerView.Adapter<AdaptadorRecyclerPerfil.MyHolder> {


    private ArrayList<Equipo> listaEquiposFav;
    private Context context;


    public AdaptadorRecyclerPerfil(Context context) {
        this.context = context;
        listaEquiposFav = new ArrayList();
    }

    public void addEquipo(Equipo e) {
        listaEquiposFav.add(e);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_perfil, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Equipo equipo = listaEquiposFav.get(position);
        holder.getNombreEquipo().setText(equipo.getNombre());
        holder.getDetalleEquipo().setText(equipo.getDetalles());
        Glide.with(context).load(equipo.getImagenEquipo()).into(holder.getImagenEquipo());
    }

    @Override
    public int getItemCount() {
        return listaEquiposFav.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imagenEquipo;
        TextView nombreEquipo, detalleEquipo;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imagenEquipo = itemView.findViewById(R.id.imagenEquipo);
            nombreEquipo = itemView.findViewById(R.id.nombreEquipo);
            detalleEquipo = itemView.findViewById(R.id.detalleEquipo);
        }

        public ImageView getImagenEquipo() {
            return imagenEquipo;
        }

        public TextView getNombreEquipo() {
            return nombreEquipo;
        }

        public TextView getDetalleEquipo() {
            return detalleEquipo;
        }
    }
}
