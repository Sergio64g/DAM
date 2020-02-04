import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana ventana = new Ventana();
            }
        });
        /*try {
            Robot robot = new Robot(new Runnable() {
                @Override
                public void run() {
                    robot.keyPress();
                }
            });
        } catch (AWTException e) {
            e.printStackTrace();
        }*/
    }
}
