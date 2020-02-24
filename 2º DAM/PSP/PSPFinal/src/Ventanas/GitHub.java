package Ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GitHub extends Stage {

    public GitHub() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Layouts/github_layout.fxml"));
        } catch (
                IOException e) {
            System.err.println("Error in Login class");
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 414, 390.0);
        this.setResizable(false);
        this.setScene(scene);
        this.show();
    }
}
