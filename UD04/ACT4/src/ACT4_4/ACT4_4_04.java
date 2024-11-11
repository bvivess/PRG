package ACT4_4;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;
import ACT4_3.UtilitatsConsola;

/**
 *
 * @author T.Vives
 */
public class ACT4_4_04 {
    static ArrayList<String> alumnes = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> notes = new ArrayList<>();
    
    public static void main(String[] args) {
        llegirAlumnes(alumnes);
        
        MostrarNotes(alumnes, notes);
    }
    
    public static void llegirAlumnes(ArrayList<String> alumnes) {
        String text;
        
        do {
            text = UtilitatsConsola.llegirCadena("Nom alumne ('sortir' per acabar): ");
            if (!text.equalsIgnoreCase("sortir")) {
                alumnes.add(text);
                llegirNotes(notes);
            }
        } while (!text.equalsIgnoreCase("sortir"));
    }
    
    public static void llegirNotes(ArrayList<ArrayList<Integer>> notes) {
        ArrayList<Integer> notesAlumne = new ArrayList<Integer>();
        int nota;
        
        // Notes de l'alumne
        do {
            nota = UtilitatsConsola.llegirSencer("Introduexi notes ('-1' per acabar): ");
            if (nota == -1)
                break;
            else
                notesAlumne.add(nota);
        } while (true);
        // Afegir la fila
        notes.add(notesAlumne);
    }
    
    public static void MostrarNotes( ArrayList<String> alumnes, ArrayList<ArrayList<Integer>> notes) {
        ArrayList<Integer> notesAlumne;
        
        for (int i=0; i<alumnes.size(); i++) {
            System.out.print(alumnes.get(i) + ": ");
            notesAlumne = notes.get(i);
            for (Integer n : notesAlumne) {
                System.out.print(n + " ");
            }
            // ArrayList<Integer> --> int[] per emprar 'UtilitatsArrays.mitjanaArray'
            int[] notesArray = new int[notesAlumne.size()];
            float mitjana;
            for (int j=0;j<notesAlumne.size();j++) {
                notesArray[j] = notesAlumne.get(j);
            }
            mitjana = UtilitatsArrays.mitjanaArray(notesArray);
            System.out.println("Mitjana: " + mitjana);
            System.out.println("----------");
        }
    }
}
