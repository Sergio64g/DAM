
package Calcu;

import calcu.Calculadora;
import javax.swing.SwingUtilities;

public class Entrada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Calculadora calculadora = new Calculadora();
                calculadora.initGUI();
            }
        });
    }
    
}
