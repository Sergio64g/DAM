package Controladoras;

import Utils.Entrenador;
import Utils.Entrenadores;
import Utils.Persona;
import Utils.Personas;
import Ventanas.Main;
import Ventanas.Registrar;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    JFXTextField inputUser;
    @FXML
    JFXPasswordField inputPassword;
    @FXML
    JFXButton btnSesion, btnRegistrar;
    @FXML
    JFXCheckBox check;

    Entrenadores entrenadores;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entrenadores = new Entrenadores();
        acciones();
    }

    private void acciones() {
        btnSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sesion();
            }
        });
        btnRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registrar();
            }
        });
    }

    private void registrar() {
        Registrar registrar = new Registrar();
        Stage stage = (Stage) inputUser.getScene().getWindow();
        stage.hide();
    }

    private void sesion() {
        String user = inputUser.getText();
        String pass = inputPassword.getText();
        Entrenador e = new Entrenador(user, pass);
        Entrenador entrenador = entrenadores.loginCorrecto(e);
        if (entrenador != null) {
            Main main = new Main(entrenador, check.isSelected());
            Stage stage = (Stage) inputUser.getScene().getWindow();
            stage.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Contraseña o usuario incorrectas");

            alert.show();
        }
    }

    public void guardarPersona(Entrenador e) {
        inputUser.setText(e.getNombreEntrenador());
        inputPassword.setText(e.getPasswordEntrenador());
    }
}
