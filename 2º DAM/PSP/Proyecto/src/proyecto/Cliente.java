/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Sergio
 */
public class Cliente extends Thread {

    @Override
    public void run() {
        InetAddress Host = InetAddress.getLoopbackAddress();
        int Puerto = 6000; // Puerto remoto

        System.out.println("Programa cliente iniciado...");

        try {

            Socket cliente = new Socket(Host, Puerto);

            File res = new File("src\\Documentos\\res.txt");
            FileReader f = null;
            String cadena, resultado = "";
            try {
                //Recoge el contenido del txt y lo guarda en la variable codigo

                f = new FileReader(res);
                BufferedReader b = new BufferedReader(f);
                while ((cadena = b.readLine()) != null) {
                    resultado = resultado + cadena;
                }

                b.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    f.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());

            Envio dato = new Envio();

            dato.setTexto(resultado);
            dato.setIp(Inet4Address.getLocalHost().getHostAddress());

            ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());

            // Envio del objeto
            perSal.writeObject(dato);
            System.out.println("Envio: " + dato.getTexto() + "*" + dato.getIp());

            // Cerrar streams y sockets
            perEnt.close();
            perSal.close();

            cliente.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
