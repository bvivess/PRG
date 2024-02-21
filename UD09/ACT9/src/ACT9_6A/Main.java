package ACT9_6A;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        Telefon telefon = new Telefon("iPhone", 1200.0, 15.0, 8, 5);
        Portatil portatil = new Portatil("Dell XPS", 1500.0, 18.0, 12, 15);
        Televisor televisor = new Televisor("Samsung 4K", 800.0, 30.0, 36, 55);

        Client client = new Client("Maria", "Gomez", telefon, portatil, televisor);

        System.out.println("Dades del client:");
        System.out.println("Nom: " + client.getNom());
        System.out.println("Cognom: " + client.getCognom());
        System.out.println("Telefon: " + client.getTelefon());
        System.out.println("Portatil: " + client.getPortatil());
        System.out.println("Televisor: " + client.getTelevisor());
        System.out.println("Descompte total: " + client.calcularDescompteTotal());
        
    }
}
