package ACT10_0R;

public class Main {

    public static void main(String[] args) {
        mostrar("Hola");
        mostrar(10);
        mostrar(3.14);
    }
    
    public static <T> void mostrar(T element) {
        System.out.println(element);
    }

}

