package com.herprogramacion.restaurantericoparico.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.herprogramacion.restaurantericoparico.R;
import com.herprogramacion.restaurantericoparico.modelo.Contenido;

/**
 * Adaptador para mostrar las comidas más pedidas en la sección "Inicio"
 */
public class AdaptadorInicio
        extends RecyclerView.Adapter<AdaptadorInicio.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
        }
    }

    public AdaptadorInicio() {
    }

    @Override
    public int getItemCount() {
        return Contenido.PRINCIPAL.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_inicio, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Contenido item = Contenido.PRINCIPAL.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getIdDrawable())
                .centerCrop()
                .into(viewHolder.imagen);
    }
}