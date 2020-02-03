
package fechas.bisiesto;

import java.util.Scanner;


public class FechasBisiesto {

    /**
     * Escribir un programa que pida por teclado una fecha en tres variables:
     * día, mes y año (datos enteros) y muestre por pantalla: "FECHA CORRECTA",
     * en el caso de que la fecha sea válida. "FECHA INCORRECTA", en el caso de
     * que la fecha no sea válida. Nota: Son bisiestos todos los años múltiplos
     * de 4, excepto aquellos que son múltiplos de 100 pero no de 400
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dia;
        int mes;
        int year;

        System.out.println("Introduce el año");
        year = sc.nextInt();
        System.out.println("Introduce el mes");
        mes = sc.nextInt();

        if (mes >= 1 && mes <= 12) {
            System.out.println("Introduce el día");
            dia = sc.nextInt();
            switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (dia >= 1 && dia <= 31) {
                        System.out.println("Fecha correcta");

                    } else {
                        System.out.println("Fecha incorrecta");

                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (dia >= 1 && dia <= 30) {
                        System.out.println("Fecha correcta");

                    } else {
                        System.out.println("Fecha incorrecta");
                    }
                    break;
                case 2:
                    if (year > 1582 && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
                        if (dia >= 1 && dia <= 29) {
                            System.out.println("Fecha correcta");

                        } else {
                            System.out.println("Fecha incorrecta");
                        }
                    } else {
                        if (dia >= 1 && dia <= 28) {
                            System.out.println("Fecha correcta");

                        } else {
                            System.out.println("Fecha incorrecta");
                        }
                    }
            }
            System.out.printf("Has elegido la fecha: %d/%d/%d\n", dia, mes, year);
        } else {
            System.out.printf("ERROR: Introduzca un mes válido");
        }

    }
}
