package ACT6_1;

import java.util.ArrayList;

/**
* Representa cada un dels cicles existents en un institut
 * @author T.Vives
 */
public class Institut {
    private String idInstitut;
    private String nom;
    private ArrayList<Cicle> cicles;

    // Constructors
    public Institut(String idInstitut, String nom) {
        this.idInstitut = idInstitut;
        this.nom = nom;
        this.cicles = new ArrayList<>();
    }
    
    public Institut(String idInstitut, String nom, ArrayList<Cicle> cicles) {
        this.idInstitut = idInstitut;
        this.nom = nom;
        this.cicles = new ArrayList<>(cicles);
    }
    
    // Mètodes específics
    /**
     * Afegeix un cicle en l'Arralist de Institut
     * @param nouCicle 
     */
    public void afegeixCicle(Cicle nouCicle) {
        this.cicles.add(nouCicle);
    }
    
    /**
     * Mostra els atributs de la classe
     * @return String amb les dades concatenades
     */
    public String mostraInstitut() {
        String text;
        
        text = "Institut " + "ID=" + idInstitut + ", nom=" + nom + "; Cicles: {";
        for (Cicle c: cicles) {
            text = text + c.mostraCicle();
        }
        text = text +"}";
        
        return text;
    }
    
    // Getters i setters
    public String getIdInstitut() {
        return idInstitut;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Cicle> getCicles() {
        return cicles;
    }

    public void setIdInstitut(String idInstitut) {
        this.idInstitut = idInstitut;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCicles(ArrayList<Cicle> cicles) {
        this.cicles = cicles;
    }
        
}
