package PROVA;

import java.util.Objects;


public class Persona implements Comparable<Persona> {
    private String nom;
    private int edat;

    public Persona(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nom);
        hash = 89 * hash + this.edat;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.edat != other.edat) {
            return false;
        }
        return Objects.equals(this.nom, other.nom);
    }

    @Override
    public int compareTo(Persona o) {
        return this.getNom().compareTo(o.getNom());
    }



    

    @Override
    public String toString() {
        return "Persona{" + "nom=" + nom + ", edat=" + edat + '}';
    }
    
    
}

