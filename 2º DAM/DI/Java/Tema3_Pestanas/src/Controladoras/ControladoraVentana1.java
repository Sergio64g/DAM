package Controladoras;

import Utils.Persona;
import Ventanas.Ventana2;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

/*
 * APPLICATION
 * --------------
 * Stage -> Scene -> Node
 *
 * */

public class ControladoraVentana1 implements Initializable {
    @FXML
    Button btnNormal, btnRojo, btnImagen, btnPantalla, btnLista;
    @FXML
    Button btnInfo, btnConfirmacion, btnInput, btnBotones, btnChoice, btnPerso;
    @FXML
    CheckBox check;
    @FXML
    RadioButton radio1, radio2, radio3;
    @FXML
    JFXTextField textoMaterial;
    @FXML
    TextArea textArea;
    @FXML
    ChoiceBox choice;
    @FXML
    ComboBox comboBox;
    @FXML
    ListView lista;
    @FXML
    TableView tabla;
    @FXML
    TableColumn columnNombre, columnApellido, columnEdad, columnDisponibilidad;
    @FXML
    TextField textoBuscar;
    @FXML
    JFXButton btnAgregar, btnBorrar, btnObtener;


    ToggleGroup group;
    ObservableList personas;
    ObservableList listaElementos;
    FilteredList<Persona> personasFiltradas;
    SortedList<Persona> listaOrdenada;

