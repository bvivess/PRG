package ACT8_3;

// Clase principal Main
public class Main {
    public static void main(String[] args) {
        Llibre llibre = new Llibre("Java Programming", 2020, 35.0, "John Smith");
        Revista revista = new Revista("Tech Magazine", 2021, 10.0, 25);

        // Array de Publicacions
        Publicacio[] publicacions = {llibre, revista};

        // Polimorfismo
        for (Publicacio p : publicacions) {
            System.out.println(p.toString());
            System.out.println("Precio: $" + p.calculaPrecio());
            System.out.println("--------------");
        }
    }
}



