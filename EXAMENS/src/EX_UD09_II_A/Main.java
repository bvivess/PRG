package EX_UD09_II_A;

import java.util.ArrayList;

/**
 *
 * @author winadmin
 */
public class Main {
  
    public static void main(String[] args) {
        // Articles
        TipusIva tipusIva = new TipusIva("Normal",0.21);
        Article article = new Article("Pa moreno", 0.80, 1.75, tipusIva);
        ArticlesPerQuantitat articlePerQuantitat = new ArticlesPerQuantitat(article, 10);
        
        // Articles: 'stock' o 'carrito'
        ArrayList<ArticlesPerQuantitat> articles = new ArrayList<>();
        articles.add(articlePerQuantitat);
        
        // Supermercat i Client
        Supermercat supermercat = new Supermercat("Lidl", articles);
        Client client = new Client("Bernat Maimó", articles );
        
    }
}