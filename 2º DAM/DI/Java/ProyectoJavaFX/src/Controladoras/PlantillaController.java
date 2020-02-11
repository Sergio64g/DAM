package Controladoras;

import Utils.Entrenador;
import Utils.Equipo;
import Utils.Jugador;
import Utils.Jugadores;
import Ventanas.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class PlantillaController implements Initializable {

    @FXML
    JFXButton btnVolver, btnAgregar, btnEliminar;
    @FXML
    Label labelUser;
    @FXML
    TableView<Jugador> tablaJugadores;
    @FXML
    TableColumn columnName, columnDNI, columnPos;
    @FXML
    JFXTextField txtBuscar;

    ObservableList<Jugador> listaTabla;
    FilteredList<Jugador> listaFiltradas;
    SortedList<Jugador> listaOrdenada;
    Jugadores jugadores;
    Entrenador entrenador;
    boolean check;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        jugadores = new Jugadores();
        acciones();
    }

    private void acciones() {
        btnVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main main = new Main(entrenador, check);
                btnVolver.getScene().getWindow().hide();
            }
        });

        txtBuscar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                listaFiltradas.setPredicate(new Predicate<Jugador>() {
                    @Override
                    public boolean test(Jugador jugador) {
                        return jugador.getNombreJugador().contains(newValue);
                    }
                });
            }
        });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                ArrayList<String> listaOpciones = new ArrayList();
                listaOpciones.add("Portero");
                listaOpciones.add("Defensa");
                listaOpciones.add("Mediocentro");
                listaOpciones.add("Delantero");
                ObservableList<String> opciones = FXCollections.observableArrayList();
                opciones.addAll(listaOpciones);

                JFXTextField tNombre = new JFXTextField();
                tNombre.setPromptText("Nombre");
                JFXTextField tDNI = new JFXTextField();
                tDNI.setPromptText("DNI");
                ComboBox<String> comboBox = new ComboBox();
                comboBox.setItems(opciones);


                Dialog dialogo = new Dialog();
                dialogo.setTitle("Agregar Jugador");
                dialogo.setHeaderText("Agregar");
                GridPane gridContaint = new GridPane();
                gridContaint.setHgap(10);
                gridContaint.setVgap(10);

                gridContaint.add(new Label("Nombre"), 0, 0);
                gridContaint.add(tNombre, 1, 0);

                gridContaint.add(new Label("Apellido"), 0, 1);
                gridContaint.add(tDNI, 1, 1);

                gridContaint.add(new Label("Posicion"), 0, 2);
                gridContaint.add(comboBox, 1, 2);

                dialogo.getDialogPane().getButtonTypes().setAll(ButtonType.APPLY, ButtonType.CANCEL);

                dialogo.getDialogPane().setContent(gridContaint);
                Optional<ButtonType> resultado = dialogo.showAndWait();
                if (!tDNI.getText().isEmpty() && !tNombre.getText().isEmpty() && comboBox.getSelectionModel().getSelectedItem() != null) {
                    if (resultado.get() == ButtonType.APPLY) {
                        Jugador j = new Jugador(tDNI.getText(), tNombre.getText(), comboBox.getSelectionModel().getSelectedItem(), entrenador);
                        jugadores.addJugador(j);
                        listaTabla.add(j);
                        tablaJugadores.refresh();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Introduce todos los datos");
                    alert.show();
                }


            }
        });
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tablaJugadores.getSelectionModel().getSelectedItem() != null) {
                    Jugador j = tablaJugadores.getSelectionModel().getSelectedItem();
                    listaTabla.remove(j);
                    tablaJugadores.refresh();
                    jugadores.removeJugador(j);

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Seleccione un jugador");
                    alert.show();
                }
            }
        });
    }

    public void llenarTabla(Entrenador entrenador) {
        columnName.setCellValueFactory(new PropertyValueFactory<Jugador, String>("nombreJugador"));
        columnDNI.setCellValueFactory(new PropertyValueFactory<Jugador, String>("dniJugador"));
        columnPos.setCellValueFactory(new PropertyValueFactory<Jugador, String>("posicion"));

        listaTabla = FXCollections.observableArrayList();
        listaTabla.addAll(jugadores.buscarJugadoresTabla(entrenador));
        listaFiltradas = new FilteredList(listaTabla);
        listaOrdenada = new SortedList(listaFiltradas);

        listaOrdenada.comparatorProperty().bind(tablaJugadores.comparatorProperty());
        tablaJugadores.setItems(listaOrdenada);

        //TODO Colorear rows
        tablaJugadores.setRowFactory(tableView -> new TableRow<Jugador>() {
            @Override
            protected void updateItem(Jugador item, boolean empty) {
                super.updateItem(item, empty);
                /*System.out.println(item.getNombreJugador());
                switch (item.getPosicion()) {
                    case "Portero":
                        setStyle("-fx-background-color: tomato;");
                        break;
                    case "Defensa":
                        setStyle("-fx-background-color: blue;");
                        break;
                    case "Mediocentro":
                        setStyle("-fx-background-color: green");
                        break;
                    case "Delantero":
                        setStyle("-fx-background-color: red;");
                        break;

                }*/
            }
        });
    }

    public void pasarEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
        labelUser.setText(entrenador.getNombreEntrenador());
        llenarTabla(entrenador);
    }

    public void pasarCheck(boolean check) {
        this.check = check;
    }


}
