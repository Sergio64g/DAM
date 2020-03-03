package Ventanas;

import Controladoras.LoginController;
import Controladoras.MainStageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.applet.Main;

import java.io.IOException;

public class MainStage extends Stage {

    public MainStage() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Layouts/mainstage_layout.fxml"));
        } catch (IOException e) {
            System.err.println("Error in Login class");
            e.printStackTrace();
        }
        Scene scene = new Scene(root, 600, 400);
        this.setResizable(false);
        this.setScene(scene);
        this.show();

    }
    String code;
    private MainStageController controller;

    public MainStage(String code) {
        this.code = code;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/mainstage_layout.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        controller = loader.getController();
        controller.guardarCompilado(code);

        Scene scene = new Scene(root, 600, 400);
        this.setScene(scene);
        this.setResizable(false);
        this.setTitle("MainStage");
        this.show();
    }
}
