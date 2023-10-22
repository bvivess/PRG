package ACT4_4;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_4_2 {
     /**
     *
     * @param posicio
     * @param car
     * @param mida
     * @return args Els arguments passats per la línia de comandes
     */
    
    public static int[] cambiarPosicio(int[] posicio, int car, int mida) {
        switch (car) {
            case 4 -> // ESQ
                posicio[1] = (posicio[1]==0 ? mida-1 : posicio[1]-1); 
            case 6  -> // DRETA
                posicio[1] = (posicio[1]==mida-1 ? 0 : posicio[1]+1); 
            case 8  -> // ALT
                posicio[0] = (posicio[0]==0 ? mida-51 : posicio[0]-1); 
            case 2 -> //BAIX
                posicio[0] = (posicio[0]==mida-1 ? 0 : posicio[0]+1); 
        }
        return posicio;
    }
    
    public static void main(String[] args) {
        final int MIDA=UtilitatsConsola.llegirSencer("Mida del tauler: ");
        int[][] tauler = UtilitatsMatrius.generaMatriu(MIDA, 0, 1);
        int[] posicio = UtilitatsArrays.generaArray(2,0,MIDA-1);
        int puntuacio=0, nmoviments=0;
        int car;

        tauler[posicio[0]][posicio[1]] = 9;
        UtilitatsArrays.mostraArray(posicio);
        
        do {
            UtilitatsMatrius.mostrarMatriu(tauler);
            car=UtilitatsConsola.llegirSencer("Puntuació: " + (float) puntuacio/nmoviments +  " | 8:ALT, 4:ESQUERRA, 6:DRETA, 2:BAIX; 0:SORTIR: ");
            tauler[posicio[0]][posicio[1]] = 0;
            posicio = cambiarPosicio(posicio, car, MIDA);
            puntuacio = puntuacio + ((tauler[posicio[0]][posicio[1]] == 1)? 1:0);
            tauler[posicio[0]][posicio[1]] = 9;
            nmoviments++;
        } while (car!=0);
    }
}
