/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examentr1_di;

import Componentes.TextFieldLetras;
import Componentes.TextFieldNumeros;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Usuario DAM 2
 */
public class Ventana extends JFrame implements ActionListener {
    
    Container container;
    JPanel panelCentral, panelProgreso, panelDatos, panelNotas, panelLista;
    TextFieldLetras textNombre, textApellido;
    TextFieldNumeros textMatricula;
    SpinnerNumberModel modeloNumeros1, modeloNumeros2, modeloNumeros3, modeloNumeros4;
    JSpinner spDI, spPMDM, spPSP, spAD;
    DefaultListModel modeloLista;
    JList<Persona> lista;
    JProgressBar barraProgreso;
    JMenuBar barraMenu;
    JMenu menuValidar, menuCambiar;
    JMenuItem itemDatos, itemNotas, itemLista, itemValidar;
    CardLayout card;
    ArrayList<Integer> matriculas;
    final String TAG_1 = "tag1", TAG_2 = "tag2", TAG_3 = "tag3";
    Persona p;
    
    void initGUI() {
        instancias();
        configurarMenu();
        configurarBarra();
        configurarContainer();
        acciones();
        this.setVisible(true);
        this.setTitle("Examen_T2_DI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        pack();
    }
    
    private void instancias() {
        //Container
        container = this.getContentPane();
        //JPanel
        panelCentral = new JPanel();
        panelProgreso = new JPanel();
        panelDatos = new JPanel();
        panelNotas = new JPanel();
        panelLista = new JPanel();
        //JTextField
        textNombre = new TextFieldLetras("", 20);
        textApellido = new TextFieldLetras("", 20);
        textMatricula = new TextFieldNumeros("", 20);
        //SpinnerNumberModel
        modeloNumeros1 = new SpinnerNumberModel(0, 0, 10, 1);
        modeloNumeros2 = new SpinnerNumberModel(0, 0, 10, 1);
        modeloNumeros3 = new SpinnerNumberModel(0, 0, 10, 1);
        modeloNumeros4 = new SpinnerNumberModel(0, 0, 10, 1);
        //JSpinner
        spDI = new JSpinner(modeloNumeros1);
        spPMDM = new JSpinner(modeloNumeros2);
        spPSP = new JSpinner(modeloNumeros3);
        spAD = new JSpinner(modeloNumeros4);

        //DefaultlistModel
        modeloLista = new DefaultListModel<Persona>();
        modeloLista.addElement("Elementos");
        //JList
        lista = new JList<>(modeloLista);
        //JProgressBar
        barraProgreso = new JProgressBar();
        //JMenuBar
        barraMenu = new JMenuBar();
        //JMenu
        menuCambiar = new JMenu("Cambiar");
        menuValidar = new JMenu("Validar");
        //JmenuItem
        itemDatos = new JMenuItem("Datos");
        itemNotas = new JMenuItem("Notas");
        itemLista = new JMenuItem("Lista");
        itemValidar = new JMenuItem("Validar");
        //CardLayout
        card = new CardLayout();
        //ArrayList
        matriculas = new ArrayList<>();
        
    }
    
    private void configurarMenu() {
        menuValidar.add(itemValidar);
        menuCambiar.add(itemDatos);
        menuCambiar.add(itemNotas);
        menuCambiar.add(itemLista);
        
        barraMenu.add(menuValidar);
        barraMenu.add(menuCambiar);
        itemNotas.setEnabled(false);
        this.setJMenuBar(barraMenu);
        
    }
    
    private void configurarBarra() {
        //  JOptionPane.showMessageDialog(PestaniaSiete.this, "ESte es un diálogo de información", "Titulo del mensaje", JOptionPane.(ERROR)INFORMATION_MESSAGE, null);
        //barraProgreso.setValue(barraProgreso.getValue() + 25);
        barraProgreso.setMinimum(0);
        barraProgreso.setMaximum(100);
        barraProgreso.setValue(0);
        barraProgreso.setStringPainted(true);
        barraProgreso.setBorderPainted(true);
        
    }
    
    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configurarPanelCentral(), BorderLayout.CENTER);
        container.add(configurarPanelProgreso(), BorderLayout.SOUTH);
        
    }
    
    public JPanel configurarPanelCentral() {
        panelCentral.setLayout(card);
        
        panelCentral.add(configurarPanelDatos(), TAG_1);
        panelCentral.add(configurarPanelNotas(), TAG_2);
        panelCentral.add(configurarPanelLista(), TAG_3);
        card.show(panelCentral, TAG_1);
        
        return panelCentral;
    }
    
    private JPanel configurarPanelProgreso() {
        panelProgreso.add(barraProgreso);
        return panelProgreso;
    }
    
    public void configurarConstraints(int posx, int posy, int tx, int ty, int ali,
            int fill, double pesx, double pesy, Component component, JPanel panel, Integer top, Integer left, Integer bottom, Integer right) {
        
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
    
    public JPanel configurarPanelNotas() {
        panelNotas.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Nt_DI"), panelNotas, 10, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, spDI, panelNotas, 10, 10, 10, 10);
        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Nt_PMDM"), panelNotas, 10, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, spPMDM, panelNotas, 10, 10, 10, 10);
        configurarConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("Nt_PSP"), panelNotas, 10, 10, 10, 10);
        configurarConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, spPSP, panelNotas, 10, 10, 10, 10);
        configurarConstraints(0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, new JLabel("nt_AD"), panelNotas, 10, 10, 10, 10);
        configurarConstraints(1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.25, spAD, panelNotas, 10, 10, 10, 10);
        
        return panelNotas;
    }
    
    public JPanel configurarPanelDatos() {
        panelDatos.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, new JLabel("Nombre"), panelDatos, 10, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, textNombre, panelDatos, 10, 10, 10, 10);
        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, new JLabel("Apellidos"), panelDatos, 10, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, textApellido, panelDatos, 10, 10, 10, 20);
        configurarConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, new JLabel("Matrícula"), panelDatos, 10, 10, 10, 10);
        configurarConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.3, textMatricula, panelDatos, 10, 10, 10, 10);
        
        return panelDatos;
    }
    
    public JPanel configurarPanelLista() {
        panelLista.add(lista);
        
        return panelLista;
    }
    
    private void acciones() {
        itemDatos.addActionListener(this);
        itemNotas.addActionListener(this);
        itemLista.addActionListener(this);
        itemValidar.addActionListener(this);
        
    }
    
    public void limpiarCampos() {
        textNombre.setText("");
        textApellido.setText("");
        textMatricula.setText("");
        spDI.getModel().setValue(0);
        spPMDM.getModel().setValue(0);
        spPSP.getModel().setValue(0);
        spAD.getModel().setValue(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == itemValidar) {
            String nombre, apellido;
            int ntDI, ntPMDM, ntPSP, ntAD;
            int matricula = 0;
            
            if (panelDatos.isShowing()) {
                if (textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || textMatricula.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Ventana.this, "Rellena todos los campos antes de continuar", "ERROR", JOptionPane.ERROR_MESSAGE, null);
                } else {
                    nombre = textNombre.getText();
                    apellido = textApellido.getText();
                    matricula = Integer.valueOf(textMatricula.getText());
                    if (matriculas.contains(matricula)) {
                        JOptionPane.showMessageDialog(Ventana.this, "La matricula ya ha sido añadida, pruebe con otra", "ERROR", JOptionPane.ERROR_MESSAGE, null);
                        
                    } else {
                        p = new Persona(nombre, apellido, matricula);
                        matriculas.add(matricula);
                        JOptionPane.showMessageDialog(Ventana.this, p.toString() + "      Añadido\n\nCambie de ventana para continuar", "Persona Añadida", JOptionPane.INFORMATION_MESSAGE, null);
                        itemValidar.setEnabled(false);
                        itemDatos.setEnabled(false);
                        itemNotas.setEnabled(true);
                        limpiarCampos();
                        barraProgreso.setValue(barraProgreso.getValue() + 50);
                    }
                }
                
            } else if (panelNotas.isShowing()) {
                ntDI = Integer.valueOf(spDI.getModel().getValue().toString());
                ntPMDM = Integer.valueOf(spPMDM.getModel().getValue().toString());
                ntPSP = Integer.valueOf(spPSP.getModel().getValue().toString());
                ntAD = Integer.valueOf(spAD.getModel().getValue().toString());
                p.DarNotas(ntDI, ntPMDM, ntPSP, ntAD);
                card.show(panelCentral, TAG_3);
                modeloLista.addElement(p);
                JOptionPane.showMessageDialog(Ventana.this, "DI: " + p.getNtDI() + "\nPMDM: " + p.getNtDI() + "\nPSP: " + p.getNtDI() + "\nAD: " + p.getNtDI(), "Notas Introducidas", JOptionPane.INFORMATION_MESSAGE, null);
                itemNotas.setEnabled(false);
                itemDatos.setEnabled(true);
                card.show(panelCentral, TAG_3);
                itemValidar.setEnabled(false);
                limpiarCampos();
                barraProgreso.setValue(barraProgreso.getValue() + 50);
                if (barraProgreso.getValue() == 100) {
                    JOptionPane.showMessageDialog(Ventana.this, "El alumno se ha registrado", "Alumno introducido", JOptionPane.INFORMATION_MESSAGE, null);
                    barraProgreso.setValue(0);
                }
            }
            
        } else if (e.getSource() == itemDatos) {
            card.show(panelCentral, TAG_1);
            itemValidar.setEnabled(true);
        } else if (e.getSource() == itemNotas) {
            card.show(panelCentral, TAG_2);
            itemValidar.setEnabled(true);
            itemDatos.setEnabled(false);
            
        } else if (e.getSource() == itemLista) {
            card.show(panelCentral, TAG_3);
            itemValidar.setEnabled(false);
            
        }
        
    }
    
}
