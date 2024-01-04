package Prova;

import Prova.Empleat;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleat e = new Empleat("prova");
        System.out.println(e.nom + " " + Empleat.souBase);
    }
    
}
