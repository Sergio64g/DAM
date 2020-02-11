/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_t2_di;

import javax.swing.SwingUtilities;

/**
 *
 * @author Usuario DAM 2
 */
public class Examen_T2_DI {

    public static void main(String[] args) {
        
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Ventana ventanaPrincipal = new Ventana();
                ventanaPrincipal.initGUI();
            }
        });
        //Thread1 thread1 = new Thread1();
        //thread1.start();
        

    }
}