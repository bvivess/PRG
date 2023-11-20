package ACT4_5;

import ACT4_3.UtilitatsConsola;

public class ACT4_5_1 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base: ");
        int exponent = UtilitatsConsola.llegirSencer("Introdueixi l'exponent: ");

        System.out.println(UtilitatsRecOrdCerca.calculaPotencia(base, exponent));
    }
}
