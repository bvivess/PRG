package EX_UD04;


import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class EX_2 {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int num = 25;
        array = UtilitatsClasses.arrayToArrayListInt(  // es transforma a ArrayList
                UtilitatsRecOrdCerca.ordenaArrayBimbolla(  // s'ordena l'array
                        UtilitatsArrays.generaArray(10, 0, 199))); // es genera un array
        
        // cos del programa
        UtilitatsClasses.mostraArrayListInt(array);
        afegeixNum(array, num);  
        UtilitatsClasses.mostraArrayListInt(array);
    }
     
    private static void afegeixNum(ArrayList<Integer> array, int num) {
        // Cerca dins l''ArrayList' array fins a trobar un element igual o superior al que es vol introduir.
        // Emmagatzema la posició en una variable. 
        // Insereix el número en la posició emmagatzemada.
        
        // TO-DO code application logic here
        
    }

}
