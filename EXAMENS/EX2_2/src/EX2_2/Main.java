package EX2_2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 4.1
        Admin admin = new Admin("Pere","Martí","2");
        Client client = new Client("Joana","Garcia","Cerrer del pi");
        Moderador moderador = new Moderador("Aina","Mas", "Carrer del pla");
        
        // 4.2
        ArrayList<UsuariBase> usuaris = new ArrayList<UsuariBase>();
        usuaris.add(admin);
        usuaris.add(client);
        usuaris.add(moderador);
        
        // 4.4
        for (UsuariBase u : usuaris)
            System.out.println(mostrarTipusUsuari(u));

        // 3
        System.out.println(admin.metodePerDefecte());        
        System.out.println(client.metodePerDefecte());
        System.out.println(moderador.metodePerDefecte());
    }
    
    // 4.3
    private static String mostrarTipusUsuari(UsuariBase usuari) {
        String text;

        if (usuari instanceof Admin) {
            text = "Sóc un ADMIN";
        } else if (usuari instanceof Moderador) {
            text = "Sóc un MODERADOR";
        } else if (usuari instanceof Client) {
            text = "Sóc un CLIENT";
        } else {
            text = "No estic definit";
        }

        return text;
    }
    
}
