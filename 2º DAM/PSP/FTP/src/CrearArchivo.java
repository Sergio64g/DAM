import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

public class CrearArchivo {

    public static void main(String[] args) {
        FTPClient cliente = new FTPClient(); //cliente
        String servidor = "localhost"; //servidor
        String user = "admin";
        String pasw = "admin";

        try {
            System.out.println("Conectandose a " + servidor);
            cliente.connect(servidor);
            boolean login = cliente.login(user, pasw);
            String direc = "carpeta";

            if (login) {
                cliente.changeWorkingDirectory(direc);
                cliente.setFileType(FTP.ASCII_FILE_TYPE);

                //Stream de entrada con el fichero a subir
                BufferedInputStream in = new BufferedInputStream(new FileInputStream("src\\prueba.txt"));
                String cadena = "";
                

                cliente.storeFile("prueba2.txt", in);

                //Stream de entrada con el fichero a subir
                //in = new BufferedInputStream(new FileInputStream("c:\\petra\\gunto.jpg"));
                //cliente.storeFile("gunto.jpg", in);
                in.close(); //cerrar flujo
                cliente.logout(); //logout del usuario
                cliente.disconnect(); // desconexion del servidor
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
