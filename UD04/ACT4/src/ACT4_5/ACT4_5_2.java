package ACT4_5;

import ACT4_3.UtilitatsConsola;

public class ACT4_5_2 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base factorial: ");

        System.out.println(UtilitatsRecOrdCerca.calcularFactorial(base));
    }
}
