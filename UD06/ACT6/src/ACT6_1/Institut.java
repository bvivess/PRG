package ACT6_1;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Institut {

    public static void main (String[] args) {
        try {
            ArrayList<Modul> moduls;
            
            Cicle cicle = new Cicle("Desenvolupament Aplicacions Web", 25);
            Modul modul1 = new Modul("Programació", 7);
            Modul modul2 = new Modul("Gestió de Base de Dades", 8);
            Modul modul3 = new Modul("Llenguatge de Marques", 4);
            Modul modul4 = new Modul("Sistemes d'Informació", 8);
            Modul modul5 = new Modul("Entorns de Desenvolupament", 4);
            
            cicle.afegeixModul(modul1);
            cicle.afegeixModul(modul2);
            cicle.afegeixModul(modul3);
            cicle.afegeixModul(modul4);
            cicle.afegeixModul(modul5);
            
            
            System.out.println(cicle.mostraCicle() );
            if (cicle.eliminarModul("Programació")) {
                System.out.println("Programació eliminat");
            }
            System.out.println(cicle.mostraCicle() );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
