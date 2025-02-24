package EX2_2;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("Pere","Martí","2");
        Client client = new Client("Joana","Garcia","Cerrer del pi");
        Moderador moderador = new Moderador("Aina","Mas", "Carrer del pla");
        
        System.out.println(client.metodePerDefecte());
        System.out.println(admin.metodePerDefecte());
        System.out.println(moderador.metodePerDefecte());
    }
    
}
