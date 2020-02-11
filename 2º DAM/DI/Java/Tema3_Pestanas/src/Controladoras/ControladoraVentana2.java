package Controladoras;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraVentana2 implements Initializable {
    @FXML
    Button btn1, btn2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {




        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) btn2.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../resources/layoutVentana2dos.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, btn2.getScene().getWidth(), btn2.getScene().getHeight());
                stage.setScene(scene);

            }
        });

    }
}
