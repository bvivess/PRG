public abstract class Transport extends ServeiTuristic {
    private boolean esPublic;

    public Transport(String nom, boolean esPublic) {
        super(nom);
        this.esPublic = esPublic;
    }

    @Override
    public boolean esSostenible() {
        return this.esPublic;
    }
    
    @Override   
    public double calculaPreu() {  // Calcula els suplements / Descomptes per a qualsevol transport
        double preuBase = super.calculaPreu();
        return preuBase + (this.esPremium()    ? preuBase * Promocionable.SUPLEMENT_PREMIUM : 0 ) -
                          (this.esSostenible() ? preuBase * Promocionable.DESCOMPTE_BASE : 0 );
    }
    
}