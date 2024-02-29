package EX_UD09_II_B;

import java.util.ArrayList;

public class Client implements UtilitatsClient, UtilitatsArticle {
    private String nom;
    private ArrayList<ArticlesPerQuantitat> carrito;

    public Client(String nom, ArrayList<ArticlesPerQuantitat> carrito) {
        this.nom = nom;
        this.carrito = carrito;
    }
    
    /** Afegeix un 'ArticlePerQuantitat' en l'atribut 'carrito' */
    @Override
    public final void afegeixArticle(Article a, int quantitat) {
        this.carrito.add(new ArticlesPerQuantitat(a, quantitat));  // no es revisa si existeix o no ...
    }

    /** Recorre l'atribut 'carrito', cercant 'text' en algun dels 'nom' dels articles ('ArticlePerQuantitat')  
    *       Si es troba, torna l''Article'
    *       Si no es troba, torna 'null'
    */    
    @Override
    public final Article cercaArticle(String nom) {
        // cerca el article per 'nom', si es troba: retorna 'Article'
        for (ArticlesPerQuantitat axq : this.carrito) {
           if (axq.article.nom.equals(nom))
                return axq.article;
        }
        
        return null;
    }

    /** Cerca un article en l'stock del supermercat ? 's.cercaArticle(?)'
    *       Si es troba:
    *           afegir l'article trobat al carreto del client ? 'afegeixArticle(?)'
    *           descomptar l'article de l'stock del supermercat ? 's.descomptaArticle(?)'
    *       Si no es troba:
    *           mostrar un missatge ? 'No es troba l'article'
    */
    @Override
    public void afegeixAlCarrito(Supermercat s, String text, int quantitat) {
        Article article = s.cercaArticle(text);
        
        if (article != null) {
            this.afegeixArticle(article, quantitat);
            s.descomptaArticle(text,quantitat);
        } else
            System.out.println("Article " + text + " no es troba");
    }

    /* Recorre l'atribut 'carrito', calcula:
    *       ('preuVenda' + ('preuVenda*IVA.tantPerCent')) * 'quantitat' 
    *  de cada 'Article' i torna el valor acumulat de tots ells
    */
    @Override
    public double calculaTotal() {
        double total = 0;  // total preu venda - descomptes
        for (ArticlesPerQuantitat sxa : carrito) 
            total += (sxa.article.preuVenda + (sxa.article.preuVenda * sxa.article.tipusIva.tantPerCent)) * sxa.quantitat;
        
        return total;
    }
    
    @Override
    public String toString() {
        String text = "Client: " + this.nom;
        for (ArticlesPerQuantitat axq : this.carrito) {
            text += "\n\t" + axq.toString();
        }
        text += "\n\tTOTAL: " + this.calculaTotal();
        
        return text;
    }
}
