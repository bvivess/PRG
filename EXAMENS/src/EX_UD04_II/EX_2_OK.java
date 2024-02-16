package EX_UD04_II;

import java.util.ArrayList;
import java.util.Collections;

public class EX_2_OK {

    private static final int NELEMENTS = 3;  // longitut de l'array
    private static ArrayList<Integer> array = new ArrayList<Integer>();  // declaració de l'array
    
    public static void main(String[] args) {
        
        // NOTA: NO CAL MODIFICAR EL MÈTODE 'main'
        
        // afegeix NELEMENTS a l''array'
        afegeixElements(array, NELEMENTS);
        
        // ordena l''array'
        ordenaElements(array);
        
        // elimina cada element de l''array' 
        eliminaElements(array);
        
    }
    
    private static void afegeixElements(ArrayList<Integer> array, int nElements) {
        Integer element;
        int i = 0;
        
        // afegeix N elements
        while (i!=nElements) {
            element = UtilitatsConsola.llegirSencer("Introdueix l'element a INSERIR: ");
            // comprova si l'element ja existeix
            if (!(array.contains(element))) {
                array.add(element);
                i++;
            }
            
            // mostra l''array'
            UtilitatsClasses.mostraArrayListInt(array);
        }
    }

    private static void ordenaElements(ArrayList<Integer> array) {
        // ordena l''array'
        Collections.sort(array);
        
        // mostra l''array'
        UtilitatsClasses.mostraArrayListInt(array);
    }

    private static void eliminaElements(ArrayList<Integer> array) {
        Integer element;
        
        // elimina cada element de l''array' fins eliminar-los tots
        while (!array.isEmpty()) {
            element = UtilitatsConsola.llegirSencer("Introdueix l'element a ELIMINAR: ");
            array.remove(element);
            
            UtilitatsClasses.mostraArrayListInt(array);
        }
        
    }    
 }