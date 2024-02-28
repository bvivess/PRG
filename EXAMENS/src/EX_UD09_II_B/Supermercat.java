package EX_UD09_II_B;

import java.util.ArrayList;

public class Supermercat implements UtilitatsSupermercat, UtilitatsArticle {
    private String nom;
    private ArrayList<ArticlesPerQuantitat> stock;

    public Supermercat(String nom, ArrayList<ArticlesPerQuantitat> stock) {
        this.nom = nom;
        this.stock = stock;
    }

    @Override
    public void descomptaArticle(String s, int quantitat) {
        // cerca el article per 'nom', si es troba: descompta quantitat
        for (ArticlesPerQuantitat axq : this.stock) {
           if (axq.article.nom.equals(s)) {
                axq.quantitat -= quantitat;
           }
        }
    }

    @Override
    public void afegeixArticle(Article p, int quantitat) {
        ArticlesPerQuantitat s = new ArticlesPerQuantitat(p, quantitat);
       
        if (this.cercaArticle(p.nom) == null)
            this.stock.add(s);
    }
           
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

    @Override
    public String toString() {
        String text = "Supermercat: " + this.nom;
        for (ArticlesPerQuantitat axq : this.stock) {
            text += "\n\t" + axq.toString();
         }
        
        return text;
    }

}