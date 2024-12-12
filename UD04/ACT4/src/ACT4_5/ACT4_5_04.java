package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un m�tode anomenat 'calculaMCD'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre 2 n�meros i l'ha de calcular el m�xim com� divisor (MCD) entre aquests.
 * 
 * @author T.Vives
 */

public class ACT4_5_04 {
    public static void main(String[] args) {
        int a = UtilitatsConsola.llegirSencer("Introdueixi un n�mero sencer: ");
        int b = UtilitatsConsola.llegirSencer("Introdueixi un n�mero sencer: ");

        System.out.println("El MCD �s: " + UtilitatsRecOrdCerca.calculaMCD(a,b) + " ");
    }
}
