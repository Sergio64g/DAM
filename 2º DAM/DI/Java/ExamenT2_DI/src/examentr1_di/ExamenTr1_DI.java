package examentr1_di;

import javax.swing.SwingUtilities;

public class ExamenTr1_DI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana ventanaPrincipal = new Ventana();
                ventanaPrincipal.initGUI();
            }
        });
    }

}
