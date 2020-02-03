package examen3ªev_pr;

public class Curso {
    
    private Integer idCurso;
    private String nombreCurso;
    private Integer duracionCurso;
    private Integer idProfesor;
    private String fechaInicio;
    private String fechaFin;
    private Profesor profesor;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombreCurso, Integer duracionCurso, Integer idProfesor, String fechaInicio, String fechaFin, Profesor profesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.duracionCurso = duracionCurso;
        this.idProfesor = idProfesor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.profesor = profesor;
    }

    public Curso(Integer idCurso, String nombreCurso, Integer duracionCurso, Integer idProfesor, String fechaInicio, String fechaFin) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.duracionCurso = duracionCurso;
        this.idProfesor = idProfesor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
 
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getDuracionCurso() {
        return duracionCurso;
    }

    public void setDuracionCurso(Integer duracionCurso) {
        this.duracionCurso = duracionCurso;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        
        return  "Código Curso: " + idCurso + "| Nombre del curso: " + nombreCurso + "| Duracion del curso: " + duracionCurso + "| Inicio del curso: " + fechaInicio + "| Fin del curso: " + fechaFin + "\nProfesor[" + profesor + "]";
    }
    
        
    
}
