package ACT5_0C;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        int[][] tauler = new int[8][8];
        ArrayList<Posicio> cuc = new ArrayList<>();  // cada segment del cuc està és un element de l'ArrayList	

        Posicio segment1 = new Posicio();
        segment1.fila = 2;
        segment1.columna = 3;
        cuc.add(segment1);  // l'objecte 'cuc' té un primer segment en la 'fila'=2 i 'columna'=3
        
        Posicio segment2 = new Posicio();
        segment2.fila = 2;
        segment2.columna = 4;
        cuc.add(segment2);  // l'objecte 'cuc' té un segon segment en la 'fila'=2 i 'columna'=4
        // ...
    }

}