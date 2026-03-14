package ACT4_5;

import ACT4_3.UtilitatsConsola;

/**
 * 
 * Crea un mètode anomenat 'calculaPotència'  dins la classe 'UtilitatsRecOrdCerca'.
 * Ha de rebre una base i un exponent i ha de calcular la potencia de la base elevat a l'exponent 
 * mitjançant una tècnica recursiva.
 * 
 * @author T.Vives
 */
public class ACT4_5_01 {
    public static void main(String[] args) {
        int base = UtilitatsConsola.llegirSencer("Introdueixi la base: ");
        int exponent = UtilitatsConsola.llegirSencer("Introdueixi l'exponent: ");
        
        System.out.print("--> " + base + "^" + exponent);
        System.out.print(" (R) " + UtilitatsRecOrdCerca.calculaPotencia(base, exponent));
        System.out.println("");
    }
}
