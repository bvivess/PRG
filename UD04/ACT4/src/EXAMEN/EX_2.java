package EXAMEN;
import ACT4_4.*;
import java.util.ArrayList;
import ACT4_1.UtilitatsArrays;
import ACT4_5.UtilitatsRecOrdCerca;

/**
 *
 * @author T.Vives
 */
public class EX_2 {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> resultat = new ArrayList<>();
        int num = 25;
        array = UtilitatsClasses.arrayToArrayListInt(  // es transforma a ArrayList
                UtilitatsRecOrdCerca.ordenaArrayBimbolla(  // s'ordena l'array
                        UtilitatsArrays.generaArray(10, 0, 199))); // es genera un array
        
        // cos del programa
        UtilitatsClasses.mostrarArrayListInt(array);
        resultat = afegeixNum(array, num);  
        UtilitatsClasses.mostrarArrayListInt(resultat);
    }
     
    private static ArrayList<Integer> afegeixNum(ArrayList<Integer> array, int num) {
        ArrayList<Integer> resultat = new ArrayList<>();
        
        // TO-DO
        
        return resultat;
    }

}
