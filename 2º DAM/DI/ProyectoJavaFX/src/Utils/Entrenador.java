package Utils;

public class Entrenador {
    private int idEntrenador;
    private String nombreEntrenador, dniEntrenador;
    private Equipo equipo;
    private String passwordEntrenador;

    public Entrenador() {
    }

    public Entrenador(String nombreEntrenador, String passwordEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
        this.passwordEntrenador = passwordEntrenador;
    }

    public Entrenador(String nombreEntrenador, String dniEntrenador, String passwordEntrenador, Equipo equipo) {
        this.nombreEntrenador = nombreEntrenador;
        this.dniEntrenador = dniEntrenador;
        this.equipo = equipo;
        this.passwordEntrenador = passwordEntrenador;
    }

    public Entrenador(int idEntrenador, String nombreEntrenador, String dniEntrenador, Equipo equipo, String passwordEntrenador) {
        this.idEntrenador = idEntrenador;
        this.nombreEntrenador = nombreEntrenador;
        this.dniEntrenador = dniEntrenador;
        this.equipo = equipo;
        this.passwordEntrenador = passwordEntrenador;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getDniEntrenador() {
        return dniEntrenador;
    }

    public void setDniEntrenador(String dniEntrenador) {
        this.dniEntrenador = dniEntrenador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getPasswordEntrenador() {
        return passwordEntrenador;
    }

    public void setPasswordEntrenador(String passwordEntrenador) {
        this.passwordEntrenador = passwordEntrenador;
    }

   /* @Override
    public String toString() {
        return nombreEntrenador + " - " + equipo;
        }*/

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador=" + idEntrenador +
                ", nombreEntrenador='" + nombreEntrenador + '\'' +
                ", dniEntrenador='" + dniEntrenador + '\'' +
                ", equipo=" + equipo +
                ", passwordEntrenador='" + passwordEntrenador + '\'' +
                '}';
    }
}

