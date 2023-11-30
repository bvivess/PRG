package ACT7_1;

import java.util.ArrayList;

/**
 *
 * @author T.Vives
 */
public class Institut {
    private String idInstitut;
    private String nom;
    private ArrayList<Modul> cicles;

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
            
            // Institut
            Institut institut = new Institut("ED", "Emili Darder");
            institut.afegeixCicle(cicle1);
            
            
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

    // Constructors
    public Institut(String idInstitut, String nom) {
        this.idInstitut = idInstitut;
        this.nom = nom;
        this.cicles = new ArrayList<>(cicles);
    }
    
    public Institut(String idInstitut, String nom, ArrayList<Modul> cicles) {
        this.idInstitut = idInstitut;
        this.nom = nom;
        this.cicles = cicles;
    }
    
    // Mòduls
    public void afegeixCicle(Modul nouCicle) {
        this.cicles.add(nouCicle);
    }
    
    // Getters i setters
    public String getIdInstitut() {
        return idInstitut;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Modul> getCicles() {
        return cicles;
    }

    public void setIdInstitut(int idInstitut) {
        this.idInstitut = idInstitut;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCicles(ArrayList<Modul> cicles) {
        this.cicles = cicles;
    }
        
}
