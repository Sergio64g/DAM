package Utils;

import javafx.beans.property.StringProperty;

public class Jugador {
    private int idJugador;
    private String dniJugador, nombreJugador, posicion;
    private Entrenador entrenador;


    public Jugador() {
    }

    public Jugador(String dniJugador, String nombreJugador, String posicion, Entrenador entrenador) {
        this.dniJugador = dniJugador;
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.entrenador = entrenador;
    }

    public Jugador(int idJugador, String dniJugador, String nombreJugador, String posicion, Entrenador entrenador) {
        this.idJugador = idJugador;
        this.dniJugador = dniJugador;
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.entrenador = entrenador;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(String dniJugador) {
        this.dniJugador = dniJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return nombreJugador + " - " + posicion;
    }
}
