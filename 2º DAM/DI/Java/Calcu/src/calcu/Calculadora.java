package calcu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    //Botones
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot;
    JButton btnSuma, btnResta, btnDivision, btnMultiplicacion, btnEqual;
    JButton btnAC, btnMasMenos, btnPercent;
    JButton btnNormal, btnCompleja;
    //Container
    Container container;
    //Paneles
    JPanel panelSuperior, panelInferior, PanelCentral, panelDerecho;
    JPanel panelCentralUno, panelCentralDos;

    JButton b1, b2, b3, b4, bSuma, bResta, bIgual;
    JTextField pantalla;
    JPanel superior, central, centralCientifica;
    boolean operando = false;
    int op1, op2;
    int tipoOperacion;

    public void initGUI() {

        instancias();
        configurarContainer();
        setSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        acciones();
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configurarSuperior(), BorderLayout.NORTH);
        container.add(configurarInferior(), BorderLayout.SOUTH);
        container.add(configurarCentro2(), BorderLayout.CENTER);
    }

    public JPanel configurarCentro2() {
        PanelCentral.add(configurarCentralUno());
        PanelCentral.add(configurarCentralDos());
        return PanelCentral;
    }

    public JPanel configurarCentralUno() {

        panelCentralUno.setLayout(new GridLayout(5, 3));
        panelCentralUno.add(btnAC);
        panelCentralUno.add(btnMasMenos);
        panelCentralUno.add(btnPercent);
        //-----------------------------------

        panelCentralUno.add(btn7);
        panelCentralUno.add(btn8);
        panelCentralUno.add(btn9);
        //-----------------------------------

        panelCentralUno.add(btn4);
        panelCentralUno.add(btn5);
        panelCentralUno.add(btn6);
        //-----------------------------------

        panelCentralUno.add(btn1);
        panelCentralUno.add(btn2);
        panelCentralUno.add(btn3);
        //----------------------------------------
        panelCentralUno.add(btn0);
        panelCentralUno.add(new JButton(""));
        panelCentralUno.add(btnDot);

        return panelCentralUno;
    }

    public JPanel configurarCentralDos() {

        panelCentralDos.setLayout(new GridLayout(5, 1));
        panelCentralDos.add(btnDivision);
        panelCentralDos.add(btnMultiplicacion);
        panelCentralDos.add(btnResta);
        panelCentralDos.add(btnSuma);
        panelCentralDos.add(btnEqual);

        return panelCentralDos;
    }

    public JPanel configurarInferior() {
        panelInferior.add(btnNormal);
        panelInferior.add(btnCompleja);

        return panelInferior;
    }

    private JPanel configurarCentro() {
        central.setLayout(new GridLayout(4, 2, 10, 10));
        central.add(b1);
        central.add(b2);
        central.add(b3);
        central.add(b4);
        central.add(bSuma);
        central.add(bResta);
        central.add(bIgual);

        return central;
    }

    private JPanel configurarSuperior() {
        superior.setLayout(new BorderLayout());
        superior.add(pantalla, BorderLayout.CENTER);
        return superior;
    }

    private void acciones() {
        Component[] componentes = central.getComponents();
        for (Component item : componentes) {

            ((JButton) item).addActionListener(this);
        }
    }

    private void instancias() {
//Paneles
        panelSuperior = new JPanel();
        PanelCentral = new JPanel();
        panelInferior = new JPanel();
        panelDerecho = new JPanel();
        panelCentralUno = new JPanel();
        panelCentralDos = new JPanel();

//TextField
        pantalla = new JTextField();

//Botones
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn2.setActionCommand(Constantes.BTN_2);
        btn3 = new JButton("3");
        btn3.setActionCommand(Constantes.BTN_3);
        btn4 = new JButton("4");
        btn4.setActionCommand(Constantes.BTN_4);
        btn5 = new JButton("5");
        btn5.setActionCommand(Constantes.BTN_5);
        btn6 = new JButton("6");
        btn6.setActionCommand(Constantes.BTN_6);
        btn7 = new JButton("7");
        btn7.setActionCommand(Constantes.BTN_7);
        btn8 = new JButton("8");
        btn8.setActionCommand(Constantes.BTN_8);
        btn9 = new JButton("9");
        btn9.setActionCommand(Constantes.BTN_9);
        btn0 = new JButton("0");
        btn0.setActionCommand(Constantes.BTN_0);
        btnDot = new JButton(".");
        btnDot.setActionCommand(Constantes.BTN_DOT);
        btnSuma = new JButton("+");
        btnSuma.setActionCommand(Constantes.BTN_SUM);
        btnResta = new JButton("-");
        btnResta.setActionCommand(Constantes.BTN_RES);
        btnDivision = new JButton("/");
        btnDivision.setActionCommand(Constantes.BTN_DIV);
        btnMultiplicacion = new JButton("*");
        btnMultiplicacion.setActionCommand(Constantes.BTN_MUL);
        btnEqual = new JButton("=");
        btnEqual.setActionCommand(Constantes.BTN_EQU);
        btnAC = new JButton("AC");
        btnAC.setActionCommand(Constantes.BTN_AC);
        btnMasMenos = new JButton("+/-");
        btnMasMenos.setActionCommand(Constantes.BTN_MM);
        btnPercent = new JButton("%");
        btnPercent.setActionCommand(Constantes.BTN_PER);
        btnNormal = new JButton("Normal");
        btnNormal.setActionCommand(Constantes.BTN_NOR);
        btnCompleja = new JButton("Compleja");
        btnCompleja.setActionCommand(Constantes.BTN_COM);

        b1 = new JButton("1");
        btn1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        bSuma = new JButton("+");
        bResta = new JButton("-");
        bIgual = new JButton("=");
        container = this.getContentPane();
        central = new JPanel();
        superior = new JPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "1");
            } else {
                pantalla.setText("1");
            }

        } else if (e.getSource() == btn2) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "2");
            } else {
                pantalla.setText("2");
            }
        } else if (e.getSource() == b3) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "3");
            } else {
                pantalla.setText("3");
            }
        } else if (e.getSource() == b4) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "4");
            } else {
                pantalla.setText("4");
                operando = false;
            }
        } else if (e.getSource() == bSuma) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 1;
        } else if (e.getSource() == bResta) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 2;

        } else if (e.getSource() == bIgual) {
            op2 = Integer.valueOf(pantalla.getText());
            int resultado = 0;
            switch (tipoOperacion) {
                case 1:
                    resultado = op1 + op2;
                    break;
                case 2:
                    resultado = op1 - op2;
                    break;

            }

            pantalla.setText(Integer.toString(resultado));
        }
    }
}
