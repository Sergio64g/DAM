package Paneles.Resumen;

import Paneles.Altas.DatosPersonales;
import Utils.Persona;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Datos extends JPanel {

    JTextField clave, nombre, apellidos, edad, calle, numero, codigoPostal;

    public Datos() {
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
        numero.addKeyListener(new ManejoTeclasNum());
        codigoPostal.addKeyListener(new ManejoTeclasNum());
    }

    private void instancias() {
        clave = new JTextField(20);
        nombre = new JTextField(20);
        apellidos = new JTextField(20);
        edad = new JTextField(20);
        calle = new JTextField(20);
        numero = new JTextField(20);
        codigoPostal = new JTextField(20);
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

        configurarConstraints(0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Calle: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, calle, this, 10, 10, 10, 10);

        configurarConstraints(0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Numero: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, numero, this, 10, 10, 10, 10);

        configurarConstraints(0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Codigo Postal: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, codigoPostal, this, 10, 10, 10, 10);

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

    public boolean comprobarCampos() {
        if (clave.getText().isEmpty()) {
            return false;
        } else if (nombre.getText().isEmpty()) {
            return false;
        } else if (apellidos.getText().isEmpty()) {
            return false;
        } else if (edad.getText().isEmpty()) {
            return false;
        } else if (calle.getText().isEmpty()) {
            return false;
        } else if (numero.getText().isEmpty()) {
            return false;
        } else if (codigoPostal.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void vaciarCampos() {
        clave.setText("");
        nombre.setText("");
        apellidos.setText("");
        edad.setText("");
        calle.setText("");
        numero.setText("");
        codigoPostal.setText("");
    }
    public void rellenarPersona(Persona p){
        clave.setText(p.getId());
        nombre.setText(p.getNombre());
        apellidos.setText(p.getApellidos());
        edad.setText(String.valueOf(p.getEdad()));
        calle.setText(p.getCalle());
        numero.setText(String.valueOf(p.getNumero()));
        codigoPostal.setText(String.valueOf(p.getCodigoPostal()));
    }

    public Persona recogerPersona() {
        Persona p = new Persona();
        p.setId(clave.getText());
        p.setNombre(nombre.getText());
        p.setApellidos(apellidos.getText());
        p.setEdad(Integer.valueOf(edad.getText()));
        p.setCalle(calle.getText());
        p.setNumero(Integer.valueOf(numero.getText()));
        p.setCodigoPostal(Integer.valueOf(codigoPostal.getText()));
        return p;
    }


}
