package ACT4_4;

import ACT4_1.UtilitatsArrays;
import ACT4_2.UtilitatsMatrius;
import ACT4_3.UtilitatsConsola;

 /**
  * Crea una classe que inicialitzi una matriu quadrada, pe 5x5:
  *      Mostra-la per pantalla, cada fila a una línia.
  */
public class ACT4_4_1 {
     /**
     *
     * @param args Els arguments passats per la línia de comandes
     */
    public static void main(String[] args) {
        final int MIDA=5;
        String[] alumnes = new String [MIDA];
        int[][] notes = UtilitatsMatrius.generaMatriu(MIDA, 0, 10);

        for (int i=0; i<alumnes.length; i++){
            alumnes[i] = UtilitatsConsola.llegirCadena("Nom de l'alumne: ");
        }
        
        // Mostra la alumnes i notes
        for (int i=0; i<alumnes.length; i++){
            System.out.print(alumnes[i] + ": ");
            UtilitatsArrays.mostraArray(notes[i]);
            System.out.println(UtilitatsArrays.mitjanaArray(notes[i]));
            System.out.println("----------");
        }
    }
}
