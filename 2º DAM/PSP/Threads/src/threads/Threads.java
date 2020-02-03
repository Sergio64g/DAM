package threads;

public class Threads {

    public static void main(String[] args) {

        TortugaThread tortuga = new TortugaThread();
        Thread liebre = new Thread(new LiebreThread());
        tortuga.start();
        liebre.start();
        //TicTac tictac = new TicTac();
        //tictac.start();

        //System.out.flush();
    }

}
