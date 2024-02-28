package EX_UD09_II_A;

import java.util.ArrayList;

public class Supermercat implements UtilitatsSupermercat, UtilitatsArticle {
    private String nom;
    private ArrayList<ArticlesPerQuantitat> stock;

    public Supermercat(String nom, ArrayList<ArticlesPerQuantitat> stock) {
        this.nom = nom;
        this.stock = stock;
    }

    /** Afegeix un 'ArticlePerQuantitat' en l'atribut 'stock' */
    @Override
    public void afegeixArticle(Article p, int quantitat) {
        // TO-DO code application logic here

    }

    /** Recorre l'atribut 'stock', cercant 'text' en algun dels 'nom' dels articles ('ArticlePerQuantitat')  
    *       Si es troba, torna l''Article'
    *       Si no es troba, torna 'null'
    */
    @Override
    public Article cercaArticle(String nom) {
        // TO-DO code application logic here
        
        return null;
    }

    /** semblant al mètode 'cercaArticle',  recorre l'atribut 'stock' cercant 'text' en algun dels 'nom' dels articles:
    *       Si es troba:
    *           descompta 'quantitat' en l'atribut 'quantitat' de l''Article' trobat 
    *       Si no es troba:
    *           no fer res
    */
    @Override
    public void descomptaArticle(String s, int quantitat) {
        // TO-DO code application logic here
 
    }

    @Override
    public String toString() {
        
        return "";
    }

}