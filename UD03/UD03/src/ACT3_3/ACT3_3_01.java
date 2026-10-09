package ACT3_3;

/**
 * 1. Escriu un programa que declari un array d 'int' de 10 posicions amb els
 * següents valors: int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * Per a cada element, mostra si és parell o senar
 *
 * @author Tomeu Vives
 */
public class ACT3_3_01 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        
        for (int a : array) {
            if (a%2 ==0)
                System.out.println(a + " és parell");
            else
                System.out.println(a + " és senar");
        }

    }
}
