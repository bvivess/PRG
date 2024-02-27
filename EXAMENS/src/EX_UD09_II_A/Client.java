package EX_UD09_II_A;

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
        // TO-DO code application logic here
        
    }
    
    /** Recorre l'atribut 'carrito', cercant 'text' en algun dels 'nom' dels articles ('ArticlePerQuantitat')  
    *       Si es troba, torna l''Article'
    *       Si no es troba, torna 'null'
    */
    @Override
    public final Article cercaArticle(String nom) {
        // TO-DO code application logic here

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
        // TO-DO code application logic here

    }

    /* Recorre l'atribut 'carrito', calcula:
    *       ('preuVenda' + ('preuVenda*IVA.tantPerCent')) * 'quantitat' 
    *  de cada 'Article' i torna el valor acumulat de tots ells
    */
    @Override
    public double calculaTotal() {
        // TO-DO code application logic here
        
        return 0.0;
    }
    
    @Override
    public String toString() {
        
        return "";
    }
}
