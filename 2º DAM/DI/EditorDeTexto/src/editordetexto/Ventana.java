package editordetexto;

import Componentes.PopUp;
import Paneles.Herramientas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    Container container;
    JTextArea texto;
    JMenuBar barra;
    JMenu archivo, edicion, estilo;
    JMenuItem nuevo, abrir, cerrar, guardar, guardarComo, imprimir;
    JMenuItem copiar, pegar, cortar, normal, bold, cursiva;
    Herramientas herramientas;
    JFileChooser chooser;
    PopUp popUp;
    File text;
    Clipboard c;
    Transferable t;
    JScrollPane scroll, scrollLista;
    JList ruta;
    DefaultListModel modeloLista;

    public Ventana() {
        initGUI();
    }

    private void initGUI() {

        instancias();
        configurarContainer();
        configurarMenu();
        acciones();

        this.setSize(new Dimension(600, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setResizable(true);
        this.setVisible(true);
        this.pack();
    }

    private void instancias() {
        //Container
        container = this.getContentPane();
        //Paneles
        herramientas = new Herramientas(this);
        //JMenuBar
        barra = new JMenuBar();
        //JMenu
        archivo = new JMenu("Archivo");
        edicion = new JMenu("Edicion");
        estilo = new JMenu("Estilo");
        //JMenuItem
        nuevo = new JMenuItem("Nuevo", new ImageIcon("src/editordetexto/Icons/new.png"));
        abrir = new JMenuItem("Abrir..", new ImageIcon("src/editordetexto/Icons/open.png"));
        cerrar = new JMenuItem("Cerrar", new ImageIcon("src/editordetexto/Icons/close.png"));
        guardar = new JMenuItem("Guardar", new ImageIcon("src/editordetexto/Icons/save.png"));
        guardarComo = new JMenuItem("Guardar Como..", new ImageIcon("src/editordetexto/Icons/SaveAs.png"));
        imprimir = new JMenuItem("Imprimir", new ImageIcon("src/editordetexto/Icons/imprimir.png"));

        copiar = new JMenuItem("Copiar", new ImageIcon("src/editordetexto/Icons/copy.png"));
        pegar = new JMenuItem("Pegar", new ImageIcon("src/editordetexto/Icons/paste.png"));
        cortar = new JMenuItem("Cortar", new ImageIcon("src/editordetexto/Icons/cut.png"));
        normal = new JMenuItem("Normal", new ImageIcon("src/editordetexto/Icons/normal.png"));
        bold = new JMenuItem("Bold", new ImageIcon("src/editordetexto/Icons/bold.png"));
        cursiva = new JMenuItem("Cursiva", new ImageIcon("src/editordetexto/Icons/italic.png"));
        //JTextArea
        texto = new JTextArea(20, 60);
        //DefaultListModel
        modeloLista = new DefaultListModel();
        //JList
        ruta = new JList(modeloLista);
        ruta.setBorder(new BevelBorder(BevelBorder.LOWERED));

        //JPopupMenu
        popUp = new PopUp(this);
        //JFileChooser
        chooser = new JFileChooser();
        //Clipboard
        c = Toolkit.getDefaultToolkit().getSystemClipboard();
        //Transferable 
        t = c.getContents(this);
        //JScrollPane
        scroll = new JScrollPane(texto);
        scrollLista = new JScrollPane(ruta);
    }

    private void configurarContainer() {
        this.setLayout(new BorderLayout());
        this.add(herramientas, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.WEST);
        this.add(scrollLista, BorderLayout.EAST);
    }

    private void acciones() {
        texto.addMouseListener(new MenuMouse());
        nuevo.addActionListener(this);
        abrir.addActionListener(this);
        cerrar.addActionListener(this);
        guardar.addActionListener(this);
        guardarComo.addActionListener(this);
        imprimir.addActionListener(this);
        copiar.addActionListener(this);
        cortar.addActionListener(this);
        pegar.addActionListener(this);
        bold.addActionListener(this);
        normal.addActionListener(this);
        cursiva.addActionListener(this);

        ruta.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (ruta.getValueIsAdjusting()) {
                    ArrayList<String> document = new ArrayList<>();
                    texto.setText(null);
                    try {
                        document = Leer_mismoDir((String) ruta.getSelectedValue());
                        for (String st : document) {
                            texto.append(st + "\n");
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

    }

    public ArrayList<String> Leer_mismoDir(String fichero) throws IOException {
        ArrayList<String> datos = new ArrayList<>();
        String cadena;

        FileReader f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            datos.add(cadena);
        }
        b.close();
        return datos;
    }

    private void configurarMenu() {

        barra.add(archivo);
        archivo.add(nuevo);
        archivo.add(abrir);
        archivo.add(cerrar);
        archivo.add(guardar);
        archivo.add(guardarComo);
        archivo.addSeparator();
        archivo.add(imprimir);

        barra.add(edicion);
        edicion.add(copiar);
        edicion.add(pegar);
        edicion.add(cortar);

        edicion.add(estilo);
        estilo.add(normal);
        estilo.add(bold);
        estilo.add(cursiva);

        this.setJMenuBar(barra);
    }

    public void fileChooser() {
        //Le indicamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        chooser.setFileFilter(filtro);

        int seleccion = chooser.showOpenDialog(container);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            //Seleccionamos el fichero
            text = chooser.getSelectedFile();
            File fichero = chooser.getSelectedFile();

            modeloLista.addElement(fichero.getAbsolutePath());

            /*String[] ficheros = fichero.getParentFile().list();
            for (String item : ficheros) {
                String[] parts = item.split("\\.");
                if (parts.length == 2 && parts[1].equalsIgnoreCase("txt")) {
                    modeloLista.addElement(item);
                }

            }*/
            try (FileReader fr = new FileReader(fichero)) {
                String cadena = "";
                int valor = fr.read();
                while (valor != -1) {
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
                texto.setText(cadena);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevo) {
            nuevo();
        } else if (e.getSource() == abrir) {
            fileChooser();
        } else if (e.getSource() == copiar) {
            copiar();
        } else if (e.getSource() == cerrar) {
            System.exit(0);
        } else if (e.getSource() == cortar) {
            cortar();
        } else if (e.getSource() == pegar) {
            pegar();
        } else if (e.getSource() == bold) {
            negrita();
        } else if (e.getSource() == normal) {
            plane();
        } else if (e.getSource() == cursiva) {
            cursiva();
        } else if (e.getSource() == guardar) {
            guardar();
        } else if (e.getSource() == guardarComo) {
            guardarComo();
        }


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

    public void guardar() {
        try {
            String ruta = "src/Documents/Guardado.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto.getText());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void guardarComo() {
        String ruta = null;

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Guardar Como");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
           ruta = chooser.getSelectedFile().toString();
            System.out.println(ruta);
        } else {
            System.out.println("No Selection ");
        }
        try {
            ruta = ruta +"\\Guardado.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto.getText());
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class MenuMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                popUp.show(container, e.getX(), e.getY());
            }
        }

    }

    public void nuevo() {
        texto.setText("");
    }

    public void copiar() {
        String s = texto.getSelectedText();
        StringSelection ss = new StringSelection(s);
        c.setContents(ss, ss);
    }

    public void cortar() {
        String s = texto.getSelectedText();
        StringSelection ss = new StringSelection(s);
        c.setContents(ss, ss);
        texto.replaceSelection("");
    }

    public void pegar() {
        try {
            DataFlavor dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");

            if (t.isDataFlavorSupported(dataFlavorStringJava)) {
                String str = (String) t.getTransferData(dataFlavorStringJava);
                //TODO
                texto.replaceSelection(str);
            }
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR");
        } catch (UnsupportedFlavorException ex) {
            System.err.println("ERROR");
        } catch (IOException ex) {
            System.err.println("ERROR");
        }
    }

    public void negrita() {

        Font f = texto.getFont();

        if (texto.getFont().getStyle() == Font.BOLD) {
            texto.setFont(new Font(f.getName(), Font.PLAIN, f.getSize()));
        } else {
            texto.setFont(new Font(f.getName(), Font.BOLD, f.getSize()));
        }
    }

    public void plane() {

        Font f = texto.getFont();

        texto.setFont(new Font(f.getName(), Font.PLAIN, f.getSize()));

    }

    public void cursiva() {

        Font f = texto.getFont();

        if (texto.getFont().getStyle() == Font.BOLD) {
            texto.setFont(new Font(f.getName(), Font.PLAIN, f.getSize()));
        } else {
            texto.setFont(new Font(f.getName(), Font.ITALIC, f.getSize()));
        }
    }

    public JTextArea getTexto() {
        return texto;
    }

}
