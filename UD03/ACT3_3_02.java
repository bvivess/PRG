package arrays;

/**2. Escriu una classe que crei un vector de 10 sencers, els inicialitzi 
 * aleatòriament de 100 a 200 i els mostri per pantalla.
 * 
 * @author joan
 */
public class ACT3_3_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vector = new int[10];
        for (int index = 0; index < vector.length; index++) {
            vector[index] = 100 + (int)(Math.random() * 101) ;
        }

        //Mostrar-los per pantalla
        for (int index = 0; index < vector.length; index++) {
            System.out.print(vector[index] + "\t");
        }
        System.out.println();
    }
}
