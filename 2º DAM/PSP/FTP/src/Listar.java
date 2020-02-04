
import java.io.*;
import org.apache.commons.net.ftp.*;

public class Listar {

    public static void main(String[] args) {
        FTPClient cliente = new FTPClient();
        //String servFTP = "192.168.35.55";
        //String usuario = "parralides";
        //String clave = "barco";
        String servFTP = "localhost";
        String usuario = "admin";
        String clave = "admin";
        String direc = "carpeta";

        System.out.println("Nos conectamos a:  " + servFTP);
        try {
            cliente.connect(servFTP);
            boolean login = cliente.login(usuario, clave);
            if (login)
                System.out.println("Login correcto ... ");
            else {
                System.out.println("Login Incorrecto ... ");
                cliente.disconnect();
                System.exit(1);
            }
            cliente.changeWorkingDirectory(direc);
            System.out.println("Directorio actual:  " + cliente.printWorkingDirectory());
            FTPFile[] files = cliente.listFiles();
            System.out.println("Ficheros en el directorio actual:" + files.length);
            // array para visualizar el tipo de fichero
            String tipos[] = { "Fichero", "Directorio", "Enlace  simb." };
            for (int i = 0; i < files.length; i++) {
                System.out.println("\t" + files[i].getName() + "=>" + tipos[files[i].getType()]);
            }
            boolean logout = cliente.logout();
            if (logout)
                System.out.println("Logout del servidor FTP . . . ");
            else
                System.out.println("Error al hacer  Logout ... ");
            cliente.disconnect();
            System.out.println("Desconectado . . . ");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}