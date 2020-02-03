package contador;

import java.util.Scanner;

public class Contador {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int aux = 0;
        int cont = 1;
        System.out.println("Contador de números, termina con 0");
        while (a != 0) {
            a = sc.nextInt();

            if (a == aux) {
                cont++;

            } else {
                if(aux != 0){
                System.out.println("Ha introducido el " + aux + " " + cont + " veces");
                cont = 1;
                }
                
            }  
            aux = a;
        }
        System.out.println("Ha salido del programa :)");

    }

}
