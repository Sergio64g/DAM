package cv;

import javax.swing.SwingUtilities;

public class CV {

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
