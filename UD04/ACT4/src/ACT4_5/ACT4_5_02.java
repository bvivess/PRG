package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un m�tode anomenat 'calculaFactorial'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre una n�mero i l'ha de calcular el factorial d'aquest mitjan�ant una t�cnica recursiva.
 * 
 * @author T.Vives
*/

public class ACT4_5_02 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base factorial: ");

        System.out.println(UtilitatsRecOrdCerca.calculaFactorial(base));
    }
}
