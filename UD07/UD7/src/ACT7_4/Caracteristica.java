package ACT7_4;

class Caracteristica {
    private String nom;
    private String valor;

    public Caracteristica(String nom, String valor) {
        this.setNom(nom);
        this.setValor(valor);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nom + ": " + valor;
    }
}
