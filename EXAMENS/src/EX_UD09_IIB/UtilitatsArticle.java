package EX_UD09_IIB;

public interface UtilitatsArticle {
    
    public abstract void afegeixArticle(Article p, int quantitat);
    //public abstract void descomptaArticle(Article p, int quantitat);
    
    public abstract Article cercaArticle(String nom);
    
}