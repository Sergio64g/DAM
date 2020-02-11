package cv;

public class Persona {

    private String nombre, direccion, telefono, dni, estudios;
    private int estado, experiencia;

    public Persona() {
    }

    public Persona(String nombre, String direccion, String telefono, String dni, String estudios, int estado, int experiencia) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.estudios = estudios;
        this.estado = estado;
        this.experiencia = experiencia;
    }
    public Persona(String telefono, String dni, String estudios, int experiencia) {
        this.telefono = telefono;
        this.dni = dni;
        this.estudios = estudios;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getEstado() {
        String state = "";
        switch (this.estado) {
            case 0:
                state = "Soltero";
                break;
            case 1:
                state = "Casado";
                break;
            case 2:
                state = "Divorciado";
                break;
        }
        return state;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDirección: " + direccion + "\nDNI: " + dni + "\nTLF: " + telefono + "\nEstudios: " + estudios + "\nEstado Civil: " + getEstado() + "\n" + experiencia + " Años de Experiencia";
    }

}
