package t2_worker;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

class Ventana extends JFrame implements ActionListener {

    JButton btn1, btn2;
    JProgressBar barra, barra2;
    Ventana v;

    public Ventana() {
        initGUI();
    }

    void initGUI() {
        instancias();
        configurarContainer();
        acciones();
        this.setSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();

    }

    private void instancias() {
        v = this;
        btn1 = new JButton("Boton 1");
        btn2 = new JButton("Boton 2");
        barra = new JProgressBar(0, 100);
        barra.setStringPainted(true);
        barra2 = new JProgressBar(0, 100);
        barra2.setStringPainted(true);
    }

    private void configurarContainer() {
        this.setLayout(new GridLayout(2, 1));
        this.add(btn1);
        this.add(btn2);
        this.add(barra);
        this.add(barra2);

    }

    private void acciones() {
        btn1.addActionListener(this);
        btn2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            /*for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
                barra.setValue(i);
            }*/
            System.out.println("BTN1");
        } else if (e.getSource() == btn2) {
            MiWorker worker = new MiWorker(v);
            worker.execute();
        }
    }

    class MiWorker extends SwingWorker<Boolean, Integer> {

        
        Ventana v;

        public MiWorker(Ventana v) {
            this.v = v;
        }
        
        
        @Override
        protected Boolean doInBackground() throws Exception {
            for (int i = 0; i < 101; i++) {
                publish(i);
                Thread.sleep(50);
            }

            return true;
        }

        @Override
        protected void process(List<Integer> chunks) {
            super.process(chunks);
            barra2.setValue(chunks.get(0));
        }

        @Override
        protected void done() {
            super.done();
            JOptionPane.showMessageDialog(v, "Mensaje", "Titulo", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
        

    }

}
