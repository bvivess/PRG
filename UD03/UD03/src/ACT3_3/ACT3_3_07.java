package ACT3_3;

/**
 * 1. Escriu un programa que declari un array d 'int' de 10 posicions amb els
 * següents valors: int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * La posició del primer element que sigui igual a 7, si existeix. Sino, mostra -1.
 *
 * @author Tomeu Vives
 */
public class ACT3_3_07 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        int posicio = -1;
        
        for (int i=0; i< array.length; i++) {
            if (array[i] == 7) {
                posicio = i;
                break;
            }
        }
        
        System.out.println("La posició és: : " + posicio );
    }
}
