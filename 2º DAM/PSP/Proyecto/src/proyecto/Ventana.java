/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    Container contentPane;
    JTextField textField;
    JTextArea textArea, output;
    JButton btnSeleccionar, btnTxtAd, btnElegir, btnCompilar;
    JScrollPane scroll, scrollOut;
    JFileChooser fc;
    File programa;
    JLabel titulo1, titulo2, jC, ruta;
    JPanel panelSeleccionar, panelSel1, panelSel2, panelSel3, panelMenu, panelMenu1, panelMenu2;
    JRadioButton r1, r2;
    ButtonGroup grupoRadios;
    CardLayout card;
    Thread1 hilo;
    Cliente cliente;

    void initGUI() {
        instancias();
        acciones();
        configurarContainer();

        this.setVisible(true);
        this.setTitle("PSP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

    }

    private void instancias() {
        card = new CardLayout();
        contentPane = this.getContentPane();
        panelSeleccionar = new JPanel();
        panelSel1 = new JPanel();
        panelSel2 = new JPanel();
        panelSel3 = new JPanel();
        panelMenu = new JPanel();
        panelMenu1 = new JPanel();
        panelMenu2 = new JPanel();

        r1 = new JRadioButton("Java", false);
        r2 = new JRadioButton("C", false);
        grupoRadios = new ButtonGroup();
        grupoRadios.add(r1);
        grupoRadios.add(r2);

        btnSeleccionar = new JButton("Seleccionar...");
        btnSeleccionar.setActionCommand("BTN");
        btnTxtAd = new JButton("Guardar");
        btnTxtAd.setActionCommand("TXT");
        btnElegir = new JButton("Elegir archivo");
        btnElegir.setActionCommand("elegir");
        btnCompilar = new JButton("Compilar");
        btnCompilar.setActionCommand("compilar");

        titulo1 = new JLabel("Compilador Java/C");
        titulo2 = new JLabel("Seleccionar archivo(.txt)");
        jC = new JLabel("Eliga el lenguaje");
        ruta = new JLabel();
        ruta.setPreferredSize(new Dimension(10, 20));
        textArea = new JTextArea(10, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        output = new JTextArea(10, 10);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setPreferredSize(new Dimension(100, 60));

        scroll = new JScrollPane(textArea);
        scrollOut = new JScrollPane(output);
        fc = new JFileChooser();
        textField = new JTextField(10);
        textField.setToolTipText("Inserta la ruta del fichero de audio");

        hilo = new Thread1();
        cliente = new Cliente();

    }

    public JPanel configurarPanelMenu() {
        panelMenu.setLayout(new BorderLayout());
        panelMenu.add(configurarMenuSup(), BorderLayout.NORTH);
        panelMenu.add(configurarMenuCentral(), BorderLayout.CENTER);
        return panelMenu;

    }

    public JPanel configurarMenuSup() {
        panelMenu1.add(titulo1);
        return panelMenu1;
    }

    public JPanel configurarMenuCentral() {
        panelMenu2.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.3, 0.2, jC, panelMenu2, 10, 10, 10, 20);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.3, 0.2, r1, panelMenu2, 10, 10, 10, 20);
        configurarConstraints(2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.3, 0.2, r2, panelMenu2, 10, 10, 10, 20);
        configurarConstraints(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.2, btnElegir, panelMenu2, 10, 10, 10, 20);
        configurarConstraints(1, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.2, ruta, panelMenu2, 10, 10, 10, 20);
        configurarConstraints(0, 2, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0.2, btnCompilar, panelMenu2, 10, 10, 10, 20);

        configurarConstraints(0, 3, 3, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0.2, output, panelMenu2, 10, 10, 10, 20);

        return panelMenu2;
    }

    private void acciones() {
        btnSeleccionar.addActionListener(this);
        btnTxtAd.addActionListener(this);
        btnElegir.addActionListener(this);
        btnCompilar.addActionListener(this);

    }

    public JPanel configurarPanelSel1() {
        panelSel1.add(titulo2);

        return panelSel1;
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

    public JPanel configurarPanelSel2() {
        panelSel2.setLayout(new GridBagLayout());
        configurarConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.4, textField, panelSel2, 10, 10, 10, 20);
        configurarConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0.5, 0.4, btnSeleccionar, panelSel2, 10, 10, 10, 20);
        configurarConstraints(0, 1, 2, 3, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 1, 0.6, scroll, panelSel2, 10, 10, 10, 20);

        return panelSel2;
    }

    public JPanel configurarPanelSel3() {
        panelSel3.add(btnTxtAd);

        return panelSel3;
    }

    public JPanel configurarPanelSeleccionar() {
        panelSeleccionar.setLayout(new BorderLayout());
        panelSeleccionar.add(configurarPanelSel1(), BorderLayout.NORTH);
        panelSeleccionar.add(configurarPanelSel2(), BorderLayout.CENTER);
        panelSeleccionar.add(configurarPanelSel3(), BorderLayout.SOUTH);

        return panelSeleccionar;
    }

    public void configurarContainer() {
        contentPane.setLayout(card);
        setContentPane(contentPane);

        contentPane.add(configurarPanelMenu(), 0);
        contentPane.add(configurarPanelSeleccionar(), 1);

    }

    public void fileChooser() {
        //Le indicamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fc.setFileFilter(filtro);

        int seleccion = fc.showOpenDialog(contentPane);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Seleccionamos el fichero
            programa = fc.getSelectedFile();
            File fichero = fc.getSelectedFile();

            textField.setText(fichero.getAbsolutePath());

            try (FileReader fr = new FileReader(fichero)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
                textArea.setText(cadena);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "BTN":
                fileChooser();
                break;
            case "TXT":
                card.next(contentPane);
                if (!textField.getText().isEmpty()) {
                    ruta.setText(programa.getAbsolutePath());
                }
                break;
            case "elegir":
                card.next(contentPane);
                break;
            case "compilar":
                if (r1.isSelected()) {
                    programa = new File("Ejecutar.java");
                    try {
                        //Hacer en un thread  waitFor()

                        hilo.start();
                        hilo.sleep(2000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    /*   Runtime runtime = Runtime.getRuntime();
                ProcessBuilder p = new ProcessBuilder("cmd", "/c", "javac Ejecutar.java");
                
                try {
                Process process = runtime.exec("javac Ejecutar.java");
                
                process.getOutputStream().close();
                String line;
                BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((line = stdout.readLine()) != null) {
                System.out.println(line);
                }
                
                Process process2 = runtime.exec("jar cf Ejecutar Ejecutar.class");
                
                process2.getOutputStream().close();
                String line2;
                BufferedReader stdout2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
                while ((line2 = stdout2.readLine()) != null) {
                System.out.println(line2);
                }
                
                Process process3 = runtime.exec("java Ejecutar");
                ArrayList<String> codigo = new ArrayList();
                process3.getOutputStream().close();
                String line3;
                BufferedReader stdout3 = new BufferedReader(new InputStreamReader(process3.getInputStream()));
                while ((line3 = stdout3.readLine()) != null) {
                }
                
                } catch (IOException ex) {
                System.err.println("Error");
                }*/
                } else if (r2.isSelected()) {

                    FileReader f = null;
                    String cadena, codigo = "";
                    try {
                        //Recoge el contenido del txt y lo guarda en la variable codigo

                        f = new FileReader(programa);
                        BufferedReader b = new BufferedReader(f);
                        while ((cadena = b.readLine()) != null) {
                            codigo = codigo + cadena;
                        }
                        System.out.println(codigo);
                        output.setText(codigo);
                        b.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            f.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    String command2 = "> hola.c bash -c \"iconv hola.c -f UTF-16 -t UTF-8 > holas.c\" wsl gcc holas.c wsl \"./a.out\"";
                    String command = codigo + "" + command2;

                    try {

                        Process powerShellProcess = Runtime.getRuntime().exec(command);
                        powerShellProcess.getOutputStream().close();
                    } catch (IOException ex) {
                    }
                    /*$codigo = '#include <stdio.h>
                        int main()
                        {
                        printf(\"Hola Mundo.\\n\");
                        return 0;
                        }'
                        
                        wsl echo $codigo > hola.c
                        bash -c "iconv hola.c -f UTF-16 -t UTF-8 > holas.c"
                        wsl gcc holas.c
                        wsl "./a.out"
                        
                        
                        FileReader f = null;
                        try {
                        //Recoge el contenido del txt y lo guarda en la variable codigo
                        String cadena, codigo = "";
                        f = new FileReader(programa);
                        BufferedReader b = new BufferedReader(f);
                        while ((cadena = b.readLine()) != null) {
                        codigo = codigo + cadena;
                        }
                        System.out.println(codigo);
                        output.setText(codigo);
                        b.close();
                        } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                        } catch (IOException ex) {
                        ex.printStackTrace();
                        } finally {
                        try {
                        f.close();
                        } catch (IOException ex) {
                        ex.printStackTrace();
                        }
                        }*/

                }
                File res = new File("src\\Documentos\\res.txt");
                FileReader f = null;
                String cadena,
                 codigo = "";
                try {
                    //Recoge el contenido del txt y lo guarda en la variable codigo

                    f = new FileReader(res);
                    BufferedReader b = new BufferedReader(f);
                    while ((cadena = b.readLine()) != null) {
                        codigo = codigo + cadena;
                    }
                    output.setText(codigo);
                    b.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        f.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cliente.start();
                break;
        }

    }

}
