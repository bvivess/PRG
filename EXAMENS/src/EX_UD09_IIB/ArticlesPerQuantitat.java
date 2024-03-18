package EX_UD09_IIB;

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
