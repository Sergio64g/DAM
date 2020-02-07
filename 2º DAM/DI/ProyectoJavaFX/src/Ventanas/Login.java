package Ventanas;

import Controladoras.LoginController;
import Utils.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Stage {

    /*Persona p;
    private LoginController controller;

    public Login(Persona p) {
        this.p = p;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/login_layout.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller = loader.getController();
        controller.pasarPersona(p);

        Scene scene = new Scene(root, 651, 420);
        this.setScene(scene);
        this.setResizable(false);
        this.setTitle("Ventana de Login");
        this.show();
    }*/

    public Login() {
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


