package examen3ªev_pr;

public class Profesor {
    
    private Integer idProfesor;
    private String nombre;
    private String apellidos;
    private String email;

    public Profesor() {
    }

    public Profesor(Integer idProfesor, String nombre, String apellidos, String email) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id del profesor: " + idProfesor + "| Nombre: " + nombre + "| Apellido: " + apellidos + "| email: " + email ;
    }
    
    
    
}
