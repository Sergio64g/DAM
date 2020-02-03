package Utils;

public class Persona {
    String id, nombre, apellidos, calle;
    Integer edad, numero, codigoPostal;

    public Persona() {
    }

    public Persona(String id, String nombre, String apellidos, Integer edad, String calle, Integer numero, Integer codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calle = calle;
        this.edad = edad;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return  id + " - " + nombre;

    }
}
