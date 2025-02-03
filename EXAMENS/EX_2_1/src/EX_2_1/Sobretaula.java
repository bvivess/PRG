package EX_2_1;

import java.util.ArrayList;

class Sobretaula extends Dispositiu {
    protected String factorForma;
    protected ArrayList<Complement> complements;

    public Sobretaula(String marca, String model, float preuDispositiu, String factorForma) {
        super(marca, model, preuDispositiu);
        setFactorForma(factorForma);
        this.complements = new ArrayList<>();
    }

    public boolean afegeixComplement(Complement c) {
        if (!(this.complements.contains(c))) {
            complements.add(c);
            return true;
        } else
            return false;
    }
    
    public Complement cercaComplement(String s) {
        for (Complement c : this.complements) {
            if (c.getNom().equals(s))
                return c;
        }
        return null;
    }
    
    public boolean eliminaComplement(Complement c) {
        return complements.remove(c);
    }
    
    public float calculaPreu() {
        float preuTotal=super.calculaPreu();
        
        preuTotal += (this.factorForma.equals("ATX") ? 10 : 
                        this.factorForma.equals("microATX") ? 5 : 20);
        
        for (Complement c : this.complements)
            preuTotal += c.getPreu();
        return preuTotal;
    }

    public void setFactorForma(String factorForma) {
        if (factorForma.equals("ATX") || factorForma.equals("microATX") || factorForma.equals("extendedATX"))
            this.factorForma = factorForma;
        else {
            this.factorForma = "";
            System.err.println("Error, 'factorForma' incorrecte");
        }
    }
    
    @Override
    public String toString() {
        String text = super.toString() + ",\n\tFactor Forma: " + factorForma;
                
        text += "\n\tComplements:"; 
        for (Complement c : this.complements)
            text += "\n\t\t" + c.toString();
        
        return text;
    }
    
}