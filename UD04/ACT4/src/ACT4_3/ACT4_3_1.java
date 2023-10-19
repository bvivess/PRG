package ACT4_3;

import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;
        

public class ACT4_3_1 {
    public static void main(String[] args) {
        int numNotes = UtilitatsConsola.llegirSencer("Quantitat de notes de l'alumne: ");
        int[] notes = new int[numNotes];
        for (int index = 0; index < notes.length; index++) {
            notes[index] = UtilitatsConsola.llegirSencer("Nota " + index + ": ");
        }
        System.out.print("Notes: ");
        UtilitatsArrays.mostraArray(notes);
        System.out.println("Mitjana: " + UtilitatsArrays.mitjanaArray(notes));
    }    
}
