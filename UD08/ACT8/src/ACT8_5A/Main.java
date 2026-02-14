package ACT8_5A;

/**
    |-- src
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
    |-- Main.java

 * @author winadmin
 */


public class Main {

    public static void main(String[] args) {
        CompteEstalvis compteEstalvis = new CompteEstalvis("0001-0001-0001", "CompteEstalvis1", 0, 0, 1000);
        compteEstalvis.afegirTarjeta(new Credit("000-0000-0000-0001",0,1000,1000,0));
        compteEstalvis.afegirTarjeta(new Credit("000-0000-0000-0001",0,1000,1000,0));  // Duplicada, no l'afegeix
        compteEstalvis.afegirTarjeta(new Debit("000-0000-0000-0002",0,1000,1000,0));
        compteEstalvis.eliminaTarjeta("000-0000-0000-0002");
        
        Persona persona = new Persona("Joana Moragues", 27);
        persona.afegirProducteBancari(compteEstalvis);
        
        persona.afegirProducteBancari(new Diposit("0001-0001-0002", "Deposit1", 100, 2.5, 10));
        persona.afegirProducteBancari(new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10));
        persona.afegirProducteBancari(new Hipoteca("0001-0001-0003", "Hipoteca1", 100, 5, 1, 10));  // Duplicada, no l'afegeix
        persona.eliminaProducteBancari("0001-0001-0003");
        persona.afegirProducteBancari(new FonsInversio("0001-0001-0004", "FonsInversio1", 100, 5, 1, 10));
        
        System.out.println(persona.toString() + "\n Total Remuneració: " + persona.calculaRemuneracioTotal());
    }
    
}
