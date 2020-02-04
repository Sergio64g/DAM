package examen_tr1_ad_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Examen_Tr1_AD_1 {

    public static void main(String[] args) {

        //Crear un nuevo dorectorio con la clase File
        File hotels = new File("src/Hotels");
        //Comprobar que el directorio ya existe o no
        if (!hotels.exists()) {
            //Si el directorio no esta creado, usando el método mkdirs creamos un directorio
            hotels.mkdirs();
        }
        //Crear nuevos objetos de la clase File para poder crear los ficheros txt de las entidades
        File alojamiento = new File("src/Hotels/alojamiento.txt");
        File localidad = new File("src/Hotels/localidad.txt");
        File servicio = new File("src/Hotels/servicio.txt");
        File cliente = new File("src/Hotels/cliente.txt");
        File reserva = new File("src/Hotels/reserva.txt");

        //Se usa el manejo de excepciones con try-catch para manejar los posibles errores que nos de al crear los ficheros
        try {
            //Se crear los ficheros txt con el metodo createNewFile()
            alojamiento.createNewFile();
            localidad.createNewFile();
            servicio.createNewFile();
            cliente.createNewFile();
            reserva.createNewFile();
        } catch (IOException ex) {
            System.err.println("Error al trabajar con ficheros");
        }
        //Se consigue la ruta del directorio 'hotels' con el metodo getAbsolutePath()
        System.out.println("Ruta del directorio: " + hotels.getAbsolutePath());
        //Se guarda un array de los ficheros que contiene el directorio 'hotels' en ficheros
        File[] ficheros = hotels.listFiles();
        //Se crea un bucle que recorre el array anterior que muestra el nombre del fichero con el metodo getname() y la ruta absoluta con getAbsolutePath()
        for (File item : ficheros) {
            System.out.println("\nNombre: " + item.getName() + "\nRuta: " + item.getAbsolutePath() + "\n");
        }

    }

}
