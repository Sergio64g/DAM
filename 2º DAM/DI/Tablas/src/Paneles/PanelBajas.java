package Paneles;

import Paneles.Bajas.DatosPersonales;
import Paneles.Bajas.Direccion;
import Paneles.Bajas.SeleccionClave;
import Utils.Persona;
import Utils.Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class PanelBajas extends JPanel implements ItemListener, ActionListener {

    SeleccionClave clave;
    DatosPersonales datosPersonales;
    Direccion direccion;
    JButton bajas;
    Personas personas;
    Ventana v;

    public PanelBajas(Ventana v) {
        this.v = v;
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }

    private void acciones() {
        clave.getComboBox().addItemListener(this);
        bajas.addActionListener(this);
    }

    private void configurar() {
        this.setLayout(new BorderLayout());
        JPanel abajo = new JPanel();
        abajo.setLayout(new BorderLayout());
        abajo.add(direccion, BorderLayout.CENTER);
        abajo.add(bajas, BorderLayout.SOUTH);
        this.add(clave, BorderLayout.NORTH);
        this.add(datosPersonales, BorderLayout.CENTER);
        this.add(abajo, BorderLayout.SOUTH);
    }

    private void instancias() {
        clave = new SeleccionClave();
        datosPersonales = new DatosPersonales();
        direccion = new Direccion();
        bajas = new JButton("Dar de Baja");
        personas = new Personas();
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
        datosPersonales.getNombre().setText("");
        datosPersonales.getApellidos().setText("");
        datosPersonales.getEdad().setText("");
        direccion.getCalle().setText("");
        direccion.getNumero().setText("");
        direccion.getCodigoPostal().setText("");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == clave.getComboBox()) {
            if (clave.getModeloComboBox().getSelectedItem() == null) {
                rellenarNull();
            } else {
                if (clave.getModeloComboBox().getSelectedItem().getClass() == Persona.class) {
                    Persona p = (Persona) clave.getModeloComboBox().getSelectedItem();
                    rellenarDatos(p);
                } else {
                    rellenarNull();
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bajas) {

            Persona p = (Persona) clave.getModeloComboBox().getSelectedItem();
            if (p != null) {
                if (personas.exists(p)) {
                    personas.removePersona(p);
                    JOptionPane.showMessageDialog(this, p.getId() + " - " + p.getNombre() + " borrado",
                            "Persona Borrada", JOptionPane.INFORMATION_MESSAGE);
                    rellenarNull();
                    v.actualizar();
                }
            }
        }
    }

    public SeleccionClave getClave() {
        return clave;
    }
}

