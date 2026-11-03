package ACT4_7;

import ACT4_3.UtilitatsConsola;

public class ACT4_7_06 {
    public static void main(String[] args) {
        int mida = UtilitatsConsola.llegirSencer("Introduexi la mida del patrò: ");

        System.out.println("Patró generat:");
        UtilitatsRecOrdCerca.imprimeixPatro(mida);
        System.out.println();
    }


}
