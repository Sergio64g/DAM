package Paneles;

import Paneles.Modificaciones.DatosPersonales;
import Paneles.Modificaciones.Direccion;
import Paneles.Modificaciones.SeleccionClave;
import Utils.Persona;
import Utils.Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelModificaciones extends JPanel implements ItemListener, ActionListener {

    SeleccionClave seleccionClave;
    DatosPersonales datosPersonales;
    Direccion direccion;
    JButton modificar, limpiar;
    Personas personas;
    Ventana v;

    public PanelModificaciones(Ventana v) {
        this.v = v;
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }

    private void acciones() {
        modificar.addActionListener(this);
        limpiar.addActionListener(this);
        seleccionClave.getComboBox().addItemListener(this);
    }

    private void configurar() {
        this.setLayout(new BorderLayout());
        JPanel abajo = new JPanel();
        abajo.setLayout(new BorderLayout());
        abajo.add(direccion, BorderLayout.NORTH);
        JPanel btns = new JPanel();
        btns.add(modificar);
        btns.add(limpiar);
        abajo.add(btns, BorderLayout.SOUTH);
        this.add(seleccionClave, BorderLayout.NORTH);
        this.add(datosPersonales, BorderLayout.CENTER);
        this.add(abajo, BorderLayout.SOUTH);
    }

    private void instancias() {
        seleccionClave = new SeleccionClave();
        datosPersonales = new DatosPersonales();
        direccion = new Direccion();
        modificar = new JButton("Modificar");
        limpiar = new JButton("Limpiar");
        personas = new Personas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modificar) {
            if (comprobarCampos()){
                Persona p = (Persona) seleccionClave.getModeloComboBox().getSelectedItem();
                p.setNombre(datosPersonales.getNombre().getText());
                p.setApellidos(datosPersonales.getApellidos().getText());
                p.setEdad(Integer.valueOf(datosPersonales.getEdad().getText()));
                p.setCalle(direccion.getCalle().getText());
                p.setNumero(Integer.valueOf(direccion.getNumero().getText()));
                p.setCodigoPostal(Integer.valueOf(direccion.getCodigoPostal().getText()));
                personas.update(p);
                v.actualizar();
                JOptionPane.showMessageDialog(this, p.getId() + " - " + p.getNombre() + " modificado",
                        "Persona Modificada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Rellene todos los datos",
                        "Campos vacios", JOptionPane.ERROR_MESSAGE);
            }


        } else if (e.getSource() == limpiar) {
            seleccionClave.getModeloComboBox().setSelectedItem(null);
            rellenarNull();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == seleccionClave.getComboBox()) {
            if (seleccionClave.getModeloComboBox().getSelectedItem() == null) {
                rellenarNull();
            } else {
                if (seleccionClave.getModeloComboBox().getSelectedItem().getClass() == Persona.class) {
                    Persona p = (Persona) seleccionClave.getModeloComboBox().getSelectedItem();
                    rellenarDatos(p);
                }
            }
        }
    }

    public void rellenarDatos(Persona p) {
        datosPersonales.getNombre().setText(p.getNombre());
        datosPersonales.getApellidos().setText(p.getApellidos());
        datosPersonales.getEdad().setText(String.valueOf(p.getEdad()));
        direccion.getCalle().setText(p.getCalle());
        direccion.getNumero().setText(String.valueOf(p.getNumero()));
        direccion.getCodigoPostal().setText(String.valueOf(p.getCodigoPostal()));
    }

    public void rellenarNull() {
        datosPersonales.getNombre().setText(null);
        datosPersonales.getApellidos().setText(null);
        datosPersonales.getEdad().setText(null);
        direccion.getCalle().setText(null);
        direccion.getNumero().setText(null);
        direccion.getCodigoPostal().setText(null);
    }

    public boolean comprobarCampos() {
        if (datosPersonales.getNombre().getText().isEmpty()) {
            return false;
        } else if (datosPersonales.getApellidos().getText().isEmpty()) {
            return false;
        } else if (datosPersonales.getEdad().getText().isEmpty()) {
            return false;
        } else if (direccion.getCalle().getText().isEmpty()) {
            return false;
        } else if (direccion.getNumero().getText().isEmpty()) {
            return false;
        } else if (direccion.getCodigoPostal().getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public SeleccionClave getSeleccionClave() {
        return seleccionClave;
    }
}