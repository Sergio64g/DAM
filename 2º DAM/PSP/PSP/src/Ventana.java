import Paneles.PanelPrincipal;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    PanelPrincipal panelPrincipal;
    Container container;

    public Ventana() {
        initGUI();

        this.setVisible(true);
        this.setTitle("PSP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);

    }

    private void initGUI() {
        instancias();
        configurar();
        this.add(panelPrincipal);
    }

    private void configurar() {
      container.add(panelPrincipal);
      container.setBackground(Color.BLACK);
    }

    private void instancias() {
        container = this.getContentPane();
        panelPrincipal = new PanelPrincipal();
    }


}
