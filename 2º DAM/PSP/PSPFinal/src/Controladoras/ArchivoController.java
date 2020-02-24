package Controladoras;

import Ventanas.MainStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ArchivoController implements Initializable {

    @FXML
    Button codeButton, chooserButton, returnButton;
    @FXML
    TextArea textArea;
    @FXML
    Label pathLabel;

    String code;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        code = null;
        acciones();

    }

    private void acciones() {
        chooserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) chooserButton.getScene().getWindow();
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Eliga un archivo");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
                File selectedFile = fileChooser.showOpenDialog(stage);

                if (selectedFile != null) {
                    code = leerFichero(selectedFile);
                    pathLabel.setText(selectedFile.getPath());
                }
            }
        });
        codeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (code != null) {
                    String res = clienteSSL(code);
                    textArea.setText(res);
                }
            }
        });
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainStage mainStage = new MainStage();
                returnButton.getScene().getWindow().hide();
            }
        });
    }


    public String leerFichero(File file) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        textArea.setText(sb.toString());

        return sb.toString();
    }


    public String clienteSSL(String codigo) {
        String Host = "localhost";
        int puerto = 5556;//puerto remoto
        String compilado = null;
        // Propiedades JSSE
        System.setProperty("javax.net.ssl.trustStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.trustStorePassword", "1234567");

        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket Cliente = null;
        try {
            Cliente = (SSLSocket) sfact.createSocket(Host, puerto);

            // CREO FLUJO DE SALIDA AL SERVIDOR
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());

            // ENVIO UN SALUDO AL SERVIDOR
            flujoSalida.writeUTF(codigo);

            // CREO FLUJO DE ENTRADA AL SERVIDOR
            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());

            // EL servidor ME ENVIA UN MENSAJE
            compilado= flujoEntrada.readUTF();

            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            Cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compilado;
    }

}





