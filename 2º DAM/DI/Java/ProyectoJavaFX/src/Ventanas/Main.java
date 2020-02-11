package Ventanas;

import Controladoras.MainController;
import Utils.Entrenador;
import Utils.Persona;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Stage {

    Entrenador entrenador;
    MainController controller;
    boolean check;

    public Main(Entrenador entrenador, boolean check) {
        this.check = check;
        this.entrenador = entrenador;
        initGUI();
    }

    private void initGUI() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/main_layout.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller = loader.getController();
        controller.recibirParametros(entrenador);
        controller.checked(check);
        Scene scene = new Scene(root, 675, 480);
        this.setResizable(false);
        this.setScene(scene);
        this.setTitle("Ventana Principal");
        this.show();

    }
}
