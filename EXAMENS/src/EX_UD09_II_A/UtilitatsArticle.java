package EX_UD09_II_A;

public interface UtilitatsArticle {
 
    public abstract void afegeixArticle(Article a, int quantitat);  // afegeixArticlePerQuantitat
    public abstract Article cercaArticle(String nom);  // cercaArticle en ArticlePerQuantitat (carrito o stock)
    
}