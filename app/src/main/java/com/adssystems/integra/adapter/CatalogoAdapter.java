package com.adssystems.integra.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.adssystems.integra.R;
import com.adssystems.integra.model.Catalogo;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.ViewHolder> {

    private Context context;
    private List<Catalogo> catalogos;

    public CatalogoAdapter(Context context) {
        this.context = context;
        this.catalogos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catalogo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Catalogo catalogo = catalogos.get(position);

        holder.txt.setText(catalogo.txt);
        Glide.with(context).load(catalogo.url).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return this.catalogos.size();
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txt;

        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}