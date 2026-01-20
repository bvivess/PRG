package ACT7_1;

import java.util.ArrayList;
import java.util.Objects;

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
        this.setIdInstitut(idInstitut);
        this.setNom(nom);
        this.cicles = new ArrayList<>();
    }
    
    public Institut(String idInstitut, String nom, ArrayList<Cicle> cicles) {
        this.idInstitut = idInstitut;
        this.nom = nom;
        this.cicles = cicles;
    }
    
    // Mètodes específics
   
    /**
     * Afegeix un cicle en l'Arralist de Institut
     * @param nouCicle 
     */
    public void afegeixCicle(Cicle nouCicle) {
        this.cicles.add(nouCicle);
    }
    
    private int cercaCicle(String nom) {
        return this.cicles.indexOf( new Cicle(0, nom, 0 ) );
    }
    
    public boolean eliminaCicle(String nom) {
        return this.cicles.remove( new Cicle(0, nom, 0 ) );
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
   
    /**
     * Mostra els atributs de la classe
     * @return String amb les dades concatenades
     */
    public String toString() {
        String text;
        
        text = "Institut " + "ID=" + idInstitut + ", nom=" + nom + "; \n" + "Cicles: {";
        for (Cicle c: cicles) {
            text = text + "\n\t" + c.toString();
        }
        text = text +"}";
        
        return text;
    }        
}
