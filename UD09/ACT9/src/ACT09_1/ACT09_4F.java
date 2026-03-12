package ACT09_1;

public class ACT09_4F {
    public static void main(String[] args) {

        try {
            try {
                int[] v = {1,2,3};
                System.out.println(v[5]);
            }
            catch (ArithmeticException e) {
                System.out.println("Error aritmètic");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("L'error no s'ha capturat dins");
            System.out.println("Capturat al nivell superior");
        }

    }
}
