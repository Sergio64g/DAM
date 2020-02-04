package com.example.examen_tr1_pmdm.Utils;

import java.io.Serializable;

public class Coche implements Serializable {
    private String marca, modelo;
    private int cv;

    public Coche() {
    }

    public Coche(String marca, String modelo, int cv) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    @Override
    public String toString() {
        return modelo;
    }
}
