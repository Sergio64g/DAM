package examen_tr1_ad_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Examen_Tr1_AD_2 {

    public static void main(String[] args) {

        //Crear un objeto File 
        File alojamiento = new File("src/Hotels/alojamiento.txt");
        FileWriter escritura = null;
        BufferedWriter bw = null;
        //Crear un try-catch para manejar excepciones
        try {
            //Crear un nuevo flujo de salida de datos
            escritura = new FileWriter(alojamiento);
            bw = new BufferedWriter(escritura);

            //Escribe el registro en el fichero mediante el metodo write()
            bw.write("NH;ALCORCON;HOTEL 4*;4,5;");
            //Se usa el metoo newLine para haver un salto de linea y no escribir todo en la misma linea
            //asi será mas facil leerlo
            bw.newLine();
            bw.write("EH;MADRID;HOTEL 2*;6;");
            bw.newLine();
            bw.write("NW;NUEVAYORK;HOTEL 3*;7;");
            bw.newLine();
            bw.write("LA;LOSANGELES;HOTEL 4*;8;");
            bw.newLine();
            bw.write("CO;CALIFORNIA;HOTEL 5*;9,5;");
        } catch (IOException ex) {
            System.err.println("Error al trabajar con el fichero 'alojamiento.txt'");
            //Tras trabajar con el fichero el flujo de datos se cierra 
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
            } catch (NullPointerException ex) {
            }
        }
//---------------------------------------------------------------------------------------------------------------
        //Crear un objeto File con la ruta del fichero con el que se va a trabajar
        File leer = new File("src/Hotels/alojamiento.txt");
        BufferedReader lectura = null;
        try {
            //Crear un nuevo flujo de entrada de datos
            lectura = new BufferedReader(new FileReader(leer));

            String linea;
            //Lee las lineas del fichero
            while ((linea = lectura.readLine()) != null) {
                //Separa la linea leida con el metodo split(";") y las guarda en un array
                String[] partes = linea.split(";");
                //Guarda en variables cada posicion del array para despues mostrarlas por pantalla
                String nombre = partes[0];
                String localidad = partes[1];
                String tAlojamineto = partes[2];
                String valoracion = partes[3];

                System.out.println("Nombre: " + nombre);
                System.out.println("Localidad: " + localidad);
                System.out.println("Tipo de alojamiento: " + tAlojamineto);
                System.out.println("Valoración: " + valoracion);
                System.out.println("---------------------------------------------------------------------------------");
            }

        } catch (FileNotFoundException ex) {
            System.err.println("No se encontró el fichero");
        } catch (IOException ex) {
            System.err.println("Error al trabajar con el fichero 'alojamiento.txt'");
            //Tras trabajar con el fichero el flujo de datos se cierra 
        } finally {
            try {
                lectura.close();
            } catch (IOException ex) {
            } catch (NullPointerException ex) {
            }
        }
    }
}
