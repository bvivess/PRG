package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un mètode anomenat 'calculaMCD'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 2 números i l'ha de calcular el mínim comú divisor entre aquests.
 * 
 * @author T.Vives
 */

public class ACT4_5_4 {
    public static void main(String[] args) {
        int a = UtilitatsConsola.llegirSencer("Introdueixi un número sencer: ");
        int b = UtilitatsConsola.llegirSencer("Introdueixi un número sencer: ");

        System.out.print(UtilitatsRecOrdCerca.calculaMCD(a,b) + " ");
    }
}
