package ACT09_1;

public class ACT09_4F {
    public static void main(String[] args) {

        try {
            try {
                int[] v = {1,2,3};
                System.out.println(v[5]);
                System.out.println("linea 0");
            } catch (ArithmeticException e) {
                System.out.println("Error aritmètic");
            }
            System.out.println("linia 1");
        } catch (ArithmeticException e) {
            System.out.println("L'error no s'ha capturat dins");
        } catch (Exception e) {
            System.out.println("Capturat al nivell superior");
        }
    }
}
