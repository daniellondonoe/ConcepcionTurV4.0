package com.herprogramacion.restaurantericoparico.modelo;

import com.herprogramacion.restaurantericoparico.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Contenido {
    private String nombre;
    private int idDrawable;

    public Contenido(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final List<Contenido> PRINCIPAL = new ArrayList<Contenido>();
    public static final List<Contenido> HOTELES = new ArrayList<>();
    public static final List<Contenido> RESTAURANTES = new ArrayList<>();
    public static final List<Contenido> LUGARES = new ArrayList<>();

    static {
        PRINCIPAL.add(new Contenido("", R.drawable.info));

        HOTELES.add(new Contenido("Finca hotel Villa Linda", R.drawable.hotel1));
        HOTELES.add(new Contenido("Hotel La Vega", R.drawable.hotel2));
        HOTELES.add(new Contenido("Hotel Municipal Doña Pascuala Muñoz", R.drawable.hotel3));

        RESTAURANTES.add(new Contenido("Restaurante Disko Bar Kanabw", R.drawable.restaurante1));
        RESTAURANTES.add(new Contenido("Restaurante Villa Linda", R.drawable.restaurante2));
        RESTAURANTES.add(new Contenido("Restaurante Sazón Las Conchitas", R.drawable.restaurante3));

        LUGARES.add(new Contenido("Parque Principal José María Cordova", R.drawable.lugar1));
        LUGARES.add(new Contenido("Casa de la cultura", R.drawable.lugar2));
        LUGARES.add(new Contenido("Sensero Alto de la virgen", R.drawable.lugar3));
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
