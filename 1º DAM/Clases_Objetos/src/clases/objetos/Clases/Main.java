package clases.objetos.Clases;

import java.util.Scanner;

public class Main {

    public boolean posAC(int ac) {
        return ac > 0;

    }

    public static void main(String[] args) {

        /*
        *1.-Registrar Coches
        *2.-Desregistrar Coche
        *3.-Listar registrados
        *4.-Meter coche en el garaje
        *5.-Sacar Coche del garaje
        *6.-Trabajar con coches
        *6.1.-Acelerar coche
        *6.2.-Decelerar coche
         */
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;
        String matricula;

        Garaje garaje = new Garaje();

        do {
            System.out.println("        1.-Registrar Coches\n"
                    + "        2.-Desregistrar Coche\n"
                    + "        3.-Listar registrados\n"
                    + "        4.-Meter coche en el garaje\n"
                    + "        5.-Sacar Coche del garaje\n"
                    + "        6.-Trabajar con coches\n"
                    + "        7.-Salir");

            opcion = sc.nextInt();
            switch (opcion) {
//Registrar
                case 1:
                    System.out.println("Introduce la matricula");
                    sc.useDelimiter("\n");
                    matricula = sc.next();
                    sc.nextLine();

                    if (!garaje.comprobarGaraje(matricula)) {
                        System.out.println("Introduce la marca");
                        String marca = sc.next();
                        sc.nextLine();
                        System.out.println("Introduce el modelo");
                        String modelo = sc.next();
                        sc.nextLine();
                        System.out.println("Introduce el numero de bastidor");
                        int bastidor = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduce los caballos");
                        int cv = sc.nextInt();
                        sc.nextLine();
                        Coche coche = new Coche(matricula, marca, modelo, cv, bastidor);
                        garaje.agregarCoche(coche);
                        System.out.println("Coche agregado");
                    } else {
                        System.out.println("El coche ya esta");
                    }
                    break;
//Desregistrar                    
                case 2:
                    System.out.println("Introduce la matricula del coche que desea desregistrar");
                    matricula = sc.next();
                    sc.nextLine();
                    if (!garaje.comprobarGaraje(matricula)) {
                        System.out.println("No se puede eliminar porque no existe");
                    } else {
                        garaje.eliminarCoche(matricula);
                        System.out.println("Eliminado con éxito");
                    }
                    break;
//Listar
                case 3:
                    garaje.listarCoches();
                    break;
//Meter en garaje
                case 4:

                    System.out.println("¿Qué coche quiere meter en el garaje?(Introduzca la matrícula)");
                    matricula = sc.next();
                    sc.nextLine();

                    if (garaje.comprobarGaraje(matricula)) {

                        if (garaje.estadoCoche(matricula)) {
                            System.out.println("El coche ya está dentro del garaje");
                        } else {
                            garaje.cambiarEstado(matricula);
                            System.out.println("Ahora el coche está aparcado dentro del garaje");
                        }

                    } else {
                        System.out.println("El coche no está registrado");
                    }
                    break;
//Sacar del garaje
                case 5:

                    System.out.println("¿Qué coche quiere sacar del garaje?(Introduzca la matrícula)");
                    matricula = sc.next();
                    sc.nextLine();

                    if (garaje.comprobarGaraje(matricula)) {

                        if (!garaje.estadoCoche(matricula)) {
                            System.out.println("El coche ya está fuera del garaje");
                        } else {
                            garaje.cambiarEstado(matricula);
                            System.out.println("Ahora el coche está fuera del garaje");
                        }

                    } else {
                        System.out.println("El coche no está registrado");
                    }
                    break;
//Trabajar con el coche
                case 6:
                    do {
                        System.out.println("        1.-Acelerar el coche\n"
                                + "        2.-Decelerar el coche\n"
                                + "        3.-Volver");

                        opcion2 = sc.nextInt();
                        switch (opcion2) {
//Acelerar
                            case 1:
                                System.out.println("¿Qué coche quieres acelerar?");
                                matricula = sc.next();
                                sc.nextLine();
                                if (garaje.comprobarGaraje(matricula)) {
                                    System.out.println("¿Cúanto quiere acelerar el coche?");
                                    int ac = sc.nextInt();
                                    if (ac > 0) {
                                        garaje.acelerar(matricula, ac);
                                    } else {
                                        System.out.println("Introduzca un valor positivo");
                                    }
                                } else {
                                    System.out.println("El coche no está registrado");
                                }
                                break;
//Decelerar
                            case 2:
                                System.out.println("¿Qué coche quieres frenar?");
                                matricula = sc.next();
                                sc.nextLine();
                                if (garaje.comprobarGaraje(matricula)) {
                                    System.out.println("¿Cúanto quiere frenar el coche?");
                                    int ac = sc.nextInt();
                                    if (ac > 0) {
                                        garaje.frenar(matricula, ac);
                                    } else {
                                        System.out.println("Introduzca un valor positivo");
                                    }
                                } else {
                                    System.out.println("El coche no está registrado");
                                }

                                break;

                        }
                    } while (opcion2 != 3);

                    break;

            }

        } while (opcion != 7);

    }

}
