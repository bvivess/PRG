package EX2_3;

public class Postre extends Plat {
    protected String tipus;
    
    public Postre(String nom, String tipus) {
        super(nom);
        setTipus(tipus);
    }
    
    @Override
    public double calculaPreu() {
        return super.calculaPreu() / (this.tipus.equals("cafe") ? 4 : 2);
    }

    public void setTipus(String tipus) {
        if ( (tipus.equals("dolc")) || (tipus.equals("salat")) || (tipus.equals("cafe")) )
            this.tipus = tipus;
        else
            System.out.println("Valor incorrecte");
    }
}
