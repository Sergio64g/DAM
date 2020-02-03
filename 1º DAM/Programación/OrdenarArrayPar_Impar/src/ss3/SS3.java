package ss3;

public class SS3 {

    /**
     * Escribe un programa que genere 20 números enteros aleatorios entre 0 y
     * 100 y que los almacene en un array. El programa debe ser capaz de pasar
     * todos los números pares a las primeras posiciones del array (del 0 en
     * adelante) y todos los números impares a las celdas restantes. Utiliza
     * arrays auxiliares si es necesario
     */
    public boolean par(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;

        }
    }

    public static void main(String[] args) {

        int[] n = new int[20];
        int[] par = new int[20];
        int[] impar = new int[20];
        int x = 0;
        int y = 0;
        for (int i = 0; i < 20; i++) {
            n[i] = (int) (Math.random() * 101);

            if (n[i] % 2 == 0) {
                par[x++] = n[i];
            } else {
                impar[y++] = n[i];
            }
        }

        for (int i = 0; i < x; i++) {
            n[i] = par[i];
        }

        for (int i = x; i < 20; i++) {
            n[i] = impar[i - x];
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(n[i] + " ");
        }
    }
}
