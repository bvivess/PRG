package ACT8_5;

import ACT8_5.Classes.*;
import ACT8_5.Productes.*;
import ACT8_5.Tarjetes.*;

/**
    |-- src
        Main.java
        |-- Productes
            |-- ProducteBancari.java
            |-- CompteEstalvis.java
            |-- Deposit.java
            |-- Hipoteca.java
            |-- FonsInversio.java
        |-- Tarjetes
            |-- Tarjeta.java
            |-- Credit.java
            |-- Debit.java
        |-- Classes
            |-- Persona.java

 */

public class Main {

    public static void main(String[] args) {
        CompteEstalvis compteEstalvis = new CompteEstalvis("0001-0001-0001", "CompteEstalvis1", 0, 0, 1000);
        compteEstalvis.afegeixTarjeta(new Credit("000-0000-0000-0001",0,1000,1000,0));
        compteEstalvis.afegeixTarjeta(new Credit("000-0000-0000-0001",0,1000,1000,0));  // Duplicada, no l'afegeix
        compteEstalvis.afegeixTarjeta(new Debit("000-0000-0000-0002",0,1000,1000,0));
        compteEstalvis.eliminaTarjeta("000-0000-0000-0002");
        
        Persona persona = new Persona("Joana Moragues", 27);
        persona.afegeixProducteBancari(compteEstalvis);
        persona.afegeixProducteBancari(new Diposit("0001-0001-0002", "Deposit1", 100, 2.5, 10));
        persona.afegeixProducteBancari(new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10));
        persona.afegeixProducteBancari(new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10));  // Duplicada, no l'afegeix
        persona.eliminaProducteBancari("0001-0001-0003");
        persona.afegeixProducteBancari(new FonsInversio("0001-0001-0004", "FonsInversio1", 100, 5, 1, 10));
        
        System.out.println(persona.toString() + "\n Total Remuneració: " + persona.calculaRemuneracioTotal());
    }
    
}
