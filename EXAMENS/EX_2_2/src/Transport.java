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
    
}