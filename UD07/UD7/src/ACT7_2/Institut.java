package ACT7_2;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Institut {
    private int idInstitut;
    private String nom;
    

    public static void main (String[] args) {
        try {
            
            // Mòduls DAW
            Modul modul1 = new Modul("Programació",7);
            Modul modul2 = new Modul("Gestió de Base de Dades",8);
            Modul modul3 = new Modul("Llenguatge de Marques",4);
            Modul modul4 = new Modul("Sistemes d'Informació",7);
            Modul modul5 = new Modul("Entorns de Desenvolupament",3);
            // Mòduls d'ASIX
            // ...
            // Mòduls d'SMX
            // ...
            
            // Cicle DAW
            Cicle cicle1 = new Cicle("Desenvolupament Aplicacions Web",25);
            cicle1.afegeixModul(modul1);
            cicle1.afegeixModul(modul2);
            cicle1.afegeixModul(modul3);
            cicle1.afegeixModul(modul4);
            cicle1.afegeixModul(modul5);
            
            // Cicle ASIX
            Cicle cicle2 = new Cicle("Administració de sistemes en xarxa",25,new ArrayList<Modul>());
            // ...
            
            // Cicle SMX
            // ...

            // Mostrar
            System.out.println(cicle1.mostraCicle());
            System.out.println(cicle2.mostraCicle());
            // System.out.println(cicl3.mostraCicle());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
