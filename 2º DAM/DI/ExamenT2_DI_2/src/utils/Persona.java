package utils;

public class Persona {

    private String nombre, dni;
    private int ntDI, ntPMDM, ntPSP, ntAD;

    public Persona() {
    }

    public Persona(String nombre, String dni, int ntDI, int ntPMDM, int ntPSp, int ntAD) {
        this.nombre = nombre;
        this.dni = dni;
        this.ntDI = ntDI;
        this.ntPMDM = ntPMDM;
        this.ntPSP = ntPSp;
        this.ntAD = ntAD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNtDI() {
        return ntDI;
    }

    public void setNtDI(int ntDI) {
        this.ntDI = ntDI;
    }

    public int getNtPMDM() {
        return ntPMDM;
    }

    public void setNtPMDM(int ntPMDM) {
        this.ntPMDM = ntPMDM;
    }

    public int getNtPSP() {
        return ntPSP;
    }

    public void setNtPSP(int ntPSp) {
        this.ntPSP = ntPSp;
    }

    public int getNtAD() {
        return ntAD;
    }

    public void setNtAD(int ntAD) {
        this.ntAD = ntAD;
    }

    public int calcularNota() {
        int c, d, pm, ps, a;
        d = this.getNtDI();
        pm = this.getNtPMDM();
        ps = this.getNtPSP();
        a = this.getNtAD();
        c = (d + pm + ps + a) / 4;
        return c;
    }

    @Override
    public String toString() {
        return nombre + " - " + dni;
    }

}
