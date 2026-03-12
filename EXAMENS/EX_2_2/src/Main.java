public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3};       
        
        try {
            System.out.println(10/0);
            System.out.println("Adeu");
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Adeu");
        }
    }
}