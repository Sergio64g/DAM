package Controladoras;

import Utils.GitHub;
import Ventanas.MainStage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GitHubController implements Initializable {

    @FXML
    TextField githubField;
    @FXML
    TextArea textArea;
    @FXML
    Button returnButton, codeButton;

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
                GitHub gitHub = new GitHub(newValue);
                textArea.setText(gitHub.getCode());
            }
        });
        codeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!githubField.getText().isEmpty()){

                } else {
                    //TODO Alert por textField Vacio
                }
            }
        });
    }


}
