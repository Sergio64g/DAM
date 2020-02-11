package Paneles.Altas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DatosPersonales extends JPanel {

    JTextField clave, nombre, apellidos, edad;

    public DatosPersonales() {
        initGUI();
        this.setBorder(new TitledBorder("Datos Personales"));
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }

    private void acciones() {
        edad.addKeyListener(new ManejoTeclasNum());
    }

    private void instancias() {
        clave = new JTextField(20);
        nombre = new JTextField(20);
        apellidos = new JTextField(20);
        edad = new JTextField(20);
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
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, clave, this, 10, 10, 10, 10);

        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Nombre: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, nombre, this, 10, 10, 10, 10);

        configurarConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Apellidos: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, apellidos, this, 10, 10, 10, 10);

        configurarConstraints(0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Edad: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, edad, this, 10, 10, 10, 10);

    }

    public JTextField getClave() {
        return clave;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getApellidos() {
        return apellidos;
    }

    public JTextField getEdad() {
        return edad;
    }

    class ManejoTeclasNum extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            char tecla = e.getKeyChar();
            if (!Character.isDigit(tecla)) {
                e.consume();
            }
        }
    }
}
