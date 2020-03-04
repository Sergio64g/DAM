package com.example.proyectopmdm.Utils;

public class Favorito {
    private String idFavorito;
    private Equipo equipo;
    private Usuario usuario;


    public Favorito() {
    }

    public Favorito(String idFavorito, Equipo equipo, Usuario usuario) {
        this.idFavorito = idFavorito;
        this.equipo = equipo;
        this.usuario = usuario;
    }

    public Favorito(Equipo equipo, Usuario usuario) {
        this.equipo = equipo;
        this.usuario = usuario;
    }

    public String getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(String idFavorito) {
        this.idFavorito = idFavorito;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
