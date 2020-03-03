package Servidor;

import java.io.*;

public class Ejecutar {

    String code;

    public Ejecutar(String code){
        this.code = code;
        escribir(code);
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
