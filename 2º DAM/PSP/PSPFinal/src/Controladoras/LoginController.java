package Controladoras;

import Ventanas.MainStage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
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
                MainStage mainStage = new MainStage();
                loginButton.getScene().getWindow().hide();
            }
        });
    }
}
