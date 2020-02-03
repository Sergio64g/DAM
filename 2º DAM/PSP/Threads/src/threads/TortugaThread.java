/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author Usuario DAM 2
 */
public  class TortugaThread extends Thread {

        public void run() {
            int i = 0;
            System.out.println("Comienza la Tortuga.");
            while (i < 5) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Tortuga.");
                } catch (InterruptedException ex) {
                }
                i++;
            }
            System.out.println("Termina la Tortuga.");
        }
    }
