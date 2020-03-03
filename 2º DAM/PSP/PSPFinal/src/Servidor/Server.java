package Servidor;

import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.*;

public class Server {
    public static void main(String[] arg) throws IOException {
        int puerto = 5556;

        System.setProperty("javax.net.ssl.keyStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.keyStorePassword", "1234567");

        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        SSLServerSocket servidorSSL = (SSLServerSocket) sfact
                .createServerSocket(puerto);
        SSLSocket clienteConectado = null;
        DataInputStream flujoEntrada = null;//FLUJO DE ENTRADA DE CLIENTE
        DataOutputStream flujoSalida = null;//FLUJO DE SALIDA AL CLIENTE


        while (true) {

            //Acepta la conexión con el cliente
            clienteConectado = (SSLSocket) servidorSSL.accept();
            flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
            // El cliente envia el codigo
            String codigo = flujoEntrada.readUTF();

            Ejecutar ejecutar = new Ejecutar(codigo);

            System.out.println("Arriba");

            Process process = new ProcessBuilder("powershell", "C:\\Users\\sergi\\Desktop\\Ejecutar.ps1").start();
           /* try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            System.out.println("Compilado");
            flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());


            String compilado = ejecutar.leerFichero(new File("src/res.txt"));
            // Enviar el codigo compilado
            flujoSalida.writeUTF(compilado);
            System.out.println("Compilado enviado");

        }
        // CERRAR STREAMS Y SOCKETS
        /*flujoEntrada.close();
        flujoSalida.close();
        clienteConectado.close();
        servidorSSL.close();*/


    }
}


