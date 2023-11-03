package ACT4_5;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;
import java.util.ArrayList;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_5_11 {
    /*
        FULLA --> fulla
        BUIT --> res
        des de 1 fins a (FULLA-1) --> part del cuc
    */   
    static int FULLA = 99;
    static int BUIT = 0;
    static int[][] tauler;
    static ArrayList<Integer[]> cuc;
    static int[][] fulles;
    static int accio;
    
    public static void main(String[] args) {
        final int NTAULER=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        final int NFULLES=UtilitatsConsola.llegirSencer("Nombre de fulles: ");
        tauler = new int[NTAULER][NTAULER];  // matriu matriu NTAULERxNTAULER
        //cuc = new int[2];                    // array[2]--> (x,y) del cuc
        fulles = new int[NFULLES][2];        // array[NFULLES][2] --> (x,y) de cada fulla
        
        cuc = UtilitatsJocs.posicioInicial(tauler);  // situa el cuc en una coor. inicial

        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            accio=UtilitatsConsola.llegirSencer("ACCIONS: 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            
            cuc = UtilitatsJocs.cambiarPosicioCuc(tauler, cuc, accio);

        } while (accio!=0);
    }
}
