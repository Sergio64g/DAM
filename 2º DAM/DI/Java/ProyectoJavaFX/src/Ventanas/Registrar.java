package Ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Registrar extends Stage {
    public Registrar() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Layouts/registrar_layout.fxml"));
        } catch (IOException e) {
            System.err.println("Error in Main class");
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 600, 545);
        this.setResizable(false);
        this.setScene(scene);
        this.setTitle("Ventana de Registro");
        this.show();


    }
}
