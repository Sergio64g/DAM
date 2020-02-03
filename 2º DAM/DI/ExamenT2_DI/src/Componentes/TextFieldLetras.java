package Componentes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class TextFieldLetras extends JTextField implements KeyListener {

    public TextFieldLetras() {
    }

    public TextFieldLetras(String text, int columns) {
        super(text, columns);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar())) {
            e.consume();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
