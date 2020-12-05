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
import com.adssystems.integra.model.Product;
import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {


    private final DecimalFormat formatter = new DecimalFormat("$#,###.00");

    private Context context;
    private List<Product> products;

    public ProductAdapter(Context context) {
        this.context = context;
        this.products = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Product product = products.get(position);

        holder.name.setText(product.name);
        Glide.with(context).load(product.url).into(holder.img);
        holder.quantity.setText(String.valueOf(product.quantity));
        holder.price.setText(formatter.format(product.price * product.quantity));
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name;
        TextView price;
        TextView quantity;


        public ViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            quantity = itemView.findViewById(R.id.quantity);
        }
    }
}