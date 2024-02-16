package EX_UD04_II;

import java.util.ArrayList;
import java.util.Collections;

public class EX_2 {

    private static final int NELEMENTS = 5;  // longitut de l'array
    private static ArrayList<Integer> array = new ArrayList<Integer>();  // declaració de l'array
    
    public static void main(String[] args) {
        
        // NOTA: NO CAL MODIFICAR EL METODE 'main'
        
        // afegeix NELEMENTS a l''array'; demana per teclat cada element a afegir
        afegeixElements(array, NELEMENTS);  // cal crear aquest metode com s'especifica a l'enunciat
        
        // ordena l''array'
        ordenaElements(array);  // cal crear aquest metode com s'especifica a l'enunciat
        
        // elimina cada element de l''array'; demana per teclat cada element a eliminar
        eliminaElements(array);  // cal crear aquest metode com s'especifica a l'enunciat
        
    }
  
    // TO-DO code application logic here
    //   Crea cada un dels metodes anteriors de manera que facin allo que s'indica a l'enunciat
    
    
 }