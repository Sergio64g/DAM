package Controladoras;

import Utils.Entrenador;
import Utils.Persona;
import Ventanas.Login;
import Ventanas.Plantilla;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    JFXButton btnVolver, btnPlantilla;
    @FXML
    Label labelUser, nombreEquipo, ciudadEquipo;
    @FXML
    ImageView imagenEquipo;

    boolean check;
    Entrenador entrenador;

    public MainController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (check == true) {
                    Login main = new Login(entrenador);
                } else {
                    Login main = new Login();
                }
                btnVolver.getScene().getWindow().hide();
            }
        });


        btnPlantilla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Plantilla plantilla = new Plantilla(entrenador, check);
                btnPlantilla.getScene().getWindow().hide();
            }
        });
    }

    public void recibirParametros(Entrenador e) {
        entrenador = e;
        labelUser.setText(e.getNombreEntrenador());
        nombreEquipo.setText(e.getEquipo().getNombreEquipo());
        ciudadEquipo.setText(e.getEquipo().getCiudadEquipo());
        //TODO Imagenes no validas
        imagenEquipo.setImage(new Image(getClass().getResourceAsStream("../Resources/Equipos/" + e.getEquipo().getImagenEquipo())));
    }

    public void checked(boolean check) {
        this.check = check;
    }
}
