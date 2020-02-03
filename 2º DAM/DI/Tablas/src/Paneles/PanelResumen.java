package Paneles;

import Paneles.Resumen.Datos;
import Utils.ModeloTabla;
import Utils.Persona;
import Utils.Personas;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelResumen extends JPanel implements ListSelectionListener, ActionListener {

    JTable tabla;
    ModeloTabla modeloTabla;
    Personas personas;
    JScrollPane scroll;
    Ventana v;
    Datos datos;
    JButton alta, baja;


    public PanelResumen(Ventana v) {
        this.v = v;
        initGUI();
    }

    private void initGUI() {
        instancias();
        configurar();
        acciones();
    }

    private void acciones() {
        tabla.getSelectionModel().addListSelectionListener(this);
        alta.addActionListener(this);
        baja.addActionListener(this);
    }

    private void configurar() {
        JPanel botones = new JPanel();
        botones.add(alta);
        botones.add(baja);
        this.setLayout(new BorderLayout());
        this.add(scroll, BorderLayout.NORTH);
        this.add(datos, BorderLayout.CENTER);
        this.add(botones, BorderLayout.SOUTH);
    }

    private void instancias() {
        personas = new Personas();
        modeloTabla = new ModeloTabla(personas);
        tabla = new JTable(modeloTabla);
        scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(50, 75));
        alta = new JButton("Dar de alta");
        baja = new JButton("Dar de baja");
        datos = new Datos();
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!tabla.getSelectionModel().isSelectionEmpty()) {
            Persona p = modeloTabla.personaSeleccionada(tabla.getSelectedRow());
            datos.rellenarPersona(p);
        } else {
            tabla.clearSelection();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (datos.comprobarCampos()) {
            Persona p = datos.recogerPersona();

            if (e.getSource() == alta) {
                if (!personas.exists(p)) {
                    personas.addPersona(p);
                    JOptionPane.showMessageDialog(this, p.getId() + " - " + p.getNombre() + " añadido",
                            "Persona Añadida", JOptionPane.INFORMATION_MESSAGE);
                    datos.vaciarCampos();
                    v.actualizar();
                } else {
                    JOptionPane.showMessageDialog(this, "Este ID ya esta asiciado a una persona",
                            "ID existente", JOptionPane.ERROR_MESSAGE);
                }


            } else if (e.getSource() == baja) {
                if (personas.exists(p)) {
                    personas.removePersona(p);
                    JOptionPane.showMessageDialog(this, p.getId() + " - " + p.getNombre() + " borrado",
                            "Persona Borrada", JOptionPane.INFORMATION_MESSAGE);
                    datos.vaciarCampos();
                    v.actualizar();
                } else {
                    JOptionPane.showMessageDialog(this, "Esta persona no existe",
                            "Persona no existente", JOptionPane.ERROR_MESSAGE);
                }
            }


        } else {
            JOptionPane.showMessageDialog(this, "Rellene todos los datos",
                    "Campos vacios", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ModeloTabla getModeloTabla() {
        return modeloTabla;
    }
}
