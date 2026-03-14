    package ACT09_1;


public class ACT09_4D {
    public static void main(String[] args) {
        try {
            comprovarEdat(16);
        }
        catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void comprovarEdat(int edat) {
        if(edat < 18) {
            throw new IllegalArgumentException("Edat insuficient");
        }

        System.out.println("Accés permès");
    }
}