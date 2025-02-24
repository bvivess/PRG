package EX2_2;

public class GestorUsuaris {
    public void enviarNotificacio(UsuariBase usuari, String missatge) {
        System.out.println("📩 Enviant notificació a ");

        if (usuari instanceof Admin) {
            System.out.println("[ADMIN] " + missatge.toUpperCase()); // Missatge destacat per a admins
        } else if (usuari instanceof Moderador) {
            System.out.println("[MODERADOR] " + missatge + " (Revisió necessària)");
        } else if (usuari instanceof Client) {
            System.out.println("[CLIENT] " + missatge);
        } else {
            System.out.println("[GENÈRIC] " + missatge);
        }

        System.out.println(); // Saltem línia per claredat
    }
}