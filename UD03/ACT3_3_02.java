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
		final int MAX = 200;
		final int MIN = 100;
        int[] vector = new int[10];
		
        for (int index = 0; index < vector.length; index++) {
            vector[index] = MIN + (int) (Math.random() * ((MAX - MIN) + 1)) ;
        }

        //Mostrar-los per pantalla
        for (int index = 0; index < vector.length; index++) {
            System.out.print(vector[index] + "\t");
        }
        System.out.println();
    }
}
