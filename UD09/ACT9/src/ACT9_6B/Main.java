package ACT9_6B;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Producte> productes = new ArrayList<>();
        
        productes.add(new Telefon("iPhone", 1200.0, 15.0, 8, 5, "Snapdragon", 16, 128));
        productes.add(new Portatil("Dell XPS", 1500.0, 18.0, 12, 15, "Intel i5",16, 512));
        productes.add(new Televisor("Samsung 4K", 800.0, 30.0, 36, 55, "Snapdragon",16, 256));
        productes.add(new Gelera('A', "Edesa no Frost", 500.0, 150.0, 24));
        productes.add(new Rentavaixelles('B', "Electrolux", 450.0, 200.0, 24));
        productes.add(new Rentadora('C', "AEG", 375.0, 175.0, 24,8));
        Client client = new Client("Pere", "Gómez", productes);

        System.out.println(client.toString());
        
    }
}
