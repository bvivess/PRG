public final class Estancia extends ServeiTuristic {
    private String regim; // AD, MP, TI

    public Estancia(String nom, String regim) {
        super(nom);
        this.setRegim(regim); 
    }

    @Override
    public boolean esSostenible() {
        return this.regim.equals("TI");
    }

    public void setRegim(String regim) {
        switch (regim) {
            case "SA", "AD", "TI" -> 
                this.regim = regim;
            default -> 
                throw new IllegalArgumentException("Règim incorrecte");
        }
    }
    
    @Override
    public double calculaPreu() {
        return  super.calculaPreu() +
                (this.esPremium() ? super.calculaPreu() * Promocionable.SUPLEMENT_PREMIUM : 1 );
    }

    @Override
    public String toString() {
        String text = "Estància:" + " Règim=" + this.regim + ", Premium: " + this.esPremium() + ", Sostenible: " + this.esSostenible();
        text += "\n\tCaracterístiques de l'estància:";
        for (Caracteristica c : this.caracteristiques) {
            text += "\n\t\t" + c.toString();
        }
        text += "\n\t\tPREU SERVEI: " + this.calculaPreu();
        return text;
    }

}