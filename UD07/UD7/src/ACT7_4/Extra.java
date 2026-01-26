package ACT7_4;

class Extra {
    private String nom;
    private double preu;

    public Extra(String nom, double preu) {
        this.setNom(nom);
        this.setPreu(preu);
    }

    public double getPreu() {
        return preu;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return nom + " (" + preu + " EUR)";
    }
}
