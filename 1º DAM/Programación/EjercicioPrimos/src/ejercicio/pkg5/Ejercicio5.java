package ejercicio.pkg5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = new int[100];
        int sumatorio = 0;
        for (int i = 0; i < 100; i++) {// se llena el array con los 100 primeros números
            a[i] = i;
        }
        for (int i = 3; i < 100; i++) {// se crea un filtro para que solo salgan por pantalla los números primos y con las condiciones de los ejercicios
            {
                for (int j = 1; j <= i; j++) {

                    if (i % j == 0) {
                        sumatorio++;
                    }
                }

                if (sumatorio == 2) {// como un número primo solo puede ser divisible entre dos números, si el contador es igual a dos, el número es primo
                    
                    System.out.println(+a[i] + " es primo");
                } else {
                    if (a[i] % 3 == 0 || a[i] % 5 == 0 && (a[i] % 15 != 0)) {// es el filtro para que sean números múltiplos de 3 o múltiplos de 5 pero no múltiplos de 15

                        System.out.println(a[i]);
                    }
                }
            }
            sumatorio = 0;// vuelvo a inicializar el sumatorio como 0 para que no se acumulen los valores
        }
    }
}
