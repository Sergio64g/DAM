package Controladoras;

import Utils.GitHub;
import Ventanas.MainStage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class GitHubController implements Initializable {

    @FXML
    TextField githubField;
    @FXML
    TextArea textArea;
    @FXML
    Button returnButton, codeButton;

    GitHub gitHub;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainStage mainStage = new MainStage();
                returnButton.getScene().getWindow().hide();
            }
        });
        githubField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                gitHub = new GitHub(newValue);
                textArea.setText(gitHub.getCode());
            }
        });
        codeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (gitHub.getCode() != null) {
                    String res = clienteSSL(gitHub.getCode());
                    if (res != null) {
                        MainStage mainStage = new MainStage(res);
                        codeButton.getScene().getWindow().hide();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("El servidor esta cerrado o el codigo es invalido");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Elija una URL valida(raw)");
                    alert.show();
                }
            }
        });
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
            compilado = flujoEntrada.readUTF();

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
