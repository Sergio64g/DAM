package Servidor;

import Claves.Claves;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ServidorLogin {
    public static void main(String[] arg) throws IOException {
        int puerto = 6000;

        System.setProperty("javax.net.ssl.keyStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.keyStorePassword", "1234567");

        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        SSLServerSocket servidorSSL = (SSLServerSocket) sfact
                .createServerSocket(puerto);
        SSLSocket clienteConectado = null;
        DataInputStream flujoEntrada = null;//FLUJO DE ENTRADA DE CLIENTE PARA RECOGER LA CLAVE ENCRIPTADA
        ObjectOutputStream objetoSalida = null;//FLUJO DE SALIDA AL CLIENTE PARA MANDAR LA CLAVE PUBLICA
        DataOutputStream flujoSalida = null;//FLUJO DE SALIDA AL CLIENTE PARA MANDAR LA CONFIRMACION

        Claves claves = new Claves();
        claves.generarClaves();
        Cipher rsaCipher = null;
        try {
            rsaCipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }


        while (true) {
            //Acepta la conexión con el cliente
            clienteConectado = (SSLSocket) servidorSSL.accept();


            objetoSalida = new ObjectOutputStream(clienteConectado.getOutputStream());
            objetoSalida.writeObject(claves.getClavepub());
            //TODO Enviar clave publica
            flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
            String mensajeEncriptado = flujoEntrada.readUTF();
            //TODO Recoger mensaje encriptado

            try {
                rsaCipher.init(Cipher.DECRYPT_MODE, claves.getClavepub());
                byte[] mensajeDescifrado = rsaCipher.doFinal(mensajeEncriptado.getBytes(StandardCharsets.UTF_8));
                String mensajeDescifrado2 = new String(mensajeDescifrado, "UTF8");
                System.out.println("Hola Mundo");
                System.out.println(mensajeDescifrado2);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
            //TODO Desencriptar con clave privada

            //TODO Comparar con la base de datos
            flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());
            if (true) {
                flujoSalida.writeUTF("CHECK");
            } else {
                flujoSalida.writeUTF("ERROR");
            }
            System.out.println();
            //TODO Mandar mensaje de confirmacion

        }
        // CERRAR STREAMS Y SOCKETS
        /*flujoEntrada.close();
        flujoSalida.close();
        clienteConectado.close();
        servidorSSL.close();*/

    }

    public static void generarClaves() {


    }
}

