package EX_1_2;

import java.util.ArrayList;

public class EX_3 {
    public static void main(String[] args) {
        int[] array;  // 'array' de 5 posicions amb valors aleatoris entre 0 i 9
        ArrayList<Integer> resultat;  // 'arraylist' resultant
        
        // Genera un array de 10 posicions amb números aleatoris entre 0 i 9
        array = UtilitatsArrays.generaArray(5, 0, 9);
        
        // Calcula l''ArrayList' emprant el mètode 'ordenaArray' 
        resultat = UtilExamen.ordenaArray(array);
        
        // Mostra l''ArrayList' resultant
        UtilitatsArrays.mostraArray(array);
        UtilExamen.mostraArrayListInt(resultat);
    }
}

