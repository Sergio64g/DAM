package Paneles;

import Paneles.Altas.DatosPersonales;
import Paneles.Altas.Direccion;
import Utils.Persona;
import Utils.Personas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltas extends JPanel implements ActionListener {
    Ventana v;
    DatosPersonales datosPersonales;
    Direccion direccion;
    JButton altas;
    Personas personas;
    PanelBajas panelBajas;

    public PanelAltas(Ventana v) {
        this.v = v;
        this.panelBajas = panelBajas;
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }


    private void configurar() {
        this.setLayout(new BorderLayout());
        this.add(datosPersonales, BorderLayout.NORTH);
        this.add(direccion, BorderLayout.CENTER);
        this.add(altas, BorderLayout.SOUTH);

    }

    private void instancias() {
        datosPersonales = new DatosPersonales();
        direccion = new Direccion();
        altas = new JButton("Dar de alta");
        personas = new Personas();
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public JButton getAltas() {
        return altas;
    }

    private void acciones() {
        altas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == altas) {
            if (comprobarCampos()) {
                Persona p = recogerPersona();
                if (!personas.exists(p)) {
                    personas.addPersona(p);
                    JOptionPane.showMessageDialog(this, p.getId() + " - " + p.getNombre() + " añadido",
                            "Persona Añadida", JOptionPane.INFORMATION_MESSAGE);
                    vaciarCampos();
                    v.actualizar();
                } else {
                    JOptionPane.showMessageDialog(this, "Este ID ya esta asiciado a una persona",
                            "ID existente", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Rellene todos los datos",
                        "Campos vacios", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void vaciarCampos() {
        datosPersonales.getClave().setText("");
        datosPersonales.getNombre().setText("");
        datosPersonales.getApellidos().setText("");
        datosPersonales.getEdad().setText("");
        direccion.getCalle().setText("");
        direccion.getNumero().setText("");
        direccion.getCodigoPostal().setText("");
    }

    public boolean comprobarCampos() {
        if (datosPersonales.getClave().getText().isEmpty()) {
            return false;
        } else if (datosPersonales.getNombre().getText().isEmpty()) {
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


    public Persona recogerPersona() {
        Persona p = new Persona();
        p.setId(datosPersonales.getClave().getText());
        p.setNombre(datosPersonales.getNombre().getText());
        p.setApellidos(datosPersonales.getApellidos().getText());
        p.setEdad(Integer.valueOf(datosPersonales.getEdad().getText()));
        p.setCalle(direccion.getCalle().getText());
        p.setNumero(Integer.valueOf(direccion.getNumero().getText()));
        p.setCodigoPostal(Integer.valueOf(direccion.getCodigoPostal().getText()));
        return p;
    }


}
