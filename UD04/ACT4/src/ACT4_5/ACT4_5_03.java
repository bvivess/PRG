package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un m�tode anomenat 'calculaSuma'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre una n�mero i l'ha de calcular la suma des del el nombre fins a 0.
 * 
* @author T.Vives
 */

public class ACT4_5_03 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi un n�mero sencer: ");

        System.out.println(UtilitatsRecOrdCerca.sumaSuma(base));

    }
}
