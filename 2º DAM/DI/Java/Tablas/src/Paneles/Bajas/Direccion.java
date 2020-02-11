package Paneles.Bajas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Direccion extends JPanel {

    JTextField calle, numero, codigoPostal;

    public Direccion(){
        initGUI();
        this.setBorder(new TitledBorder("Dirección"));
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }

    private void acciones() {
        codigoPostal.addKeyListener(new ManejoTeclasNum());
        numero.addKeyListener(new ManejoTeclasNum());

    }

    private void instancias() {
        calle = new JTextField(20);
        calle.setEnabled(false);
        numero = new JTextField(20);
        numero.setEnabled(false);
        codigoPostal = new JTextField(20);
        codigoPostal.setEnabled(false);
    }


    public void configurarConstraints(int posx, int posy, int tx, int ty, int ali,
                                      int fill, double pesx, double pesy, Component component, JPanel panel,
                                      Integer top, Integer left, Integer bottom, Integer right) {

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
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Calle: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, calle, this, 10, 10, 10, 10);

        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Numero: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, numero, this, 10, 10, 10, 10);

        configurarConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Codigo Postal: "), this, 10, 10, 10, 10);
        configurarConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, codigoPostal, this, 10, 10, 10, 10);

    }

    public JTextField getCalle() {
        return calle;
    }

    public JTextField getNumero() {
        return numero;
    }

    public JTextField getCodigoPostal() {
        return codigoPostal;
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
