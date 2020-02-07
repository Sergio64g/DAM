package Controladoras;

import Utils.Persona;
import Ventanas.Login;
import Ventanas.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    JFXButton btnVolver;
    @FXML
    JFXTextField txtPersona;

    public MainController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login main = new Login();
                btnVolver.getScene().getWindow().hide();
            }
        });
    }
}
