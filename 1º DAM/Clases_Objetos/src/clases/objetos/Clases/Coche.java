package clases.objetos.Clases;

public class Coche {

    private String matricula, marca, modelo;
    int cv, bastidor, velocidad;
    boolean estado = true;

    public Coche(String matricula, String marca, String modelo, int cv, int bastidor) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
        this.velocidad = 0;
    }

    public Coche(String matricula, String marca, String modelo, int cv, int bastidor, int velocidad) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.bastidor = bastidor;
        this.velocidad = velocidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCv() {
        return cv;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void meterDentroGaraje(Garaje garaje) {
        if (!garaje.comprobarGaraje(matricula)) {
            estado = true;
        }
    }

    public void sacarFueraGaraje(Garaje garaje) {
        if (garaje.estadoCoche(matricula)) {
            estado = false;
        }
    }


    public void acelerarCoche(int vel) {
        this.velocidad += vel;
    }

    public void decelerar(int vel) {
        if (this.velocidad > vel) {
            this.velocidad -= vel;
        } else {
            this.velocidad = 0;
        }

    }

    public Coche() {
    }

    @Override
    public String toString() {
        String estadox;
        if (estado){
        estadox = "aparcado";
        }else {
        estadox = "circulando";
        }
        return "Coche " + matricula + "\nmatricula:" + matricula + ", " + marca + " " + modelo + ", " + cv + " CV, Nºbastidor:" + bastidor + ", " + velocidad + " KM/h, " + estadox;
    }

}
