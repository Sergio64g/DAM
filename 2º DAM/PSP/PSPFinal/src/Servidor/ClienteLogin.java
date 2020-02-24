package Servidor;

import java.io.*;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.net.ssl.*;

public class ClienteLogin  {
    public static void main(String[] args) throws Exception {
        String Host = "localhost";
        int puerto = 6000;//puerto remoto
        String password = "12345";

        // Propiedades JSSE)
        System.setProperty("javax.net.ssl.trustStore","src/AlmacenSrv");
        System.setProperty("javax.net.ssl.trustStorePassword","1234567");

        System.out.println("PROGRAMA CLIENTE INICIADO....");

        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket cliente  = (SSLSocket) sfact.createSocket(Host, puerto);
        ObjectInputStream objetoEntrada = null;//PARA RECIBIR LA CLAVE PUBLICA
        DataOutputStream flujoSalida = null;//PARA MANDAR EL CIFRADO
        DataInputStream flujoEntrada = null;//PARA RECIBIR LA CONFIRMACION

        Cipher rsaCipher = Cipher.getInstance("RSA");

        objetoEntrada = new ObjectInputStream(cliente.getInputStream());
        PublicKey publicKey = (PublicKey) objetoEntrada.readObject();
        //TODO Recibir la clave publica

        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] mensajeCifrado = rsaCipher.doFinal(password.getBytes("UTF8"));
        System.out.println(mensajeCifrado);
        //TODO Usar la clave publica para cifrar la password
        flujoSalida = new DataOutputStream(cliente.getOutputStream());
        String cifrado = new String(mensajeCifrado);
        flujoSalida.writeUTF(cifrado);
        //TODO Mandar la clave

        flujoEntrada = new DataInputStream(cliente.getInputStream());
        String confirmacion = flujoEntrada.readUTF();
        System.out.println(confirmacion);
        //TODO Recibir la confirmacion para hacer login correcto



        // CERRAR STREAMS Y SOCKETS
        objetoEntrada.close();
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }// main
}//..ClienteSSLv