package ACT4_5;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class UtilitatsJocs {
   public static void mostrarTauler(int[][] matriu, int posicio) {
        String car;
        for (int i = 0; i < matriu.length; i++) {
            System.out.print('|');
            for (int j = 0; j < matriu[i].length; j++) {
                if (matriu[i][j] == 0) {
                    car = "   ";
                } else if (matriu[i][j] == 1) {
                    car = " . ";
                } else if (matriu[i][j]==99) {
                    car = " * ";
                } else if (matriu[i][j]==posicio) {
                    car = " O ";
                } else {
                    car = " - ";
                }
                System.out.print(car);
            }
            System.out.println("|");
        }
    }
   
    public static ArrayList<Integer[]> posicioInicial(int[][] tauler) {
        final int minim = 0, maxim = tauler.length-1;
        ArrayList<Integer[]> objecte = new ArrayList<Integer[]>();

        
        Integer[] pos = {(minim + (int) (Math.random() * (maxim - minim + 1))),
                         (minim + (int) (Math.random() * (maxim - minim + 1)))
                        };
        objecte.add(pos);  // afegir la posició al cuc
        
         // situar el cuc al tauler
        for (Integer[] o : objecte) {
            tauler[o[0]][o[1]] = 9;
        }
        
        return objecte;
    }
    
    public static ArrayList<Integer[]> cambiarPosicioCuc(int[][] tauler, ArrayList<Integer[]> cuc, int accio) {
        int mida = tauler.length;
        Integer[] pCuc = cuc.get(0); // posició del cuc
        
        tauler[pCuc[0]][pCuc[1]] = 0;
        switch (accio) {
            case 4 -> // ESQ
                pCuc[1] = (pCuc[1]==0 ? mida-1 : pCuc[1]-1); 
            case 6  -> // DRETA
                pCuc[1] = (pCuc[1]==mida-1 ? 0 : pCuc[1]+1); 
            case 8  -> // ALT
                pCuc[0] = (pCuc[0]==0 ? mida-1 : pCuc[0]-1); 
            case 2 -> //BAIX
                pCuc[0] = (pCuc[0]==mida-1 ? 0 : pCuc[0]+1); 
        }

        tauler[pCuc[0]][pCuc[1]] = 9;
        cuc.set(0, pCuc);
        return cuc;
    }
}
