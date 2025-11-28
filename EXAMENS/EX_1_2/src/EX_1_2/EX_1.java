package EX_1_2;

import java.util.ArrayList;


public class EX_1 {
    public static void main(String[] args) {
        int[] array;  // 'array' de 5 posicions amb valors aleatoris entre 0 i 9
        ArrayList<Integer> arrayL;  // 'arraylist' resultant
        
        // Crea un 'Array' de 5 posicions amb números aleatoris entre 0 i 9
        array = UtilitatsArrays.generaArray(5, 0, 9);
        
        // Calcula l''ArrayList' emprant el mètode 'arrayToArrayList' 
        arrayL = UtilExamen.ArrayToArrayList(array);
        
        // Mostra l''ArrayList' resultat emprant el mètode 'mostraArrayListInt' 
        UtilitatsArrays.mostraArray(array);
        UtilExamen.mostraArrayListInt(arrayL);
    }
}

