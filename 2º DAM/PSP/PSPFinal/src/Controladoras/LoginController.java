package Controladoras;

import Utils.Usuario;
import Ventanas.MainStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    TextField userField, passwordField;
    @FXML
    Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();

    }

    private void acciones() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nombre = userField.getText();
                String password = passwordField.getText();
                Usuario u = new Usuario(nombre, password);
                boolean login = loginCorrecto(u);
                if (login) {
                    MainStage mainStage = new MainStage();
                    loginButton.getScene().getWindow().hide();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Usuario o contraseña incorrectos");
                    alert.setHeaderText("Servidor cerrado o contraseña incorrecta");
                    alert.show();
                }
            }
        });
    }


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

    public boolean loginCorrecto(Usuario u) {
        boolean login = false;
        String Host = "localhost";
        int puerto = 6000;//puerto remoto

        System.setProperty("javax.net.ssl.trustStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.trustStorePassword", "1234567");
        try {
            SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket cliente = (SSLSocket) sfact.createSocket(Host, puerto);
            DataOutputStream flujoSalida = null;//PARA MANDAR EL CIFRADO
            DataInputStream flujoEntrada = null;//PARA RECIBIR LA CONFIRMACION

            flujoSalida = new DataOutputStream(cliente.getOutputStream());

            flujoSalida.writeUTF(u.getNombre());


            flujoSalida = new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF(get_SHA_512_SecurePassword(u.getPassword(), ""));


            flujoEntrada = new DataInputStream(cliente.getInputStream());
            login = flujoEntrada.readBoolean();

            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return login;
    }
}
