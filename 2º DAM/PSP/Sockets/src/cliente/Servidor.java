package cliente;

import java.io.*;
import java.net.*;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class Servidor {

    public static void main(String args[]) {
        int numeroPuerto = 6000; // Puerto
        InetAddress ip = InetAddress.getLoopbackAddress();
        try {
            ServerSocket servidor = new ServerSocket();
            // Realizando bind
            InetSocketAddress addr = new InetSocketAddress(ip, numeroPuerto);
            servidor.bind(addr);

            System.out.println("Esperando al cliente...");
            Socket cliente = servidor.accept();

            // Preparar el flujo de salida para objetos
            ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());

            
            
            // Obtener un stream para leer datos
            ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
            Envio dato = (Envio) inObjeto.readObject();
            System.out.println("Recibo: " + dato.getTexto()+ "*" + dato.getIp());
            
            // Cerrar streams y sockets
            outObjeto.close();
            inObjeto.close();
            
            cliente.close();
            servidor.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    } // end main
} // end class