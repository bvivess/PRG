package EX_UD04_II;

import java.util.ArrayList;

public class EX_1_OK {

    private static final int LONGITUT = 10;  // longitut de l'array
    private static int[] array = new int[LONGITUT];  // declaracio i instanciacio de l'array
    private static int index = 0;  // s'inicialitza l'array
        
    public static void main(String[] args) {
        
        int accio;
        array = UtilitatsArrays.generaArray(LONGITUT, 0, 200); // es genera un array
        
        do {
            UtilitatsArrays.mostraArray(array);
            mostraElement(array);
            
            accio = UtilitatsConsola.llegirSencer("2: Inici; 4: Esquerra; 6: Dreta; 8: Final; 0: Sortir: ");
            cambiaIndex(accio);
        } while (accio != 0);
    }
    
    private static void cambiaIndex(int accio) {
        // cal canviar la variable global 'index' de la següent manera:
        //   '2' ? modificar 'index' a l'inici de l'array
        //   '8' ? modificar 'index' al final de l'array
        //   '4' ? decrementar 'index' en 1 
        //   '6' ? incrementar 'index'  en 1
        
        switch (accio) {
            case 4 ->
                index = Math.max(0, index-1);
            case 6->
                index = Math.min(LONGITUT-1, index+1);
            case 2->
                index = 0;
            case 8->
                index = LONGITUT-1;
        }
    }
    
    private static void mostraElement(int[] array) {
        System.out.println(array[index]);
    }
    
 }