package ACT4_3;

import ACT4_1.UtilitatsArrays;
// import ACT4_2.UtilitatsMatrius;


 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una lí­nia.
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
