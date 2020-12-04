package com.adssystems.integra.util;

import android.content.Context;

import com.adssystems.integra.model.Catalogo;

import java.util.ArrayList;
import java.util.List;

public class Common {

    private static Common mInstance;
    private final Context context;

    private List<Catalogo> catalogos;

    private Common(Context context) {
        this.context = context;

        this.catalogos = new ArrayList<>();
        this.catalogos.add(new Catalogo("Moda hombres", "https://cdn.pixabay.com/photo/2016/11/22/22/25/beard-1850932_960_720.jpg"));
        this.catalogos.add(new Catalogo("Moda mujeres", "https://cdn.pixabay.com/photo/2020/10/23/16/50/woman-5679284_960_720.jpg"));
        this.catalogos.add(new Catalogo("Bebidas", "https://cdn.pixabay.com/photo/2016/07/26/16/16/wine-1543170_960_720.jpg"));
    }

    public static synchronized Common getInstance(Context context) {
        return (mInstance == null) ? mInstance = new Common(context) : mInstance;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }
}