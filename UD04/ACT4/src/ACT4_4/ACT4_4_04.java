package ACT4_4;
import java.util.ArrayList;
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

        
    }
    
    public static void llegirAlumnes(ArrayList<String> alumnes) {
        String text;
        int i = 0;
        
        do {
            text = UtilitatsConsola.llegirCadena("Nom alumne ('sortir' per acabar): ");
            alumnes.add(text);
            llegirNotes(i, notes);
            i++;
            System.out.println(text.compareTo("sortir"));
        } while ( text.compareTo("sortir") != 0);
    }
    
    public static void llegirNotes(int i, ArrayList<Integer> notes) {
        int nota;
        
        do {
            nota = UtilitatsConsola.llegirSencer("Intruexi notes per a " + alumnes.get(i) + ": ");
        } while(nota!= -1);
    }
}
