package Servidor;

import java.io.*;

public class Ejecutar {

    String code;

    public Ejecutar(String code){
        this.code = code;
        escribir(code);
        ejecutarExe();

    }

    public void escribir(String code) {
        File file = new File("src/Ejecutar.java");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(code);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ejecutarExe() {
        Thread thread = new Thread(ejecutarScript());
        thread.start();
    }
    public Runnable ejecutarScript() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //TODO No hace el processbuilder
                ProcessBuilder pb = new ProcessBuilder("src/Servidor/Ejecutar.exe");
                try {
                    pb.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return runnable;
    }
    public String leerFichero(File file) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return sb.toString();
    }
}
