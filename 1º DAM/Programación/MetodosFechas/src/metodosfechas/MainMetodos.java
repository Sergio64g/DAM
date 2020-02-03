package metodosfechas;

import java.util.Scanner;

public class MainMetodos {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MetodosFechas miFecha = new MetodosFechas();
        System.out.println("Introduzca el día");
        miFecha.setDay(sc.nextInt());
        System.out.println("Introduzca el mes");
        miFecha.setMonth(sc.nextInt());
        System.out.println("Introduzca el año");
        miFecha.setYear(sc.nextInt());

        miFecha.muestreDia();
        System.out.println(miFecha.NombreMes());
        System.out.println(miFecha.getDiaSemana());
        System.out.println(miFecha.esBisiesto());
        miFecha.Fechacompleta();
        
        miFecha.pasarDia();
        
        miFecha.muestreDia();
        System.out.println(miFecha.NombreMes());
        System.out.println(miFecha.getDiaSemana());
        System.out.println(miFecha.esBisiesto());
        miFecha.Fechacompleta();
    }

}