    DropShadow dropShadow = new DropShadow();
    DropShadow dropShadow2 = new DropShadow();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        personalizarBoton();
        instancias();
        acciones();
        personlaizarCombo();
        personalizarLista();
        personalizarTabla();
    }

    private void personalizarTabla() {

        columnNombre.setCellValueFactory(new PropertyValueFactory("propNombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory("propApellido"));
        columnEdad.setCellValueFactory(new PropertyValueFactory("propEdad"));
        columnDisponibilidad.setCellValueFactory(new PropertyValueFactory("propDisponibilidad"));

        personas = FXCollections.observableArrayList();
        personas.addAll(
                new Persona("Nombre1", "Apellido1", "1", true),
                new Persona("Nombre1", "Apellido1", "50", true),
                new Persona("Nombre2", "Apellido2", "2", true),
                new Persona("Nombre3", "Apellido3", "3", true),
                new Persona("Nombre4", "Apellido4", "4", true),
                new Persona("Nombre5", "Apellido5", "5", true));

        personasFiltradas = new FilteredList(personas);
        listaOrdenada = new SortedList(personasFiltradas);
        listaOrdenada.comparatorProperty().bind(tabla.comparatorProperty());
        /*listaOrdenada.setComparator(new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if (Integer.valueOf(o1.getEdad()) > Integer.valueOf(o2.getEdad())) {
                    return Integer.parseInt(o1.getEdad());
                } else {
                    return Integer.parseInt(o2.getEdad());
                }
            }
        });*/
        tabla.setItems(listaOrdenada);
    }

    private void personalizarLista() {

        listaElementos.addAll("Sergio", "Roman", "Pepe", "Jorge");
        lista.setItems(listaElementos);

    }

    private void personlaizarCombo() {
        ObservableList itemCombo = FXCollections.observableArrayList();
        ObservableList itemChoice = FXCollections.observableArrayList();
        itemChoice.addAll(1, 2, 3, 4, 5);
        itemCombo.addAll(1, 2, 3, 4, 5);
        comboBox.setItems(itemCombo);
        choice.setItems(itemChoice);

        comboBox.setPromptText("Selecciona un valor");
        comboBox.setVisibleRowCount(3);
    }

    private void instancias() {
        listaElementos = FXCollections.observableArrayList();
        group = new ToggleGroup();
        radio1.setUserData(new Persona("Borja", "Casado"));
        radio2.setUserData(new Persona("Jose", "Soltero"));
        radio3.setUserData(new Persona("Luis", "Casado"));
        group.getToggles().addAll(radio1, radio2, radio3);
        textArea.setWrapText(true);

    }

    private void personalizarBoton() {
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("../resources/button_ok.png")));
        btnImagen.setGraphic(image);
    }

    private void acciones() {
        btnNormal.setOnMouseExited(new ManejoRaton());
        btnNormal.setOnMouseEntered(new ManejoRaton());
        btnImagen.setOnMousePressed(new ManejoRaton());
        btnImagen.setOnMouseReleased(new ManejoRaton());


        check.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    btnImagen.setDisable(true);
                } else {
                    btnImagen.setDisable(false);
                }
            }
        });

        /*btnNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(group.getSelectedToggle().toString());
            }
        });*/

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                Persona persona = (Persona) newValue.getUserData();
                System.out.println(persona.toString());
            }
        });

        btnPantalla.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Ventana2 v2 = new Ventana2("Titulo");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        btnLista.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(lista.getSelectionModel().getSelectedItem());
            }
        });
        lista.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(lista.getSelectionModel().getSelectedItem());
                listaElementos.add(lista.getSelectionModel().getSelectedItem());

            }
        });
        btnInfo.setOnAction(new Dialogos());
        btnConfirmacion.setOnAction(new Dialogos());
        btnInput.setOnAction(new Dialogos());
        btnBotones.setOnAction(new Dialogos());
        btnChoice.setOnAction(new Dialogos());
        btnPerso.setOnAction(new Dialogos());

        textoBuscar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                personasFiltradas.setPredicate(new Predicate<Persona>() {
                    @Override
                    public boolean test(Persona persona) {
                        return persona.getNombre().toLowerCase().contains(newValue);
                    }
                });
            }
        });

        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            personas.add(new Persona("Sergio", "Garcia", "19", true));
            tabla.refresh();
            }
        });
        btnBorrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                personas.remove(tabla.getSelectionModel().getFocusedIndex());
                tabla.refresh();
            }
        });
        btnObtener.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(tabla.getSelectionModel().getSelectedIndex() != -1){
                    System.out.println(tabla.getSelectionModel().getSelectedItem().toString());
                } else {

            }}
        });
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                System.out.println(newValue);
            }
        });
    }

    class Dialogos implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == btnInfo) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("Titulo Informacion");
                dialogoInfo.setHeaderText("Header Info");
                dialogoInfo.setContentText("Contenido del dialogo");
                dialogoInfo.show();
            } else if (event.getSource() == btnConfirmacion) {
                Alert dialogoConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoConfirmacion.setTitle("Titulo Confirmacion");
                dialogoConfirmacion.setHeaderText("Header Confirmacion");
                dialogoConfirmacion.setContentText("Contenido del dialogo");
                Optional<ButtonType> resultado = dialogoConfirmacion.showAndWait();
                if (resultado.get() == ButtonType.OK) {
                    System.out.println("Resultado OK");
                } else if (resultado.get() == ButtonType.CANCEL) {
                    System.out.println("Resultado CANCEL");
                }

            } else if (event.getSource() == btnInput) {

            } else if (event.getSource() == btnBotones) {

                ButtonType b1 = new ButtonType("b1");
                Alert dialogoBotones = new Alert(Alert.AlertType.CONFIRMATION);
                dialogoBotones.setTitle("Titulo Botones");
                dialogoBotones.setHeaderText("Header Botones");
                dialogoBotones.setContentText("Contenido del dialogo");
                dialogoBotones.getButtonTypes().setAll(b1);

                Optional<ButtonType> resultado = dialogoBotones.showAndWait();
                if (resultado.get() == b1) {
                    System.out.println("Resultado OK");
                } else if (resultado.get() == ButtonType.CANCEL) {
                    System.out.println("Resultado CANCEL");
                }


            } else if (event.getSource() == btnChoice) {
                List listaOPciones = new ArrayList();
                listaOPciones.add("Opcion 1");
                listaOPciones.add("Opcion 2");
                listaOPciones.add("Opcion 3");
                listaOPciones.add("Opcion 4");
                ChoiceDialog<String> dialogoChoice = new ChoiceDialog(listaOPciones.get(0), listaOPciones);
                dialogoChoice.setTitle("Titulo Choice");
                dialogoChoice.setContentText("Selleciona un valor");
                dialogoChoice.setHeaderText("Header Choice");
                Optional p = dialogoChoice.showAndWait();
                if (p.isPresent()) {
                    System.out.println(p.toString());
                }


            } else if (event.getSource() == btnPerso) {

                Dialog dialog = new Dialog();
                dialog.setTitle("TituloPersonalizado");
                dialog.setHeaderText("Header Personalizado");
                GridPane grid = new GridPane();
                grid.add(new Label("Id"), 0, 0);
                grid.add(new TextField("Id"), 1, 0);
                grid.add(new Label("Nombre"), 0, 1);
                grid.add(new TextField(""), 1, 1);

                dialog.getDialogPane().getButtonTypes().addAll(ButtonType.APPLY, ButtonType.CANCEL);
                dialog.getDialogPane().setContent(grid);
                Optional<ButtonType> opcion = dialog.showAndWait();
                if (opcion.get() == ButtonType.APPLY) {
                    System.out.println("APPLY");
                }

            }

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {


        @Override
        public void handle(MouseEvent event) {
            if (event.getSource() == btnNormal) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    btnNormal.setEffect(null);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    btnNormal.setEffect(dropShadow);
                }
            } else if (event.getSource() == btnImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                    btnImagen.setEffect(dropShadow2);
                } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
                    btnImagen.setEffect(null);
                }

            }
        }
    }
}
