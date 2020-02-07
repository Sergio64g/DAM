package Controladoras;

import Ventanas.Login;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    ProgressBar progressBar;

    Task progressTask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        instancias();
        progressBar.progressProperty().bind(progressTask.progressProperty());
        new Thread(progressTask).start();

        progressTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                Login login = new Login();
                Stage stage = (Stage) progressBar.getScene().getWindow();
                stage.hide();
            }
        });

    }

    private void instancias() {
        progressTask = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(10);
                }
                return null;
            }
        };
    }
}
