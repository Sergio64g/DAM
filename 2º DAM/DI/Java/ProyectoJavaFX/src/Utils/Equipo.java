package Utils;

public class Equipo {
    private int idEquipo;
    private String nombreEquipo, ciudadEquipo, imagenEquipo;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombreEquipo, String ciudadEquipo, String imagenEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
        this.imagenEquipo = imagenEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public void setCiudadEquipo(String ciudadEquipo) {
        this.ciudadEquipo = ciudadEquipo;
    }

    public String getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(String imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }

    /*@Override
    public String toString() {
        return nombreEquipo;
    }*/

    @Override
    public String toString() {
        return nombreEquipo;
    }
}
