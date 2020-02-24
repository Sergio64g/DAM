package com.example.proyectopmdm.Utils;

public class Equipo {
    private String nombre, imagenEquipo, detalles;
    private boolean favorito;


    public Equipo() {
    }

    public Equipo(String nombre, String imagenEquipo, String detalles) {
        this.nombre = nombre;
        this.imagenEquipo = imagenEquipo;
        this.detalles = detalles;
        favorito = false;
    }

    public Equipo(String nombre, String imagenEquipo, String detalles, boolean favorito) {
        this.nombre = nombre;
        this.imagenEquipo = imagenEquipo;
        this.detalles = detalles;
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(String imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
