package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un mètode anomenat 'calculaFactorial'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre una número i l'ha de calcular el factorial d'aquest mitjançant una tècnica recursiva.
 * 
 * @author T.Vives
*/

public class ACT4_5_02 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base factorial: ");

        System.out.println(UtilitatsRecOrdCerca.calculaFactorial(base));
    }
}
