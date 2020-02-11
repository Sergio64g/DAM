package Paneles;

import editordetexto.Ventana;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Herramientas extends JPanel implements ActionListener, ItemListener, ChangeListener {

    JToolBar toolBar;
    JButton nuevo, abrir, guardar, imprimir, copiar, cortar, pegar, bold;
    SpinnerNumberModel modelo;
    JSpinner letra;
    DefaultComboBoxModel modeloCombo;
    JComboBox<Object> tipo;
    Ventana v;

    public Herramientas(Ventana v) {
        initGUI();
        this.v = v;
    }

    private void initGUI() {
        instancias();
        configurarPanel();
        configurarToolBar();
        rellenarLetras();
        acciones();
    }

    private void instancias() {
        toolBar = new JToolBar("Barra de herramientas", JToolBar.HORIZONTAL);
        toolBar.setBorderPainted(true);
        //JButton
        nuevo = new JButton(new ImageIcon("src/editordetexto/Icons/new.png"));
        nuevo.setToolTipText("Nuevo");
        abrir = new JButton(new ImageIcon("src/editordetexto/Icons/open.png"));
        abrir.setToolTipText("Abrir");
        guardar = new JButton(new ImageIcon("src/editordetexto/Icons/save.png"));
        guardar.setToolTipText("Guardar");
        imprimir = new JButton(new ImageIcon("src/editordetexto/Icons/imprimir.png"));
        imprimir.setToolTipText("Imprimir");
        copiar = new JButton(new ImageIcon("src/editordetexto/Icons/copy.png"));
        copiar.setToolTipText("Copiar");
        cortar = new JButton(new ImageIcon("src/editordetexto/Icons/cut.png"));
        cortar.setToolTipText("Cortar");
        pegar = new JButton(new ImageIcon("src/editordetexto/Icons/paste.png"));
        pegar.setToolTipText("Pegar");
        bold = new JButton(new ImageIcon("src/editordetexto/Icons/bold.png"));
        bold.setToolTipText("Negrita");
        //SpinnerNumberModel
        modelo = new SpinnerNumberModel(12, 1, 100, 1);
        //JSpinner
        letra = new JSpinner(modelo);
        //DefaultComboBoxModel
        modeloCombo = new DefaultComboBoxModel();
        //JComboBox
        tipo = new JComboBox<>(modeloCombo);
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();

        for (Font item : fuentes) {

            modeloCombo.addElement(item.getName());
        }

    }

    private void configurarPanel() {
        this.add(toolBar);
    }

    private void configurarToolBar() {
        toolBar.add(nuevo);
        toolBar.add(abrir);
        toolBar.add(guardar);
        toolBar.add(imprimir);
        toolBar.add(copiar);
        toolBar.add(cortar);
        toolBar.add(pegar);
        toolBar.add(bold);
        toolBar.add(new JLabel("Tamaño de Letra"));
        toolBar.add(letra);
        toolBar.add(new JLabel("Tipo de letra"));
        toolBar.add(tipo);

    }

    public JButton getNuevo() {
        return nuevo;
    }

    public JButton getAbrir() {
        return abrir;
    }

    public JButton getGuardar() {
        return guardar;
    }

    public JButton getImprimir() {
        return imprimir;
    }

    public JButton getCopiar() {
        return copiar;
    }

    public JButton getCortar() {
        return cortar;
    }

    public JButton getPegar() {
        return pegar;
    }

    public JButton getBold() {
        return bold;
    }

    public SpinnerNumberModel getModelo() {
        return modelo;
    }

    public DefaultComboBoxModel<Object> getModeloCombo() {
        return modeloCombo;
    }

    public JComboBox<Object> getTipo() {
        return tipo;
    }

    private void acciones() {
        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        guardar.addActionListener(this);
        imprimir.addActionListener(this);
        copiar.addActionListener(this);
        cortar.addActionListener(this);
        pegar.addActionListener(this);
        bold.addActionListener(this);
        tipo.addItemListener(this);
        letra.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevo) {
            v.nuevo();
        } else if (e.getSource() == abrir) {
            v.fileChooser();
        } else if (e.getSource() == copiar) {
            v.copiar();
        } else if (e.getSource() == cortar) {
            v.cortar();
        } else if (e.getSource() == pegar) {
            v.pegar();
        } else if (e.getSource() == bold) {
            v.negrita();
        } else if (e.getSource() == guardar) {
            v.guardar();
            /*Writer writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("filename.txt"), "utf-8"));
                writer.write(v.getTexto().getText());
            } catch (IOException ex) {
                System.err.println("ERROR");
            } finally {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }*/
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tipo) {
            Font f = v.getTexto().getFont();

            v.getTexto().setFont(new Font((String) modeloCombo.getElementAt(tipo.getSelectedIndex()), f.getStyle(), f.getSize()));

        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == letra) {
            Font f = v.getTexto().getFont();

            v.getTexto().setFont(new Font(f.getName(), f.getStyle(), Integer.valueOf(letra.getModel().getValue().toString())));

        }

    }
}
