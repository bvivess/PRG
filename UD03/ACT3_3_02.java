/**2. Escriu una classe que crei un array de 10 sencers, els inicialitzi 
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
        int[] array = new int[10];
		
        for (int index = 0; index < array.length; index++) {
            array[index] = MIN + (int) (Math.random() * ((MAX - MIN) + 1)) ;
        }

        //Mostrar-los per pantalla
		System.out.print("[ ");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("]");
    }
}
