package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * Crea un m�tode anomenat 'calculaFibonacci'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre una n�mero i l'ha de calcular la s�rie de Fibonacci d'aquest mitjan�ant una t�cnica recursiva.
 * 
 * @author T.Vives
 */


public class ACT4_5_05 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base de Fibonacci: ");

        for (int i = 0; i < base; i++) {
            System.out.print("--> " + i + " ");
            System.out.print(" (R) " + UtilitatsRecOrdCerca.calculaFibonacci(i) + " ");
            System.out.println("");
        }
    }
}
