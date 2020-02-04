
import java.io.*;
import org.apache.commons.net.ftp.*;

/**
 *
 * @author Daniel Marcos Lorrio
 */
public class DescargarArchivo {

    public static void main(String[] args) {

        FTPClient cliente = new FTPClient(); //cliente
        //String servidor = "192.168.35.55"; //servidor
        //String user = "parralides";
        //String pasw = "barco";
        String servidor = "localhost"; //servidor
        String user = "admin";
        String pasw = "admin";

        try {
            System.out.println("Conectandose a " + servidor);
            cliente.connect(servidor);
            boolean login = cliente.login(user, pasw);
            //String direc = "Carpeta";

            if (login) {
                //cliente.changeWorkingDirectory(direc);
                cliente.setFileType(FTP.ASCII_FILE_TYPE);

                //Stream de entrada con el fichero a descargar
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("HOla.txt"));

                if (cliente.retrieveFile("HOla.txt", out)) {
                    System.out.println("Recuperado correctamente...");
                } else {
                    System.out.println("No se ha podido descargar...");
                }

                out.close(); //cerrar flujo
                cliente.logout(); //logout del usuario
                cliente.disconnect(); // desconexion del servidor
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
