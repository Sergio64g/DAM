package Paneles;

import Utils.Personas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    JTabbedPane tabbedPane;
    PanelAltas panelAltas;
    PanelBajas panelBajas;
    PanelModificaciones panelModificaciones;
    PanelResumen panelResumen;
    Personas personas;


    public Ventana() {
        initGUI();
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        this.setTitle("Tablas");
    }

    private void initGUI() {
        instancias();
        configurar();
    }

    private void configurar() {
        this.add(tabbedPane);
        tabbedPane.addTab("Altas", panelAltas);
        tabbedPane.addTab("Bajas", panelBajas);
        tabbedPane.addTab("Modificaciones", panelModificaciones);
        tabbedPane.addTab("Resumen", panelResumen);
    }

    private void instancias() {
        tabbedPane = new JTabbedPane();
        personas = new Personas();
        panelBajas = new PanelBajas(this);
        panelModificaciones = new PanelModificaciones(this);
        panelAltas = new PanelAltas(this);
        panelResumen = new PanelResumen(this);
    }

    public void actualizar() {
        panelBajas.getClave().modelo();
        panelModificaciones.getSeleccionClave().modelo();
        panelResumen.getModeloTabla().fireTableDataChanged();
    }
}
