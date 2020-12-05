package com.adssystems.integra.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adssystems.integra.R;
import com.adssystems.integra.adapter.CatalogoAdapter;
import com.adssystems.integra.adapter.PopularAdapter;
import com.adssystems.integra.adapter.ProductAdapter;
import com.adssystems.integra.model.Articulo;
import com.adssystems.integra.model.Catalogo;
import com.adssystems.integra.model.Product;
import com.adssystems.integra.util.Common;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

public class ShoppingCartFragment extends Fragment {

    private View root;
    private Context context;

    private RecyclerView rvProducts;
    private ProductAdapter productAdapter;

    private TextView txtTotalAmount;
    private double totalAmount;
    private final DecimalFormat formatter = new DecimalFormat("$#,###.00");

    public static ShoppingCartFragment newInstance() {
        return new ShoppingCartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        context = root.getContext();

        initComps();
        initActions();
        initStuff();
        initRecycler();

        return root;
    }

    void initComps() {
        rvProducts = root.findViewById(R.id.recyclerProduct);
        txtTotalAmount = root.findViewById(R.id.txtTotalAmount);
    }

    void initActions() {
    }

    void initStuff() {
        totalAmount = 0d;
        for (Product product : Common.getInstance(context).getProducts())
            totalAmount += product.price * product.quantity;
        txtTotalAmount.setText(formatter.format(totalAmount));
    }

    void initRecycler() {
        productAdapter = new ProductAdapter(context);
        productAdapter.setProducts(Common.getInstance(context).getProducts());
        LinearLayoutManager productsManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(productsManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.rvProducts.getContext(), productsManager.getOrientation());
        rvProducts.addItemDecoration(dividerItemDecoration);
        rvProducts.setAdapter(productAdapter);
    }
}