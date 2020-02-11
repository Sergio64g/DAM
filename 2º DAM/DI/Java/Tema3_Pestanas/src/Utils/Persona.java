package Utils;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {
    String nombre, estado, apellido, edad;
    Boolean disponibilidad;

    SimpleStringProperty propNombre, propApellido, propEdad;
    SimpleBooleanProperty propDisponibilidad;

    public Persona(String nombre, String apellido, String edad, Boolean disponibilidad) {
        this.nombre = nombre;
        propNombre = new SimpleStringProperty(nombre);
        this.apellido = apellido;
        propApellido = new SimpleStringProperty(apellido);
        this.edad = edad;
        propEdad = new SimpleStringProperty(edad);
        this.disponibilidad = disponibilidad;
        propDisponibilidad = new SimpleBooleanProperty(disponibilidad);
    }

    public Persona() {
    }

    public Persona(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getPropNombre() {
        return propNombre.get();
    }

    public SimpleStringProperty propNombreProperty() {
        return propNombre;
    }

    public String getPropApellido() {
        return propApellido.get();
    }

    public SimpleStringProperty propApellidoProperty() {
        return propApellido;
    }

    public String getpropEdad() {
        return propEdad.get();
    }

    public SimpleStringProperty propEdadProperty() {
        return propEdad;
    }

    public boolean isPropDisponibilidad() {
        return propDisponibilidad.get();
    }

    public SimpleBooleanProperty propDisponibilidadProperty() {
        return propDisponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
