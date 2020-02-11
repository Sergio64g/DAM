package examentr1_di;

public class Persona {

    private String nombre, apellido;
    private Integer matricula, ntDI, ntPMDM, ntPSP, ntAD;

    public Persona(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public void DarNotas(Integer ntDI, Integer ntPMDM, Integer ntPSP, Integer ntAD) {
        this.ntDI = ntDI;
        this.ntPMDM = ntPMDM;
        this.ntPSP = ntPSP;
        this.ntAD = ntAD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getNtDI() {
        return ntDI;
    }

    public void setNtDI(Integer ntDI) {
        this.ntDI = ntDI;
    }

    public Integer getNtPMDM() {
        return ntPMDM;
    }

    public void setNtPMDM(Integer ntPMDM) {
        this.ntPMDM = ntPMDM;
    }

    public Integer getNtPSP() {
        return ntPSP;
    }

    public void setNtPSP(Integer ntPSP) {
        this.ntPSP = ntPSP;
    }

    public Integer getNtAD() {
        return ntAD;
    }

    public void setNtAD(Integer ntAD) {
        this.ntAD = ntAD;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + matricula;
    }

}
