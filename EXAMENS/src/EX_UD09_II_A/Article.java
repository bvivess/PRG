package EX_UD09_II_A;

public class Article {
    protected String nom;
    protected double preuCompra;
    protected double preuVenda;
    protected TipusIva tipusIva;

    public Article(String nom, double preuCompra, double preuVenda, TipusIva tipusIva) {
        this.nom = nom;
        this.preuCompra = preuCompra;
        this.preuVenda = preuVenda;
        this.tipusIva = tipusIva;
    }

    @Override
    public String toString() {
        
        return "";
    }
}
