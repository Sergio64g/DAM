package proyecto;

import java.io.IOException;

public class Thread1 extends Thread {

    @Override
    public void run() {

        //Hacer con processBuilder
        String command = "cd 'C:\\Users\\sergi\\Documents\\NetBeansProjects\\Proyecto\\src\\Documentos'; .\\pro.ps1";
        //String command[] = new String[2];
        //command[0] = "cd~; cd 'C:\\Program Files\\Java\\jdk-11.0.4\\bin'; .\\javac.exe 'C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Proyecto\\src\\Documentos\\codigo.java'";
        //command[1] = "cd~; cd 'C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\Proyecto\\src\\Documentos\\'; java codigo >  res.txt";
        System.out.println(command);
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            Process powerShellProcess = Runtime.getRuntime().exec(command);

            powerShellProcess.getOutputStream().close();

        } catch (IOException ex) {
        }

    }
}
