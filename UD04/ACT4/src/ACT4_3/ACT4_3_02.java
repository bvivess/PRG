package ACT4_3;

import ACT4_1.UtilitatsArrays;
// import ACT4_2.UtilitatsMatrius;


 /**
    * Crea un array d 'String' de 5 posicions de nom 'alumnes'. Llegeix per teclat el nom de cada alumne. 
    * A continuació,  crea una matriu d''int' de 5x5 de nom 'notes' i que permeti introduir les notes de cada alumne de manera manual. 
    * NOTA: També pots considerar inicilitzar la matriu amb notes aleatòries entre els valors d'aquesta entre MIN=0 a MAX=10. 
  */
public class ACT4_3_02 {

    public static void main(String[] args) {
        final int NUM_ALUMNES=5;
        String[] alumnes = new String [NUM_ALUMNES];
        int[][] notes = new int[NUM_ALUMNES][NUM_ALUMNES]; // UtilitatsMatrius.generaMatriu(MIDA, 0, 10);

        // Llegir el nom dels alumnes:
        for (int i=0; i<alumnes.length; i++){
            alumnes[i] = UtilitatsConsola.llegirCadena("Nom de l'alumne: ");
        }
        
        // Llegir les notes per a cada alumne:
        for (int i=0; i<notes.length; i++) {
            System.out.println("Alumne: " + alumnes[i]);
            for (int j=0; j<notes[i].length; j++) 
                notes[i][j] = UtilitatsConsola.llegirSencer("Introdueixi la nota [" + j + "]: ");
        }
        
        // Mostra els alumnes i les seves notes
        for (int i=0; i<alumnes.length; i++){
            System.out.print(alumnes[i] + ": ");
            UtilitatsArrays.mostraArray(notes[i]);
            System.out.println("Mitjana: " + UtilitatsArrays.mitjanaArray(notes[i]));
            System.out.println("----------");
        }
    }
    
}
