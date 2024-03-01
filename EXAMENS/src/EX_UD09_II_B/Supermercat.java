package EX_UD09_II_B;

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
        this.stock.add(new ArticlesPerQuantitat(p, quantitat));  // no es revisa si existeix o no ...

    }
           
    /** Recorre l'atribut 'stock', cercant 'text' en algun dels 'nom' dels articles ('ArticlePerQuantitat')  
    *       Si es troba, torna l''Article'
    *       Si no es troba, torna 'null'
    */
    @Override
    public Article cercaArticle(String nom) {
        // cerca el article per 'nom', si es troba: retorna 'Article'
        for (ArticlesPerQuantitat axq : this.stock) {
           if (axq.article.nom.equals(nom)) {
                return axq.article;
           }
        }
        
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
        // cerca el article per 'nom', si es troba: descompta quantitat
        for (ArticlesPerQuantitat axq : this.stock) {
           if (axq.article.nom.equals(s)) {
                axq.quantitat -= quantitat;
                break;
           }
        }
    }

    @Override
    public String toString() {
        String text = "Supermercat: " + this.nom;
        for (ArticlesPerQuantitat axq : this.stock) {
            text += "\n\t" + axq.toString();
         }
        
        return text;
    }

}