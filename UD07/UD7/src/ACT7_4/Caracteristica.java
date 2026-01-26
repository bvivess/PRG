package ACT7_4;

class Caracteristica {
    private String nom;
    private String valor;

    public Caracteristica(String nom, String valor) {
        this.nom = nom;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return nom + ": " + valor;
    }
}
