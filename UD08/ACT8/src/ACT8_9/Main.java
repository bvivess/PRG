package ACT8_9;

// Classe principal per provar el sistema
public class Main {
    public static void main(String[] args) {
        PrimerPlat primer = new PrimerPlat("Amanida", 6.5, true);
        SegonPlat segon = new SegonPlat("Entrecot", 18.0, true);
        Postre postre = new Postre("Pastís de formatge", 5.0, false);

        Menu menu = new Menu("Menú Especial", primer, segon, postre);
        System.out.println(menu);
    }
}

