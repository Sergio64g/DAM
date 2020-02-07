package Controladoras;

import Utils.Persona;
import Utils.Personas;
import Ventanas.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarController implements Initializable {

    @FXML
    JFXTextField inputDNI, inputName;
    @FXML
    JFXPasswordField inputPassword;
    @FXML
    JFXComboBox comboPolicy;
    @FXML
    JFXButton btnRegistrar, btnVolver;

    Personas personas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personas = new Personas();
        comboBox();
        acciones();

    }

    private void acciones() {
        btnRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registrar();
            }
        });

        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                volver();
            }
        });
    }

    private void volver() {
        Login login = new Login();
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.hide();
    }


    private void comboBox() {
        ObservableList opciones = FXCollections.observableArrayList();
        String options[] = {"Administrador", "Usuario"};
        opciones.addAll(options);

        comboPolicy.setItems(opciones);
    }

    private void registrar() {
        Persona p = recogerPersona();
        if (comprobarVacio()) {
            if (!personas.exists(p)) {
                personas.addPersona(p);
                volver();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("El DNI ya esta registrado, pruebe otro");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Rellene todos los campos");
            alert.show();
        }
    }

    public boolean comprobarVacio() {
        if (inputDNI.getText().isEmpty()) {
            return false;
        } else if (inputName.getText().isEmpty()) {
            return false;
        } else if (inputPassword.getText().isEmpty()) {
            return false;
        } else if (comboPolicy.getSelectionModel().isEmpty()) {
            return false;
        }
        return true;
    }

    private Persona recogerPersona() {
        Persona p = new Persona(inputDNI.getText(), inputName.getText(), inputPassword.getText(),
                (String) comboPolicy.getSelectionModel().getSelectedItem());
        return p;
    }
}
