package EX_UD04_II;

import java.util.ArrayList;

public class EX_1 {

    private static final int LONGITUT = 10;  // longitut de l'array
    private static int[] array = new int[LONGITUT];  // declaracio i instanciacio de l'array
    private static int index = 0;  // s'inicialitza l'array
        
    public static void main(String[] args) {
        
        // NOTA: NO CAL MODIFICAR EL METODE 'main'
        
        int accio;
        array = UtilitatsArrays.generaArray(LONGITUT, 0, 199);
        
        do {
            // mostra l'array generat aleatoriament
            UtilitatsArrays.mostraArray(array);
            // mostra l'element al que apunta 'index'
            mostraElement(array);  
            
            // llegeix l''accio' a fer
            accio = UtilitatsConsola.llegirSencer("2: Inici; 4: Esquerra; 6: Dreta; 8: Final; 0: Sortir: ");
            // mou l'index segons indiqui 'accio'
            cambiaIndex(accio);  // cal crear aquest mètode com s'especifica a l'enunciat
        } while (accio != 0);
    }
    
    // TO-DO code application logic here
    //   Crea el metode anterior de manera que faci allò que s'indica a l'enunciat
    
    
    private static void mostraElement(int[] array) {
        // Mostra l'element en posició 'index' de l'array
        System.out.println(array[index]);
    }
    
 }