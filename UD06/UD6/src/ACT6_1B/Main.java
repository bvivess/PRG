package ACT6_1B;

/**
 *
 * @author T.Vives
 */
public class Main {

    public static void main (String[] args) {
        // Mòduls DAW
        Modul modul1 = new Modul(Modul.getComptadorModuls(), "Programació", 7);
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        Modul modul2 = new Modul(Modul.getComptadorModuls(), "Gestió de Base de Dades", 8);
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        Modul modul3 = new Modul(Modul.getComptadorModuls(), "Llenguatge de Marques", 4);
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        Modul modul4 = new Modul(Modul.getComptadorModuls(), "Sistemes d'Informació", 7);
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        Modul modul5 = new Modul(Modul.getComptadorModuls(), "Entorns de Desenvolupament", 3);
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        // Mòduls d'ASIX
        // ...
        // Mòduls d'SMX
        // ...

        // Cicle DAW
        Cicle cicle1 = new Cicle(Cicle.getComptadorCicles(), "Desenvolupament Aplicacions Web", 25);
        Cicle.setComptadorCicles(Cicle.getComptadorCicles()+1);
        cicle1.afegeixModul(modul1);
        cicle1.afegeixModul(modul2);
        cicle1.afegeixModul(modul3);
        cicle1.afegeixModul(modul4);
        cicle1.afegeixModul(modul5);

        // Cicle ASIX
        Cicle cicle2 = new Cicle(Cicle.getComptadorCicles(), "Administració de sistemes en xarxa", 25);
        Cicle.setComptadorCicles(Cicle.getComptadorCicles()+1);
        cicle2.afegeixModul(new Modul(Modul.getComptadorModuls(), "Planificació i Administració de Xarxes", 5));
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        cicle2.afegeixModul(new Modul(Modul.getComptadorModuls(), "Bases de Dades", 7));
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        cicle2.afegeixModul(new Modul(Modul.getComptadorModuls(), "Implantació de S.O.", 3));
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        cicle2.afegeixModul(new Modul(Modul.getComptadorModuls(), "Fonaments de Hasdware", 5));
        Modul.setComptadorModuls(Modul.getComptadorModuls()+1);
        
        // Cicle SMX
        Cicle cicle3 = new Cicle(Cicle.getComptadorCicles(), "Sistemes Micronformàtics i Xarxes", 25);
        // ...

        // Institut 'Emili Darder'
        Institut institut = new Institut("IED","Emili Darder");
        institut.afegeixCicle(cicle1);
        institut.afegeixCicle(cicle2);
        institut.afegeixCicle(cicle3);
        
        // Mostrar
        System.out.println(institut.mostraInstitut());
            
    }
}
