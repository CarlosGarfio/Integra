package com.adssystems.integra.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adssystems.integra.R;
import com.adssystems.integra.model.Articulo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private Context context;
    private List<Articulo> articulos;

    public PopularAdapter(Context context) {
        this.context = context;
        this.articulos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Articulo articulo = articulos.get(position);

        holder.name.setText(articulo.name);
        holder.price.setText(articulo.price);
        Glide.with(context).load(articulo.url).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.articulos.size();
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}