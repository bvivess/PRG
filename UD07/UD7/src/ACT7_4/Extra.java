package ACT7_4;

class Extra {
    private String nom;
    private double preu;

    public Extra(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public double getPreu() {
        return preu;
    }

    @Override
    public String toString() {
        return nom + " (" + preu + " EUR)";
    }
}
