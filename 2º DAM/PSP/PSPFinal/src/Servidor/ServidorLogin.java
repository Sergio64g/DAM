package Servidor;

import Utils.Usuario;
import Utils.Usuarios;

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
        Usuarios usuarios = new Usuarios();

        while (true) {
            //Acepta la conexión con el cliente
            clienteConectado = (SSLSocket) servidorSSL.accept();

            flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
            String nombre = flujoEntrada.readUTF();
            System.out.println("Nombre: " + nombre);

            flujoEntrada = new DataInputStream(clienteConectado.getInputStream());
            String password = flujoEntrada.readUTF();
            System.out.println("Mensaje Encriptado: " + password);

            //TODO COmparar con base de datos
            Usuario usuario = usuarios.loginCorrecto(new Usuario(nombre, password));

            flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());
            if (usuario != null) {
                flujoSalida.writeBoolean(true);
            } else {
                flujoSalida.writeBoolean(false);
            }

        }
        // CERRAR STREAMS Y SOCKETS
        /*flujoEntrada.close();
        flujoSalida.close();
        clienteConectado.close();
        servidorSSL.close();*/

    }

}

