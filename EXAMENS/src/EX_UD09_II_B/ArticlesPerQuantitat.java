package EX_UD09_II_B;

public class ArticlesPerQuantitat {
    protected Article article;
    protected int quantitat;

    public ArticlesPerQuantitat(Article producte, int quantitat) {
        this.article = producte;
        this.quantitat = quantitat;
    }
    
    @Override
    public String toString() {
        return "Producte: " + this.article.toString() + 
               "; Quantitat: " + this.quantitat;
    }
    
}
