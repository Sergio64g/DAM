package Ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Ventana2 extends Stage {


    public Ventana2(String titulo) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../resources/layoutVentana2.fxml"));
        Scene scene = new Scene(root, 550, 800);
        this.setScene(scene);
        this.setTitle(titulo);
        this.initStyle(StageStyle.DECORATED);
        this.show();
    }


}
