package Controladoras;

import Utils.*;
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
    JFXComboBox<Equipo> comboEquipos;
    @FXML
    JFXButton btnRegistrar, btnVolver;

    Entrenadores entrenadores;
    IdsEntrenadores idsEntrenadores;
    Equipos equipos;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entrenadores = new Entrenadores();
        idsEntrenadores = new IdsEntrenadores();
        equipos = new Equipos();
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
        ObservableList<Equipo> opciones = FXCollections.observableArrayList();

        opciones.addAll(equipos.list());
        comboEquipos.setItems(opciones);
    }

    private void registrar() {

        if (comprobarVacio()) {
            Entrenador entrenador = recogerEntrenador();
            if (!entrenadores.existsEntrenador(entrenador)) {
                entrenador.setIdEntrenador(idsEntrenadores.sacarId());
                entrenadores.addEntrenador(entrenador);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmacion");
                alert.setHeaderText(entrenador.getNombreEntrenador() + " registrado");
                alert.showAndWait();
                volver();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("El usuario ya exsite, elija otro");
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
        } else if (comboEquipos.getSelectionModel().isEmpty()) {
            return false;
        }
        return true;
    }

    private Entrenador recogerEntrenador() {
        Entrenador entrenador = new Entrenador( inputName.getText(), inputDNI.getText(), inputPassword.getText(),
                comboEquipos.getSelectionModel().getSelectedItem());
        return entrenador;
    }
}
