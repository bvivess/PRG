package ACT6_1;

/**
 *
 * @author T.Vives
 */
public class Main {
    
    public static void main(String[] args) {
        new Main().inici();
    }

    public void inici() {
        try {
            // M�duls DAW
            Modul modul1 = new Modul("Programaci�",7);
            Modul modul2 = new Modul("Gesti� de Base de Dades",8);
            Modul modul3 = new Modul("Llenguatge de Marques",4);
            Modul modul4 = new Modul("Sistemes d'Informaci�",7);
            Modul modul5 = new Modul("Entorns de Desenvolupament",3);
            // M�duls d'ASIX
            // ...
            // M�duls d'SMX
            // ...

            // Cicle DAW
            Cicle cicle1 = new Cicle("Desenvolupament Aplicacions Web",25);
            cicle1.afegeixModul(modul1);
            cicle1.afegeixModul(modul2);
            cicle1.afegeixModul(modul3);
            cicle1.afegeixModul(modul4);
            cicle1.afegeixModul(modul5);

            // Cicle ASIX
            Cicle cicle2 = new Cicle("Administraci� de sistemes en xarxa",25);
            // ...

            // Cicle SMX
            // ...
            
            // Institut
            Institut institut = new Institut("ED", "Emili Darder");
            institut.afegeixCicle(cicle1);

            // Mostrar
            System.out.println(institut.mostraInstitut());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
}

