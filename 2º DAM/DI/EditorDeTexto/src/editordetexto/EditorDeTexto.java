
package editordetexto;

import javax.swing.SwingUtilities;


public class EditorDeTexto {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
           Ventana v = new Ventana();
            }
        });
    }
    
}
