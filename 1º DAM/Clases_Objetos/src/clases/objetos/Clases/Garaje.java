package clases.objetos.Clases;

import java.util.Enumeration;
import java.util.Hashtable;

public class Garaje {

    private Hashtable<String, Coche> listadoCoches;

    public Garaje() {
        listadoCoches = new Hashtable();
    }

    public void agregarCoche(Coche coche) {
        listadoCoches.put(coche.getMatricula(), coche);
    }

    public boolean comprobarGaraje(String matricula) {
        return listadoCoches.containsKey(matricula);

    }

    public void eliminarCoche(String matricula) {
        listadoCoches.remove(matricula);

    }

    public void listarCoches() {
        Enumeration<Coche> e = listadoCoches.elements();
        while (e.hasMoreElements()) {
            Coche c = e.nextElement();
            System.out.println(c);

        }

    }

    public boolean estadoCoche(String matricula) {
        Coche c = listadoCoches.get(matricula);
        return c.isEstado();
    }
    public void cambiarEstado(String matricula){
       Coche c = listadoCoches.get(matricula);
        if(c.isEstado()){
        c.setEstado(false);
        } else {
        c.setEstado(true);
        }
    }
    
    public void acelerar (String matricula, int ac){
    Coche c = listadoCoches.get(matricula);
    c.acelerarCoche(ac);
    }
    
    public void frenar (String matricula, int dc){
    Coche c = listadoCoches.get(matricula);
    c.decelerar(dc);
    
    }
    

}
