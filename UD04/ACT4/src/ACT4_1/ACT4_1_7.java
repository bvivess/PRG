package ACT4_1;


public class ACT4_1_7 {
    public static void main(String[] args) {
        int[] array = UtilitatsArrays.generaArray(3,1,100);

        UtilitatsArrays.mostraArray(array);
        if (UtilitatsArrays.ordenaArray2(array)) {
            UtilitatsArrays.mostraArray(array);
        } else {
            System.out.println("L'array no es pot ordenar");
        }
    }
}