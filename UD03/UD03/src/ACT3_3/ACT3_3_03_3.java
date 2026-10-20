package ACT3_3;

/**
 * Escriu un programa que declari un array d 'int' de 10 posicions amb els següents valors: 
 * 
 * int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * El nombre més gran de l'array.
 *
 * @author Tomeu Vives
 */
public class ACT3_3_03_3 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        int suma = 0;
        
        for (int a : array) {
            suma += a;
        }
        
        System.out.println("La suma és: " + suma);
    }
}
