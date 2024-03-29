package com.mycompany.mavenproject1;

import java.util.List;

/**
 *
 * @author winadmin
 */
public class Persona {
    private int idPersona;
    private String nom;
    private String llinatge;
    private int edat;
    private List<String> aficions;
  
    
    // Getters y Setters

    public int getIdPersona() {
        return idPersona;
    }

    public String getNom() {
        return nom;
    }

    public String getLlinatge() {
        return llinatge;
    }

    public int getEdat() {
        return edat;
    }

    public List<String> getAficions() {
        return aficions;
    }

    
}

