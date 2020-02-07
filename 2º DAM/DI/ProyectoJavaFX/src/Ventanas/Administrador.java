package Ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Administrador extends Stage {
    public Administrador() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Layouts/login_layout.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 651, 420);
        this.setScene(scene);
        this.setResizable(false);
        this.setTitle("Ventana de Login");
        this.show();
    }
}
