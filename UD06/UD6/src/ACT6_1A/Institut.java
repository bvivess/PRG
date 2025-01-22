package ACT6_1A;

/**
 *
 * @author T.Vives
 */
public class Institut {

    public static void main (String[] args) {
        // Cicle
        Cicle cicle = new Cicle(1, "Desenvolupament Aplicacions Web", 25);

        // M�duls DAW
        Modul modul1 = new Modul(1, "Programaci�", 1, 7);
        Modul modul2 = new Modul(2, "Gesti� de Base de Dades", 1, 8);
        Modul modul3 = new Modul(3, "Llenguatge de Marques", 1, 4);
        Modul modul4 = new Modul(4, "Sistemes d'Informaci�", 1, 7);
        Modul modul5 = new Modul(5, "Entorns de Desenvolupament", 1, 3);
        // M�duls d'ASIX
        // ...
        // M�duls d'SMX
        // ...

        // Mostrar
        System.out.println(cicle.mostraCicle());
        System.out.println("\t"+modul1.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul2.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul3.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul4.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul5.mostraModul(cicle.getIdCicle()));
        
        // Falta afegir els m�duls d'ASIX i SMX
        // ...

    }
}
