package Paneles;

import Threads.RobotThread;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class PanelPrincipal extends JPanel implements ActionListener {

    JLabel titulo;
    JButton btnChooser, servidor, compilar;
    JTextArea output;
    JScrollPane scrollPane;
    JFileChooser fileChooser;

    public PanelPrincipal() {

        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        acciones();
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


    private void configurarPanel() {
        this.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                1, 0.25, titulo, this, 10, 10, 10, 10);
        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                0.5, 0.25, btnChooser, this, 10, 10, 10, 10);
        configurarConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                0.5, 0.25, servidor, this, 10, 10, 10, 10);
        configurarConstraints(0, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                1, 0.25, compilar, this, 10, 10, 10, 10);
        configurarConstraints(0, 3, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                1, 0.25, scrollPane, this, 10, 10, 10, 10);

    }

    private void instancias() {
        titulo = new JLabel("Compilador(Java)", SwingConstants.CENTER);
        titulo.setFont(new Font("Times new Roman", Font.PLAIN, 20));
        btnChooser = new JButton("Elegir archivo");
        compilar = new JButton("Compilar");
        servidor = new JButton("Código del servidor");
        output = new JTextArea();
        scrollPane = new JScrollPane(output);
        output.setLineWrap(true);
        scrollPane.setPreferredSize(new Dimension(100, 100));
    }

    public void fileChooser() {
        try {
            String ruta = null;
            String cadena, codigo = "";

            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new java.io.File("."));

            //
            // disable the "All files" option.
            //


            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                BufferedReader b = null;
                b = new BufferedReader(new FileReader(f));
                while ((cadena = b.readLine()) != null) {
                    codigo = codigo + cadena;
                }
                System.out.println(codigo);
                output.setText(codigo);


                ruta = ruta + "\\Guardado.txt";
                File file = new File("C:\\Users\\sergi\\Desktop\\Proyectos\\IdeaProjects\\PSP\\src\\Documentos\\Ejecutar.txt");
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(codigo);
                bw.close();
            } else {
                System.out.println("No Selection ");
            }
        } catch (Exception e) {
            System.err.println("Error");
        }

    }

    private void acciones() {
btnChooser.addActionListener(this);
compilar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnChooser) {
            fileChooser();
        } else if(actionEvent.getSource() == compilar){
            try {
                RobotThread robotThread = new RobotThread();
                robotThread.compilar();

            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
}