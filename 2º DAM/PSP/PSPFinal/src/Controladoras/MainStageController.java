package Controladoras;

import Ventanas.GitHub;
import Ventanas.Archivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MainStageController implements Initializable {

    @FXML
    Button miEquipoButton, githubButton;
    @FXML
    TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        acciones();
    }

    private void acciones() {
    githubButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            GitHub gitHub = new GitHub();
            githubButton.getScene().getWindow().hide();
        }
    });
        miEquipoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Archivo archivo = new Archivo();
                miEquipoButton.getScene().getWindow().hide();
            }
        });
    }
}
