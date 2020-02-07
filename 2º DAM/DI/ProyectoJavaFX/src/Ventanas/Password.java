package Ventanas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Password extends Stage {
    public Password() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Layouts/main_layout.fxml"));
        } catch (IOException e) {
            System.err.println("Error in Main class");
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 700, 500);
        this.setResizable(false);
        this.setScene(scene);
        this.show();


    }
}
