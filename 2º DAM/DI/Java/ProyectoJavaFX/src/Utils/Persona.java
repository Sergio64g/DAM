package Utils;

import java.util.ArrayList;

public class Persona {
    String dni, nombre, password, permisos;
    ArrayList jugadores;

    public Persona() {
    }

    public Persona(String dni, String nombre, String password, String permisos) {
        this.dni = dni;
        this.nombre = nombre;
        this.password = password;
        this.permisos = permisos;
    }

    public Persona(String user, String pass) {
        this.nombre = user;
        this.password  = pass;
        this.dni = "878974654";
                this.permisos = "Usuario";
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "Dni: " + dni + "\nNombre: " + nombre + "\nPermisos: " + permisos;
    }
}
