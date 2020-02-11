package Controladoras;

import Ventanas.Ventana1;
import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraSplash implements Initializable {

    @FXML
    ImageView imagen;
    @FXML
    ProgressBar progressBar;
    Task task;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        progressBar.progressProperty().bind(task.progressProperty());

        Thread thread = new Thread(task);
        thread.start();



                task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        Ventana1 ventana1 = new Ventana1();
                        Stage stage = (Stage) imagen.getScene().getWindow();
                        stage.close();
                    }
                });
    }

    private void instancias() {
        task = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    updateProgress(i, 100.0);
                    //progressBar.setProgress(progressBar.getProgress() + 0.01);
                    Thread.sleep(10);
                }

                return null;
            }
        };
    }
}
