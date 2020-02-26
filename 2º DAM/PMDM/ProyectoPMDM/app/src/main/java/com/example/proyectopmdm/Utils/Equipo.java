package com.example.proyectopmdm.Utils;

public class Equipo {
    private String nombreEquipo, imagenEquipo, detalles;
    private boolean favorito;


    public Equipo() {
    }

    public Equipo(String nombreEquipo, String imagenEquipo, String detalles) {
        this.nombreEquipo = nombreEquipo;
        this.imagenEquipo = imagenEquipo;
        this.detalles = detalles;
        favorito = false;
    }

    public Equipo(String nombreEquipo, String imagenEquipo, String detalles, boolean favorito) {
        this.nombreEquipo = nombreEquipo;
        this.imagenEquipo = imagenEquipo;
        this.detalles = detalles;
        this.favorito = favorito;
    }

    public String getNombre() {
        return nombreEquipo;
    }

    public void setNombre(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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
