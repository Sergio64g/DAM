package Ventanas;

import Controladoras.PlantillaController;
import Utils.Entrenador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Plantilla extends Stage {


    PlantillaController controller;

    public Plantilla(Entrenador entrenador, boolean check) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/plantilla_layout.fxml"));

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller = loader.getController();
        controller.pasarEntrenador(entrenador);
        controller.pasarCheck(check);
        Scene scene = new Scene(root, 600, 400);
        this.setResizable(false);
        this.setScene(scene);
        this.show();


    }
}
