package examen_t2_di;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import utils.Persona;

public class Ventana extends JFrame implements ActionListener, ItemListener {

    Container container;
    JPanel panelSuperior, panelInferior, panelCentral, panelRegistro, panelBuscar;
    JButton btnRegistro, btnBuscar, btnAnadir;
    JLabel nombre, dni, ntDI, ntPMDM, ntPSP, ntAD, buscar, media, aviso;
    JTextField textNombre, textDni;
    SpinnerNumberModel modeloSpinnerDI, modeloSpinnerPMDM, modeloSpinnerPSP, modeloSpinnerAD;
    JSpinner spDI, spPMDM, spPSP, spAD;
    DefaultComboBoxModel modeloCombo;
    JComboBox comboBox;
    CardLayout card;
    ArrayList<Persona> personas;
    ArrayList<String> dnis;

    void initGUI() {
        instancias();
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
        //Paneles
        panelSuperior = new JPanel();
        panelInferior = new JPanel();
        panelCentral = new JPanel();
        panelRegistro = new JPanel();
        panelBuscar = new JPanel();
        //Botones
        btnRegistro = new JButton("Ir a Registro");
        btnRegistro.setActionCommand(Constantes.TAG_REG);
        btnBuscar = new JButton("Ir a Buscar");
        btnBuscar.setActionCommand(Constantes.TAG_BUS);
        btnAnadir = new JButton();
        btnAnadir.setActionCommand(Constantes.TAG_ANA);
        btnAnadir.setIcon(new ImageIcon(getClass().getResource("../recursos/follow.png")));
        btnAnadir.setBackground(null);
        btnAnadir.setBorderPainted(false);
        btnAnadir.setFocusPainted(false);
        //Label
        nombre = new JLabel("Nombre");
        dni = new JLabel("DNI");
        ntDI = new JLabel("Nota DI");
        ntPMDM = new JLabel("Nota PMDM");
        ntPSP = new JLabel("Nota PSP");
        ntAD = new JLabel("Nota AD");
        buscar = new JLabel("Persona a Buscar");
        media = new JLabel("");
        aviso = new JLabel("Introduce todos los datos");

        //TextField
        textNombre = new JTextField(20);
        textDni = new JTextField(20);
        //Spinner
        modeloSpinnerDI = new SpinnerNumberModel(0, 0, 10, 1);
        modeloSpinnerPMDM = new SpinnerNumberModel(0, 0, 10, 1);
        modeloSpinnerPSP = new SpinnerNumberModel(0, 0, 10, 1);
        modeloSpinnerAD = new SpinnerNumberModel(0, 0, 10, 1);

        spDI = new JSpinner(modeloSpinnerDI);
        spPMDM = new JSpinner(modeloSpinnerPMDM);
        spPSP = new JSpinner(modeloSpinnerPSP);
        spAD = new JSpinner(modeloSpinnerAD);
        //ComboBox
        modeloCombo = new DefaultComboBoxModel();
        modeloCombo.addElement("Selecciona una persona");
        comboBox = new JComboBox(modeloCombo);
        //CardLayout
        card = new CardLayout();
        //ArrayList
        personas = new ArrayList();
        dnis = new ArrayList();
    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configurarPanelSuperior(), BorderLayout.NORTH);
        container.add(configurarPanelInferior(), BorderLayout.SOUTH);
        container.add(configurarPanelCentral(), BorderLayout.CENTER);
    }

    public JPanel configurarPanelSuperior() {
        panelSuperior.add(btnRegistro);
        panelSuperior.add(btnBuscar);

        return panelSuperior;

    }

    public JPanel configurarPanelInferior() {
        panelInferior.add(btnAnadir);

        return panelInferior;
    }

    public JPanel configurarPanelCentral() {
        panelCentral.setLayout(card);
        panelCentral.add(configurarPanelRegistro(), Constantes.TAG_P1);
        panelCentral.add(configurarPanelBuscar(), Constantes.TAG_P2);
        card.show(panelCentral, Constantes.TAG_P1);

        return panelCentral;
    }

    public JPanel configurarPanelRegistro() {
        panelRegistro.setLayout(new GridLayout(6, 2, 10, 10));
        panelRegistro.add(nombre);
        panelRegistro.add(textNombre);

        panelRegistro.add(dni);
        panelRegistro.add(textDni);

        panelRegistro.add(ntDI);
        panelRegistro.add(spDI);

        panelRegistro.add(ntPMDM);
        panelRegistro.add(spPMDM);

        panelRegistro.add(ntPSP);
        panelRegistro.add(spPSP);

        panelRegistro.add(ntAD);
        panelRegistro.add(spAD);

        return panelRegistro;
    }

    public JPanel configurarPanelBuscar() {
        panelBuscar.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.5, buscar, panelBuscar, 10, 10, 10, 20);
        configurarConstraints(1, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.5, comboBox, panelBuscar, 10, 10, 10, 20);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0.5, media, panelBuscar, 10, 10, 10, 20);

        return panelBuscar;
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

    private void acciones() {
        btnRegistro.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnAnadir.addActionListener(this);
        textNombre.addKeyListener(new ManejoTeclas());
        textDni.addKeyListener(new ManejoLenght());
        comboBox.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Constantes.TAG_REG:
                btnAnadir.setEnabled(true);
                card.show(panelCentral, Constantes.TAG_P1);
                break;
            case Constantes.TAG_BUS:
                btnAnadir.setEnabled(false);
                card.show(panelCentral, Constantes.TAG_P2);
                break;
            case Constantes.TAG_ANA:
                Persona persona;
                int d,
                 pm,
                 ps,
                 a;
                if (!textNombre.getText().isEmpty() && !textDni.getText().isEmpty()) {
                    d = Integer.valueOf(spDI.getModel().getValue().toString());
                    pm = Integer.valueOf(spPMDM.getModel().getValue().toString());
                    ps = Integer.valueOf(spPSP.getModel().getValue().toString());
                    a = Integer.valueOf(spAD.getModel().getValue().toString());
                    persona = new Persona(textNombre.getText(), textDni.getText(), d, pm, ps, a);
                    if (!dnis.contains(persona.getDni())) {
                        dnis.add(persona.getDni());
                        personas.add(persona);
                        modeloCombo.addElement(persona);

                        textNombre.setText("");
                        textDni.setText("");
                        spDI.setValue(0);
                        spPMDM.setValue(0);
                        spPSP.setValue(0);
                        spAD.setValue(0);

                    } else {
                        System.out.println("DNI repetido");
                    }

                } else {
                    System.out.println("No se introdujeron todos los datos");
                }

                break;

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox) {
            if (comboBox.getModel().getSelectedItem().getClass() == Persona.class) {
                Persona p = (Persona) comboBox.getModel().getSelectedItem();
                media.setText("La media del alumno es " + p.calcularNota());
            } else {
                media.setText("");
            }
        }

    }

    class ManejoTeclas extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            char tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();

            }
        }
    }

    class ManejoLenght extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            if (textDni.getText().length() == 9) {
                e.consume();
            }
        }
    }

}
