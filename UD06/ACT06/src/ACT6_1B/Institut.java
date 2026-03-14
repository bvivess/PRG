package ACT6_1B;

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
     * Mostra els atributs de la classe
     * @return String amb les dades concatenades
     */
    public String mostraInstitut() {
        String text;
        
        text = "Institut " + "ID=" + idInstitut + ", nom=" + nom + "; \n" + "Cicles: {";
        for (Cicle c: cicles) {
            text = text + "\n\t" + c.mostraCicle();
        }
        text = text +"}";
        
        return text;
    }
    
    /**
     * Afegeix un cicle en l'Arralist de Institut
     * @param nouCicle 
     */
    public void afegeixCicle(Cicle nouCicle) {
        this.cicles.add(nouCicle);
    }
    
    private int cercaCicle(String nom) {
        for (int i=0; i < this.cicles.size(); i++) {
            if (this.cicles.get(i).getNom().equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean eliminaCicle(String nom) {
        int i = this.cercaCicle(nom);
        
        if (i >= 0) {
            this.cicles.remove(i);
            return true;
        }
        return false;
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
        
}
