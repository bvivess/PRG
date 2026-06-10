package ACT10_8;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mida del tauler: ");
        int mida = scanner.nextInt();

        System.out.print("Nombre de fulles: ");
        int nFulles = scanner.nextInt();

        Joc joc = new Joc();
        joc.jugar(mida, nFulles);
    }
}