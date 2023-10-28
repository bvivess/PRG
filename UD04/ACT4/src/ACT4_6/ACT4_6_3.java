package ACT4_6;

import ACT4_3.UtilitatsConsola;

public class ACT4_6_3 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base de Fibonacci: ");

        for (int i = 0; i < base; i++) {
            System.out.print(UtilitatsRecOrdCerca.calcularFibonacci(i) + " ");
        }
    }
}
