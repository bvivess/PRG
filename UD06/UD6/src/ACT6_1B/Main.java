package ACT6_1B;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Main {
    
    public static void main(String[] args) {
        new Main().inici();
    }

    public void inici() {
        // Mòduls DAW
        Modul modul1 = new Modul("Programació",7);
        Modul modul2 = new Modul("Gestió de Base de Dades",8);
        Modul modul3 = new Modul("Llenguatge de Marques",4);
        Modul modul4 = new Modul("Sistemes d'Informació",7);
        Modul modul5 = new Modul("Entorns de Desenvolupament",3);

        // Mòduls d'ASIX
        Modul modu21 = new Modul("Planificació i adm. xarxes",7);
        Modul modu22 = new Modul("Gestió de Base de Dades",8);
        Modul modu23 = new Modul("Llenguatge de Marques",4);
        Modul modu24 = new Modul("Implantació Sistemes operatius",7);
        
        // Mòduls d'SMX
        // ...

        // Cicle DAW
        Cicle cicle1 = new Cicle("Desenvolupament Aplicacions Web",25);  // constructor complet, v1
        cicle1.afegeixModul(modul1);
        cicle1.afegeixModul(modul2);
        cicle1.afegeixModul(modul3);
        cicle1.afegeixModul(modul4);
        cicle1.afegeixModul(modul5);

        // Cicle ASIX
        ArrayList<Modul> modulsASIX = new ArrayList<>();
        modulsASIX.add(modu21);
        modulsASIX.add(modu22);
        modulsASIX.add(modu23);
        modulsASIX.add(modu24);
        Cicle cicle2 = new Cicle("Administració de sistemes en xarxa",25, modulsASIX);  // constructor complet, v2

        // Cicle SMX
        // ...

        // Institut
        Institut institut = new Institut("ED", "Emili Darder");
        institut.afegeixCicle(cicle1);
        institut.afegeixCicle(cicle2);

        // Mostrar
        System.out.println(institut.mostraInstitut());

    }
 
}

