package com.adssystems.integra.util;

import android.content.Context;

import com.adssystems.integra.model.Articulo;
import com.adssystems.integra.model.Catalogo;
import com.adssystems.integra.model.Product;
import com.adssystems.integra.model.User;

import java.util.ArrayList;
import java.util.List;

public class Common {

    private static Common mInstance;
    private final Context context;

    private User user;
    private List<Catalogo> catalogos;
    private List<Articulo> articulos;
    private List<Product> products;

    private Common(Context context) {
        this.context = context;

        this.user = new User("Beatriz Gurrola Jurado", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/83637721_10220681514008873_7690709001612296192_o.jpg?_nc_cat=104&ccb=2&_nc_sid=09cbfe&_nc_eui2=AeFpd262LduhgSfJcDEXMlkO9tezNoTeKS7217M2hN4pLkYoyK2ddFTgZe0TNgtvMWXD4jMdOmaeCJ806djiXLgM&_nc_ohc=I3uEuiY2UtkAX_yjJEn&_nc_ht=scontent.fcuu2-1.fna&oh=b7598788e96a7f7062f80ea43c72cef6&oe=5FEFE173");

        this.catalogos = new ArrayList<>();
        this.catalogos.add(new Catalogo("Moda hombres", "https://cdn.pixabay.com/photo/2016/11/22/22/25/beard-1850932_960_720.jpg"));
        this.catalogos.add(new Catalogo("Moda mujeres", "https://cdn.pixabay.com/photo/2020/10/23/16/50/woman-5679284_960_720.jpg"));
        this.catalogos.add(new Catalogo("Bebidas", "https://cdn.pixabay.com/photo/2016/07/26/16/16/wine-1543170_960_720.jpg"));
        this.catalogos.add(new Catalogo("Telefonos", "https://cdn.pixabay.com/photo/2014/08/05/10/27/iphone-410311_960_720.jpg"));
        this.catalogos.add(new Catalogo("Computadoras", "https://cdn.pixabay.com/photo/2014/05/02/21/50/laptop-336378_960_720.jpg"));
        this.catalogos.add(new Catalogo("Casa inteligente", "https://cdn.pixabay.com/photo/2019/01/08/10/58/smart-home-3920905_960_720.jpg"));

        this.articulos = new ArrayList<>();
        this.articulos.add(new Articulo("iPhone X", "$8,500.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/p960x960/128570584_3556539751066854_5214347345630144994_o.jpg?_nc_cat=100&ccb=2&_nc_sid=843cd7&_nc_eui2=AeEMLrMHj16SXNH7APQnAE_-Fv3UaouKI2cW_dRqi4ojZ8EP9ciyeIFTDjJMDqA5EEKCU-6_a5MKcC84LlgAExwc&_nc_ohc=UvbiSqkh0wgAX8_T2iq&_nc_ht=scontent.fcuu2-1.fna&tp=6&oh=521b58e9b7d7b977e4adcb399bc06df3&oe=5FF13CD6"));
        this.articulos.add(new Articulo("Joggers", "$200.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/127714078_1902391159899116_3539684986056552385_n.jpg?_nc_cat=102&ccb=2&_nc_sid=843cd7&_nc_eui2=AeHOcI1j68xeUSXqWYub2IzqKaogwywN01gpqiDDLA3TWJrZGCVVFj050mt5NsbcFvo3VGj2tGDFtywb3DXh2pRi&_nc_ohc=ZFj28cHuG2IAX-Of4cP&_nc_ht=scontent.fcuu2-1.fna&oh=3fe7b2c391b1e5d5d76fc48eab5ced97&oe=5FEF62DF"));
        this.articulos.add(new Articulo("Sueter para perro", "$350.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/s960x960/129151847_3524861457590390_4163354618031323916_o.jpg?_nc_cat=108&ccb=2&_nc_sid=843cd7&_nc_eui2=AeHoFKcYG2vzGcaZuzQhq5za0hKHziW51CzSEofOJbnULMXJ-FJo8XA2u20q0fk0c-FzTHhKg_Y87adm_HqcIFCf&_nc_ohc=xgqfSRSEN3YAX94fUlr&_nc_ht=scontent.fcuu2-1.fna&tp=7&oh=8223ef32748aa9d343732e9ec76235a0&oe=5FF0FD06"));
        this.articulos.add(new Articulo("Pierna ahumada Bafar", "$320.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/p720x720/128261702_834873233722768_3300172695965574081_o.jpg?_nc_cat=100&ccb=2&_nc_sid=843cd7&_nc_eui2=AeFsVpLJpj5p30Zxd2XuytW43ZTFzOFsjardlMXM4WyNqqaH1Q-xmFKP28bzQqfrZLxnV4JPIV9bX1UkgKAT1ghP&_nc_ohc=NcXROY0DNnAAX_i5RMi&_nc_ht=scontent.fcuu2-1.fna&tp=6&oh=c22e6e65cf7dab1d818f173f06a264ba&oe=5FEF1761"));
        this.articulos.add(new Articulo("Cable Magnético De Carga Con Puntas Android/iPhone/Tipo C", "$80.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/120062444_10158039622107585_4271024462152999663_n.jpg?_nc_cat=102&ccb=2&_nc_sid=843cd7&_nc_eui2=AeFr8E_TO7x-7XoSd44kJa_KdtxV8o9UmDZ23FXyj1SYNmRCGCZeJj_coGZd7jbP4Mqor_OE0VfG05O1ZUXdO5jk&_nc_ohc=jo8coVbBPg8AX8MzC8U&_nc_ht=scontent.fcuu2-1.fna&oh=a7f819c6b84d2c292d74d3d444865ee0&oe=5FEF79C8"));
        this.articulos.add(new Articulo("Playera de las chivas", "$250.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/p720x720/125215634_4994902373883599_2878930510312957024_o.jpg?_nc_cat=111&ccb=2&_nc_sid=843cd7&_nc_eui2=AeFIHLhlfGOy9eBzCLC7BJDJkgAUGczRF7GSABQZzNEXsZK6Swrplo9egVVY-bN_MhbkK0oIZCV_4DBVK2PyrDxD&_nc_ohc=Gn1cN9NG1LwAX9YVNxo&_nc_ht=scontent.fcuu2-1.fna&tp=6&oh=b9481a0d1c518f38adf621b0957ade18&oe=5FF07CEB"));
        this.articulos.add(new Articulo("Kit ligas para hacer ejercicio", "$150.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/127041346_196816968686864_113922774562327740_n.jpg?_nc_cat=104&ccb=2&_nc_sid=843cd7&_nc_eui2=AeGVV2GXXZEA7tZQMPD9YAEC6LIVogruyAzoshWiCu7IDI3ky6Jb1ggMHsWLj23FPWpi-cbrb5zdzUA46OZqpgzc&_nc_ohc=xU7okzWPiK4AX_cUkmI&_nc_ht=scontent.fcuu2-1.fna&oh=8215cb30a2504b938945560cdea57004&oe=5FF01ECD"));
        this.articulos.add(new Articulo("Tenis de dama y caballero", "$350.00", "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/s960x960/127622634_243300913807305_7665615532354106454_o.jpg?_nc_cat=106&ccb=2&_nc_sid=843cd7&_nc_eui2=AeHrRN3dOKXP3mmsjO6J4bxRK5u1S2DX_k0rm7VLYNf-Tbi9K-YbFIYynpgZltEnzDDg9aUffIeDTn_XKVCWUGi_&_nc_ohc=Ij7feeP_D48AX9qXCDu&_nc_oc=AQlLUDK257XX5wuCmKTZw2dyuPWYYFwIC2E8LBcN5sOygvrMQOl-bnPfK3iEKsG_GkQ&_nc_ht=scontent.fcuu2-1.fna&tp=7&oh=e8106a4d493db91b502cb575e1b64393&oe=5FF25614"));

        this.products = new ArrayList<>();
        this.products.add(new Product(1, "Playera de las chivas", 250d, "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/p720x720/125215634_4994902373883599_2878930510312957024_o.jpg?_nc_cat=111&ccb=2&_nc_sid=843cd7&_nc_eui2=AeFIHLhlfGOy9eBzCLC7BJDJkgAUGczRF7GSABQZzNEXsZK6Swrplo9egVVY-bN_MhbkK0oIZCV_4DBVK2PyrDxD&_nc_ohc=Gn1cN9NG1LwAX9YVNxo&_nc_ht=scontent.fcuu2-1.fna&tp=6&oh=b9481a0d1c518f38adf621b0957ade18&oe=5FF07CEB"));
        this.products.add(new Product(3, "Kit ligas para hacer ejercicio", 150d, "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/127041346_196816968686864_113922774562327740_n.jpg?_nc_cat=104&ccb=2&_nc_sid=843cd7&_nc_eui2=AeGVV2GXXZEA7tZQMPD9YAEC6LIVogruyAzoshWiCu7IDI3ky6Jb1ggMHsWLj23FPWpi-cbrb5zdzUA46OZqpgzc&_nc_ohc=xU7okzWPiK4AX_cUkmI&_nc_ht=scontent.fcuu2-1.fna&oh=8215cb30a2504b938945560cdea57004&oe=5FF01ECD"));
        this.products.add(new Product(1, "Tenis de dama y caballero", 350d, "https://scontent.fcuu2-1.fna.fbcdn.net/v/t1.0-9/s960x960/127622634_243300913807305_7665615532354106454_o.jpg?_nc_cat=106&ccb=2&_nc_sid=843cd7&_nc_eui2=AeHrRN3dOKXP3mmsjO6J4bxRK5u1S2DX_k0rm7VLYNf-Tbi9K-YbFIYynpgZltEnzDDg9aUffIeDTn_XKVCWUGi_&_nc_ohc=Ij7feeP_D48AX9qXCDu&_nc_oc=AQlLUDK257XX5wuCmKTZw2dyuPWYYFwIC2E8LBcN5sOygvrMQOl-bnPfK3iEKsG_GkQ&_nc_ht=scontent.fcuu2-1.fna&tp=7&oh=e8106a4d493db91b502cb575e1b64393&oe=5FF25614"));
    }

    public static synchronized Common getInstance(Context context) {
        return (mInstance == null) ? mInstance = new Common(context) : mInstance;
    }

    public User getUser() {
        return user;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public List<Product> getProducts() {
        return products;
    }
}