package Ventanas;

import Controladoras.MainController;
import Utils.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Stage {


    public Main() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/main_layout.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            System.err.println("Error in Main class");
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 700, 500);
        this.setResizable(false);
        this.setScene(scene);
        this.setTitle("Ventana Principal");
        this.show();


    }
}
