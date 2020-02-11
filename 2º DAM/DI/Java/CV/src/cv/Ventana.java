package cv;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Ventana extends JFrame implements ActionListener {

    Container container;
    JPanel panel1, panel2, panel1Superior, panel1Central, panel2Centro, panel2Inferior;
    JLabel titulo, nombre, direccion, telefono, dni, estudios, experiencia, resultados;
    JTextField textNombre, textDireccion, textTelefono, textTelefono2, textDni, textDni2;
    JTextArea textRestultados;
    JScrollPane panelScroll;
    DefaultListModel modeloLista;
    JList listaEstudios, listaEstudios2;
    JRadioButton rbSoltero, rbCasado, rbDivorciado;
    ButtonGroup grupo;
    SpinnerNumberModel modelospinner;
    JSpinner spExperiencia, spExperiencia2;
    JButton btnInsertar, btnSalir, btnSalir2, btnBuscar;
    JTabbedPane panelPestanas;
    ArrayList<Persona> listaPersonas, encontrados;
    final String TAG_INS = "Insertar", TAG_SAL = "Salir", TAG_BUS = "Buscar";

    void initGUI() {
        instancias();
        configurarContainer();
        acciones();
        this.setTitle("CV");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(550, 400));
        this.setLocationRelativeTo(null);
        pack();
        this.setVisible(true);

    }

    private void instancias() {
        //Container
        container = this.getContentPane();
        //JTabbedPane
        panelPestanas = new JTabbedPane(SwingConstants.TOP);
        //JPanel
        panel1 = new JPanel();
        panel1Superior = new JPanel();
        panel1Central = new JPanel();
        panel2 = new JPanel();
        panel2Centro = new JPanel();
        panel2Inferior = new JPanel();
        //JLabel
        titulo = new JLabel("POR FAVOR, RELLENA LOS DATOS DEL CURRICULUM");
        nombre = new JLabel("Nombre");
        direccion = new JLabel("Direccion");
        telefono = new JLabel("Telefono");
        dni = new JLabel("DNI");
        estudios = new JLabel("Selecciona tus estudios");
        experiencia = new JLabel("Años de experiencia");
        resultados = new JLabel("Resultados de busqueda");
        //TextField
        textNombre = new JTextField(20);
        textDireccion = new JTextField(20);
        textTelefono = new JTextField(20);
        textTelefono2 = new JTextField(20);
        textDni = new JTextField(20);
        textDni2 = new JTextField(20);
        //TextArea

        textRestultados = new JTextArea();
        textRestultados.setText("");
        textRestultados.setLineWrap(true);
        textRestultados.setWrapStyleWord(true);
        textRestultados = new JTextArea();
        panelScroll = new JScrollPane(textRestultados);
        //DefaultListModel

        modeloLista = new DefaultListModel();
        //JList
        listaEstudios = new JList<>(modeloLista);
        listaEstudios2 = new JList<>(modeloLista);
        crearLista();
        //JRadioButton
        rbSoltero = new JRadioButton("Soltero");
        rbSoltero.setSelected(true);
        rbCasado = new JRadioButton("Casado");
        rbDivorciado = new JRadioButton("Divorciado");
        //ButtonGroup
        grupo = new ButtonGroup();
        grupo.add(rbSoltero);
        grupo.add(rbCasado);
        grupo.add(rbDivorciado);
        //SpinnerNumberModel
        modelospinner = new SpinnerNumberModel(0, 0, 50, 1);
        //JSpinner
        spExperiencia = new JSpinner(modelospinner);
        spExperiencia2 = new JSpinner(modelospinner);
        //JButton
        btnInsertar = new JButton("Insertar");
        btnInsertar.setActionCommand(TAG_INS);
        btnSalir = new JButton("Salir");
        btnSalir.setActionCommand(TAG_SAL);
        btnSalir2 = new JButton("Salir");
        btnSalir2.setActionCommand(TAG_SAL);
        btnBuscar = new JButton("Buscar");
        btnBuscar.setActionCommand(TAG_BUS);
        //ArrayList
        listaPersonas = new ArrayList();
        encontrados = new ArrayList();
    }

    public void crearLista() {
        modeloLista.addElement("Ingenieria Informática");
        modeloLista.addElement("Ingenieria Industrial");
        modeloLista.addElement("Ingenieria Telecomunicaciones");
        modeloLista.addElement("Arquitectura");
        modeloLista.addElement("Derecho");
    }

    public void configurarContainer() {
        container.add(panelPestanas);
        panelPestanas.addTab("Insertar", configurarPanel1());
        panelPestanas.addTab("Buscar", configurarPanel2());

    }

    public JPanel configurarPanel1() {
        panel1.setLayout(new BorderLayout());
        panel1.add(configurarPanel1Superior(), BorderLayout.NORTH);
        panel1.add(configurarPanel1Central(), BorderLayout.CENTER);
        return panel1;
    }

    public JPanel configurarPanel1Superior() {
        panel1Superior.add(titulo);
        return panel1Superior;
    }

    public JPanel configurarPanel2() {
        panel2.setLayout(new BorderLayout());
        panel2.add(configurarPanel2Inferior(), BorderLayout.SOUTH);
        panel2.add(configurarPanel2Central(), BorderLayout.CENTER);
        return panel2;
    }

    public JPanel configurarPanel2Inferior() {
        panel2Inferior.add(btnBuscar);
        panel2Inferior.add(btnSalir2);
        return panel2Inferior;
    }

    public JPanel configurarPanel2Central() {
        panel2Centro.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, new JLabel("Telefono"), panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, textTelefono2, panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 3, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, new JLabel("DNI"), panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 4, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, textDni2, panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, new JLabel("Años de experiencia"), panel2Centro, 10, 10, 0, 10);
        configurarConstraints(1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, spExperiencia2, panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 6, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, new JLabel("Selecciona tus estudios"), panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 7, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, listaEstudios2, panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 8, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.11, resultados, panel2Centro, 10, 10, 0, 10);
        configurarConstraints(0, 9, 2, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0.20, panelScroll, panel2Centro, 10, 10, 0, 10);

        return panel2Centro;
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

    public JPanel configurarPanel1Central() {
        panel1Central.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, nombre, panel1Central, 10, 10, 0, 10);
        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, textNombre, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, direccion, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, textDireccion, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, telefono, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, textTelefono, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, dni, panel1Central, 0, 10, 10, 10);
        configurarConstraints(0, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, textDni, panel1Central, 0, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, estudios, panel1Central, 0, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, listaEstudios, panel1Central, 0, 10, 10, 10);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, estudios, panel1Central, 10, 0, 10, 10);
        configurarConstraints(1, 1, 1, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, listaEstudios, panel1Central, 0, 0, 10, 10);
        JPanel panelRb = new JPanel();
        panelRb.add(rbSoltero);
        panelRb.add(rbCasado);
        panelRb.add(rbDivorciado);
        configurarConstraints(1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, panelRb, panel1Central, 0, 0, 10, 10);
        JPanel panelYears = new JPanel();
        panelYears.add(experiencia);
        panelYears.add(spExperiencia);
        configurarConstraints(1, 6, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, panelYears, panel1Central, 0, 0, 10, 10);
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar);
        panelBotones.add(btnSalir);
        configurarConstraints(1, 7, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.125, panelBotones, panel1Central, 0, 0, 10, 10);

        return panel1Central;
    }

    public void acciones() {
        btnInsertar.addActionListener(this);
        btnSalir.addActionListener(this);
        btnSalir2.addActionListener(this);
        btnBuscar.addActionListener(this);
        textNombre.addKeyListener(new ManejoLetras());
        textTelefono.addKeyListener(new ManejoDigitos());
        textTelefono2.addKeyListener(new ManejoDigitos2());
        textDni.addKeyListener(new ManejoDni());
        textDni2.addKeyListener(new ManejoDni2());
    }

    public int rbChecker() {
        int i = 0;
        if (rbSoltero.isSelected()) {
            i = 0;
        } else if (rbCasado.isSelected()) {
            i = 1;
        } else if (rbDivorciado.isSelected()) {
            i = 2;
        }
        return i;
    }

    public void limpiarInsertar() {
        textNombre.setText("");
        textDireccion.setText("");
        textDni.setText("");
        textTelefono.setText("");
        listaEstudios.clearSelection();
        spExperiencia.getModel().setValue(0);
        grupo.clearSelection();
        rbSoltero.setSelected(true);
    }

    public ArrayList<Persona> Dni(ArrayList<Persona> personas, ArrayList<Persona> encontrados, String dni) {
        ArrayList<Persona> filtrado = new ArrayList();
        for (Persona item : personas) {
            if (item.getDni().equalsIgnoreCase(dni)) {
                if (!encontrados.contains(item)) {
                    filtrado.add(item);
                }
            }
        }
        return filtrado;
    }

    public ArrayList<Persona> Telefono(ArrayList<Persona> personas, ArrayList<Persona> encontrados, String tlf) {
        ArrayList<Persona> filtrado = new ArrayList();
        for (Persona item : personas) {
            if (item.getTelefono().equalsIgnoreCase(tlf)) {
                if (!encontrados.contains(item)) {
                    filtrado.add(item);
                }
            }
        }
        return filtrado;
    }

    public ArrayList<Persona> Estudios(ArrayList<Persona> personas, ArrayList<Persona> encontrados, String est) {
        ArrayList<Persona> filtrado = new ArrayList();
        for (Persona item : personas) {
            if (item.getEstudios().equalsIgnoreCase(est)) {
                if (!encontrados.contains(item)) {
                    filtrado.add(item);
                }
            }
        }
        return filtrado;
    }

    public ArrayList<Persona> Experiencia(ArrayList<Persona> personas, ArrayList<Persona> encontrados, int exp) {
        ArrayList<Persona> filtrado = new ArrayList();
        for (Persona item : personas) {
            if (item.getExperiencia() == exp) {
                if (!encontrados.contains(item)) {
                    filtrado.add(item);
                }
            }
        }
        return filtrado;
    }

    public void limpiarBuscar() {
        textDni2.setText("");
        textTelefono2.setText("");
        listaEstudios2.clearSelection();
        textRestultados.setText("");
        grupo.clearSelection();
        encontrados.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case TAG_INS:
                Persona p;

                if (!textNombre.getText().isEmpty() || !textDireccion.getText().isEmpty()
                        || !textDni.getText().isEmpty() || !textTelefono.getText().isEmpty()) {
                    if (!listaEstudios.isSelectionEmpty()) {
                        p = new Persona(textNombre.getText(), textDireccion.getText(), textTelefono.getText(),
                                textDni.getText(), (String) modeloLista.getElementAt(listaEstudios.getSelectedIndex()),
                                rbChecker(), (int) spExperiencia.getModel().getValue());
                        listaPersonas.add(p);
                        limpiarInsertar();

                    } else {
                        System.out.println("Elige un estudio");
                    }

                } else {
                    System.out.println("Introduce bien los campos");
                }

                break;
            case TAG_SAL:
                System.exit(0);
                break;
            case TAG_BUS:

                if (!textDni2.getText().isEmpty()) {
                    for (Persona item : Dni(listaPersonas, encontrados, textDni2.getText())) {
                        encontrados.add(item);
                    }
                }
                if (!textTelefono2.getText().isEmpty()) {
                    for (Persona item : Telefono(listaPersonas, encontrados, textTelefono2.getText())) {
                        encontrados.add(item);
                    }
                }
                if (!listaEstudios2.isSelectionEmpty()) {
                    for (Persona item : Estudios(listaPersonas, encontrados, (String) modeloLista.getElementAt(listaEstudios2.getSelectedIndex()))) {
                        encontrados.add(item);
                    }
                }
                for (Persona item : Experiencia(listaPersonas, encontrados, (int) spExperiencia2.getModel().getValue())) {
                    encontrados.add(item);
                }
if (!encontrados.isEmpty()){
                for (Persona item : encontrados) {
                    System.out.println(item);
                    textRestultados.append("\n" + item.toString());
                }
                limpiarBuscar();
} else {
    System.out.println("No se ha registrado");
}
                break;
        }
    }

    class ManejoDigitos extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            Character tecla = e.getKeyChar();
            if (!Character.isDigit(tecla) || textTelefono.getText().length() > 9) {
                e.consume();
            }
        }
    }

    class ManejoDigitos2 extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            Character tecla = e.getKeyChar();
            if (!Character.isDigit(tecla) || textTelefono2.getText().length() > 9) {
                e.consume();
            }
        }
    }

    class ManejoLetras extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            Character tecla = e.getKeyChar();
            if (Character.isDigit(tecla)) {
                e.consume();
            }
        }
    }

    class ManejoDni extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            if (textDni.getText().length() > 9) {
                e.consume();
            }
        }
    }

    class ManejoDni2 extends KeyAdapter {

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            if (textDni2.getText().length() > 9) {
                e.consume();
            }
        }
    }
}
