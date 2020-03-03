package Controladoras;

import Ventanas.MainStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
import java.util.concurrent.TimeUnit;

public class ArchivoController implements Initializable {

    @FXML
    Button codeButton, chooserButton, returnButton;
    @FXML
    TextArea textArea;
    @FXML
    Label pathLabel;

    File selectedFile;
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
                selectedFile = fileChooser.showOpenDialog(stage);

                if (selectedFile != null) {
                    code = leerFichero(selectedFile);
                    pathLabel.setText(selectedFile.getPath());
                }
            }
        });
        codeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (selectedFile != null) {
                    String res = clienteSSL(code);
                    if(res != null) {
                        MainStage mainStage = new MainStage(res);
                        codeButton.getScene().getWindow().hide();
                    } else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("El servidor esta cerrado o el codigo es invalido");
                        alert.show();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Elija un archivo");
                    alert.show();
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
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // EL servidor ME ENVIA UN MENSAJE
            compilado= flujoEntrada.readUTF();

            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            Cliente.close();
        } catch (IOException e) {
            System.err.println("Sevidor cerrado");
        }
        return compilado;
    }

}





