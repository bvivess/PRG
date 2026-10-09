package ACT3_3;

/**
 * 1. Escriu un programa que declari un array d 'int' de 10 posicions amb els
 * següents valors: int [] array = {1, 3, 5, 7, 8, 9, 6};
 *
 * La quantitat de nombres majors que 10
 *
 * @author Tomeu Vives
 */
public class ACT3_3_08 {

    public static void main(String[] args) {
        int [] array = {1, 3, 5, 7, 8, 9, 6};
        int total = 0;
        
        for (int a : array) {
            if (a > 10) 
                total++;
        }
        
        System.out.println("El total >10 és: : " + total );
    }
}
