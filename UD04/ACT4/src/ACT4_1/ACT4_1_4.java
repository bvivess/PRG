package ACT4_1;

/**
 * Crea una classe amb un mètode que rebi la longitud d'un array de sencers i torni un array de la longitud demanada
 * inicialitzat de forma aleatòria entre un mínim i un màxim donats.
 * Al main genera tres arrays de longituds diferents i mostra'ls per pantalla. Utilitza el mètode de l'ACT4_1.
 */

public class ACT4_1_4 {

    public static void main(String[] args) {
        UtilitatsArrays.mostraArray(UtilitatsArrays.generaArray(10, 1, 20));
        UtilitatsArrays.mostraArray(UtilitatsArrays.generaArray(5, 100, 225));
        UtilitatsArrays.mostraArray(UtilitatsArrays.generaArray(25, 25, 50));
    }
}