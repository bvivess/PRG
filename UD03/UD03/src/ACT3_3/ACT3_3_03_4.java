package ACT3_3;

/**
 * Escriu un programa que declari un array d 'int' de 10 posicions amb els següents valors: 
 * 
 * int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * La mitjana dels nombres
 *
 * @author Tomeu Vives
 */
public class ACT3_3_03_4 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        int total = 0, suma = 0;
        
        for (int a : array) {
                total++;
                suma += a;

        }
        
        System.out.println("El mitjana és: " + ((float) suma/total) );
    }
}
