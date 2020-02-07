package com.example.ejercicio_versiones.utils;

import java.io.Serializable;

public class Version implements Serializable {
    private int idImagen;
    private String nombreVersion, descripcion, fechaSalida, numeroVersion;

    public Version() {
    }

    public Version(int idImagen, String nombreVersion, String descripcion, String fechaSalida, String numeroVersion) {
        this.idImagen = idImagen;
        this.nombreVersion = nombreVersion;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.numeroVersion = numeroVersion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getNombreVersion() {
        return nombreVersion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getNumeroVersion() {
        return numeroVersion;
    }

    public Version(int idImagen, String nombreVersion) {
        this.idImagen = idImagen;
        this.nombreVersion = nombreVersion;
    }
}
