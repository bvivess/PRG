package ex_final;

import ex_final.Utils.Gestor;
import ex_final.Classes.*;

public class Main {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        String path = "c:\\temp\\people.cvs";
        
        try {
            // CÀRREGA DADES
            gestor.carregaDadesBBDD();
            
            
            // MOSTRA DADES
            gestor.mostraDades();
            
            // DESCÀRREGA DADES
            System.out.println("DESCÀRREGA DADES");
            gestor.descarregaDadesCVS(path);
            System.out.println("Fet...");
        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}
