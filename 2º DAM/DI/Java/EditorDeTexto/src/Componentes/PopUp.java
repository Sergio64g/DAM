package Componentes;

import editordetexto.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopUp extends JPopupMenu implements ActionListener {

    JPopupMenu menu;
    JMenu submenu;
    JMenuItem nuevo, abrir, cerrar, guardar, guardarComo, imprimir;
    JMenuItem copiar, pegar, cortar, normal, bold, cursiva;
    Ventana v;

    public PopUp(Ventana v) {
        this.v = v;
        this.setLabel("Menu contextual");
        instancias();
        añadir();
        acciones();
        this.setBorderPainted(true);
    }

    public PopUp(String label) {
        super(label);
    }

    @Override
    public void show() {
        super.show(); //To change body of generated methods, choose Tools | Templates.
    }

    private void añadir() {
        this.add(guardar);
        this.add(guardarComo);
        this.add(copiar);
        this.add(pegar);
        this.add(cortar);
        this.add(cerrar);
        
        submenu.add(normal);
        submenu.add(bold);
        submenu.add(cursiva);
        this.add(submenu);
    }

    private void instancias() {
        nuevo = new JMenuItem("Nuevo", new ImageIcon("src/editordetexto/Icons/new.png"));
        abrir = new JMenuItem("Abrir..", new ImageIcon("src/editordetexto/Icons/open.png"));
        cerrar = new JMenuItem("Cerrar", new ImageIcon("src/editordetexto/Icons/close.png"));
        guardar = new JMenuItem("Guardar", new ImageIcon("src/editordetexto/Icons/save.png"));
        guardarComo = new JMenuItem("Guardar Como..",new ImageIcon("src/editordetexto/Icons/SaveAs.png"));
        imprimir = new JMenuItem("Imprimir", new ImageIcon("src/editordetexto/Icons/imprimir.png"));

        copiar = new JMenuItem("Copiar", new ImageIcon("src/editordetexto/Icons/copy.png"));
        pegar = new JMenuItem("Pegar", new ImageIcon("src/editordetexto/Icons/paste.png"));
        cortar = new JMenuItem("Cortar", new ImageIcon("src/editordetexto/Icons/cut.png"));
        normal = new JMenuItem("Normal", new ImageIcon("src/editordetexto/Icons/normal.png"));
        bold = new JMenuItem("Bold", new ImageIcon("src/editordetexto/Icons/bold.png"));
        cursiva = new JMenuItem("Cursiva", new ImageIcon("src/editordetexto/Icons/italic.png"));
        submenu = new JMenu("Estilos");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copiar) {
            v.copiar();
        } else if (e.getSource() == pegar) {
            v.pegar();
        } else if (e.getSource() == cortar) {
            v.cortar();
        } else if (e.getSource() == normal) {
            v.plane();
        } else if (e.getSource() == bold) {
            v.negrita();
        } else if (e.getSource() == cursiva) {
            v.cursiva();
        } else if (e.getSource() == guardar) {
            v.guardar();
        } else if (e.getSource() == guardarComo) {
            v.guardarComo();
        }
         else if (e.getSource() == cerrar) {
            System.exit(0);
        }
    }

    private void acciones() {
        copiar.addActionListener(this);
        pegar.addActionListener(this);
        cortar.addActionListener(this);
        normal.addActionListener(this);
        bold.addActionListener(this);
        cursiva.addActionListener(this);
        guardar.addActionListener(this);
        guardarComo.addActionListener(this);
        cerrar.addActionListener(this);
    }

}
