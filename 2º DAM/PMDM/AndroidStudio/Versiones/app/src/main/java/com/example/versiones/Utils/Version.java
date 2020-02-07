package com.example.versiones.Utils;

import java.io.Serializable;

public class Version implements Serializable {
    private int imagen;
    private String nombreVersion, descripcion, fechaSalida, numeroVersion;

    public Version() {
    }

    public Version(int imagen, String nombreVersion, String descripcion, String fechaSalida, String numeroVersion) {
        this.imagen = imagen;
        this.nombreVersion = nombreVersion;
        this.descripcion = descripcion;
        this.fechaSalida = fechaSalida;
        this.numeroVersion = numeroVersion;
    }

    public int getImagen() {
        return imagen;
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

    public Version(int imagen, String nombreVersion) {
        this.imagen = imagen;
        this.nombreVersion = nombreVersion;
    }
}
