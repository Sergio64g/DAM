package com.example.proyectopmdm.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectopmdm.R;
import com.example.proyectopmdm.Utils.Equipo;
import com.example.proyectopmdm.Utils.Helper.HelperFavorito;

import java.util.ArrayList;

public class AdaptadorRecyclerEquipos extends RecyclerView.Adapter<AdaptadorRecyclerEquipos.HolderEquipos> {

    ArrayList<Equipo> listaEquipos;
    Context context;
    OnStarInterface onStarInterface;
    HelperFavorito helperFavorito;

    public AdaptadorRecyclerEquipos(Context context) {
        this.context = context;
        listaEquipos = new ArrayList();
        onStarInterface = (OnStarInterface) context;
        helperFavorito = new HelperFavorito(context, HelperFavorito.NOMBRE_DB, null, HelperFavorito.VERSION);
    }

    public void agregarEquipos(Equipo e) {
        if (!helperFavorito.equipoExists(e)) {
            helperFavorito.insertEquipo(e);
        }
        listaEquipos.add(e);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderEquipos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_equipos, parent, false);
        return new HolderEquipos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderEquipos holder, int position) {
//TODO la estrella se repite
        final Equipo e = listaEquipos.get(position);
        holder.getNombreEquipo().setText(e.getNombre());
        holder.getDetalleEquipo().setText(e.getDetalles());
        if (e.isFavorito() == 0) {
            holder.getStar().setSelected(false);
        } else {
            holder.getStar().setSelected(true);
        }
        Glide.with(context).load(e.getImagenEquipo()).into(holder.getImagenEquipo());
        holder.getStar().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onStarInterface.onStarSelected(e, isChecked);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    class HolderEquipos extends RecyclerView.ViewHolder {

        ImageView imagenEquipo;
        TextView nombreEquipo, detalleEquipo;
        CheckBox star;

        public HolderEquipos(@NonNull View itemView) {
            super(itemView);
            imagenEquipo = itemView.findViewById(R.id.imagenEquipo);
            nombreEquipo = itemView.findViewById(R.id.nombreEquipo);
            detalleEquipo = itemView.findViewById(R.id.detalleEquipo);
            star = itemView.findViewById(R.id.star);
            itemView.setTag(this);
        }

        public HolderEquipos getTag() {
            return this.getTag();
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

        public CheckBox getStar() {
            return star;
        }
    }


    public interface OnStarInterface {
        public void onStarSelected(Equipo e, boolean selected);
    }
}
