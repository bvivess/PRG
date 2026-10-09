package ACT3_3;

/**
 * 1. Escriu un programa que declari un array d 'int' de 10 posicions amb els
 * següents valors: int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * Si existeix algun element senar en l'array
 *
 * @author Tomeu Vives
 */
public class ACT3_3_02 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        boolean existeixSenar = false;
        
        for (int a : array) {
            if (a%2 == 1) {
                existeixSenar = true;
                break;
            }
        }
        
        System.out.println(existeixSenar);
    }
}
