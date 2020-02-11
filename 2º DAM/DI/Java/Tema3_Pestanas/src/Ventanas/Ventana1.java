package Ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ventana1 extends Stage {

    public Ventana1() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../resources/layoutVentana1.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 600, 800);
        this.setScene(scene);
        this.show();
    }


}
