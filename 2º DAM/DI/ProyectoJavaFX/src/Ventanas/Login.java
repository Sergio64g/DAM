package Ventanas;

import Controladoras.LoginController;
import Utils.Entrenador;
import Utils.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Stage {

    Entrenador entrenador;
    private LoginController controller;

    public Login(Entrenador e) {
        this.entrenador = e;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/login_layout.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        controller = loader.getController();
        controller.guardarPersona(e);

        Scene scene = new Scene(root, 651, 420);
        this.setScene(scene);
        this.setResizable(false);
        this.setTitle("Ventana de Login");
        this.show();
    }

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


