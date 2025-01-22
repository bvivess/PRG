package ACT6_1A;

/**
 *
 * @author T.Vives
 */
public class Institut {

    public static void main (String[] args) {
        // Cicle
        Cicle cicle = new Cicle(1, "Desenvolupament Aplicacions Web", 25);

        // Mòduls DAW
        Modul modul1 = new Modul(1, "Programació", 1, 7);
        Modul modul2 = new Modul(2, "Gestió de Base de Dades", 1, 8);
        Modul modul3 = new Modul(3, "Llenguatge de Marques", 1, 4);
        Modul modul4 = new Modul(4, "Sistemes d'Informació", 1, 7);
        Modul modul5 = new Modul(5, "Entorns de Desenvolupament", 1, 3);
        // Mòduls d'ASIX
        // ...
        // Mòduls d'SMX
        // ...

        // Mostrar
        System.out.println(cicle.mostraCicle());
        System.out.println("\t"+modul1.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul2.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul3.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul4.mostraModul(cicle.getIdCicle()));
        System.out.println("\t"+modul5.mostraModul(cicle.getIdCicle()));
        
        // Falta afegir els mòduls d'ASIX i SMX
        // ...

    }
}
