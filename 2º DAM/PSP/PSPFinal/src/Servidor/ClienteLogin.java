package Servidor;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.net.ssl.*;

public class ClienteLogin {

    public static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    public static void main(String[] args) throws Exception {
        String Host = "localhost";
        int puerto = 6000;//puerto remoto
        String nombre = "admin";
        String password = "admin";


        // Propiedades JSSE)
        System.setProperty("javax.net.ssl.trustStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.trustStorePassword", "1234567");

        System.out.println("PROGRAMA CLIENTE INICIADO....");

        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket cliente = (SSLSocket) sfact.createSocket(Host, puerto);
        DataOutputStream flujoSalida = null;//PARA MANDAR EL CIFRADO
        DataInputStream flujoEntrada = null;//PARA RECIBIR LA CONFIRMACION

        flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeUTF(nombre);

        flujoSalida = new DataOutputStream(cliente.getOutputStream());
        flujoSalida.writeUTF(get_SHA_512_SecurePassword(password, ""));




        flujoEntrada = new DataInputStream(cliente.getInputStream());
        String confirmacion = flujoEntrada.readUTF();
        System.out.println(confirmacion);



        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}