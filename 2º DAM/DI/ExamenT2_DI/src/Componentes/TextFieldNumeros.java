package Componentes;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class TextFieldNumeros extends JTextField implements KeyListener {

    String hint;

    public TextFieldNumeros() {
    }

    public TextFieldNumeros(String text, int columns) {
        super(text, columns);
        this.hint = text;
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!Character.isDigit(e.getKeyChar())) {
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
