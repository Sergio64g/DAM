package cliente;

import java.io.*;
import java.net.*;

/**
 *
 * @author Sergio
 */
public class Cliente {

    public static void main(String args[]) {
        InetAddress Host = InetAddress.getLoopbackAddress();
        int Puerto = 6000; // Puerto remoto

        System.out.println("Programa cliente iniciado...");

        try {
            Socket cliente = new Socket(Host, Puerto);

            // Flujo de entrada para objetos
            ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

            // Se recibe un objeto
            Envio dato = new Envio(); // Recibir objeto
        

            dato.setTexto("Juanito Maravilla");
            dato.setIp(Inet4Address.getLocalHost().getHostAddress());

            // Flujo de salida para objetos
            ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

            // Envio del objeto
            perSal.writeObject(dato);
            System.out.println("Envio: " + dato.getTexto()+ "*" + dato.getIp());

            // Cerrar streams y sockets
            perEnt.close();
            perSal.close();

            cliente.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
