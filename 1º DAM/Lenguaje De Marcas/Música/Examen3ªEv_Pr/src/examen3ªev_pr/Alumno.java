package examen3ªev_pr;

public class Alumno {
    
    private Integer idAlumno;
    private String nombre;
    private String apellidos;
    private String email;
    private String FechaNacimiento;

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String nombre, String apellidos, String email, String FechaNacimineto) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.FechaNacimiento = FechaNacimineto;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
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

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    
    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", FechaNacimineto=" + FechaNacimiento + '}';
    }
    
    
    
    
}
