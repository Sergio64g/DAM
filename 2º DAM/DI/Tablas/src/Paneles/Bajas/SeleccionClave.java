package Paneles.Bajas;

import Utils.Persona;
import Utils.Personas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class SeleccionClave extends JPanel {

    JComboBox comboBox;
    DefaultComboBoxModel<Persona> modeloComboBox;

    Personas personas;

    public SeleccionClave() {
        initGUI();
        this.setBorder(new TitledBorder("Seleccion Clave"));
    }

    private void initGUI() {
        instancias();
        modelo();
        configurar();
        modelo();
    }

    public void modelo() {

        modeloComboBox.removeAllElements();
        modeloComboBox.addElement(null);
        for (Persona p : personas.list()){
            modeloComboBox.addElement(p);
        }
    }

    public void configurarConstraints(int posx, int posy, int tx, int ty, int ali,
                                      int fill, double pesx, double pesy, Component component,
                                      JPanel panel, Integer top, Integer left, Integer bottom, Integer right) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = tx;  // Tamaño x
        constraints.gridheight = ty; // Tamaño y
        constraints.gridx = posx; //Posicion x
        constraints.gridy = posy; //Posicion x
        constraints.anchor = ali; //Posicion interna (Centro, derecha, etc)
        constraints.fill = fill; // Para donde se va a expandir
        constraints.weightx = pesx; //Peso x
        constraints.weighty = pesy; //Peso y
        constraints.insets = new Insets(top, left, bottom, right);
        panel.add(component, constraints);

    }

    private void configurar() {
        this.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Clave: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, comboBox, this, 10, 10, 10, 10);
    }

    private void instancias() {
        modeloComboBox = new DefaultComboBoxModel();
        comboBox = new JComboBox(modeloComboBox);
        personas = new Personas();
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public DefaultComboBoxModel<Persona> getModeloComboBox() {
        return modeloComboBox;
    }
}
