package com.adssystems.integra.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adssystems.integra.R;
import com.adssystems.integra.adapter.CatalogoAdapter;
import com.adssystems.integra.model.Catalogo;
import com.adssystems.integra.util.Common;

import java.util.List;

public class HomeFragment extends Fragment {

    private View root;
    private Context context;

    private RecyclerView rvCatalogo;
    private CatalogoAdapter catalogoAdapter;

    private List<Catalogo> catalogos;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        context = root.getContext();

        initComps();
        initActions();
        initStuff();
        initRecycler();

        return root;
    }

    void initComps() {
        rvCatalogo = root.findViewById(R.id.recyclerCatalogo);
    }

    void initActions() {
    }

    void initStuff() {
        catalogos = Common.getInstance(context).getCatalogos();
    }

    void initRecycler() {
        catalogoAdapter = new CatalogoAdapter(context);
        catalogoAdapter.setCatalogos(catalogos);
        LinearLayoutManager productsManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvCatalogo.setLayoutManager(productsManager);
        rvCatalogo.setAdapter(catalogoAdapter);
    }
}