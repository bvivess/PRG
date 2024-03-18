package EX_UD09_IIA;

public class ArticlesPerQuantitat {
    protected Article article;
    protected int quantitat;

    public ArticlesPerQuantitat(Article producte, int quantitat) {
        this.article = producte;
        this.quantitat = quantitat;
    }
    
    @Override
    public String toString() {
        
        return "";
    }  // CORRECCIÓ: falta implementar aquest mètode perquè pugui ser cridat des de 'Supermercat' i 'Client'
}
