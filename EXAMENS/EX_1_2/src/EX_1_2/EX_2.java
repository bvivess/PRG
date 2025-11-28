package EX_1_2;

import java.util.ArrayList;

public class EX_2 {
    public static void main(String[] args) {
        int[] array1;  // 'array' de 5 posicions amb valors aleatoris entre 0 i 9
        int[] array2;  // 'array' de 5 posicions amb valors aleatoris entre 0 i 9
        ArrayList<Integer> resultat;  // 'arraylist' resultant
        
        // Crea 2 'Array' de 10 posicions amb números aleatoris entre 0 i 9
        array1 = UtilitatsArrays.generaArray(5, 0, 9);
        array2 = UtilitatsArrays.generaArray(5, 0, 9);
        
        // Calcula l''ArrayList' emprant el mètode 'obteRepetits' 
        resultat = UtilExamen.obteRepetits(array1, array2);
        
        // Mostra els 2 'Array' i l''ArrayList' resultant
        UtilitatsArrays.mostraArray(array1);
        UtilitatsArrays.mostraArray(array2);
        UtilExamen.mostraArrayListInt(resultat);
    }
}

