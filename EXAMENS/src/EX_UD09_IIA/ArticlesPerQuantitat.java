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
    }  // CORRECCI�: falta implementar aquest m�tode perqu� pugui ser cridat des de 'Supermercat' i 'Client'
}
