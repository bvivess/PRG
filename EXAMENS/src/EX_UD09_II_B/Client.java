package EX_UD09_II_B;

import java.util.ArrayList;

public class Client implements UtilitatsClient, UtilitatsArticle {
    private String nom;
    private ArrayList<ArticlesPerQuantitat> carrito;

    public Client(String nom, ArrayList<ArticlesPerQuantitat> carrito) {
        this.nom = nom;
        this.carrito = carrito;
    }
    
    @Override
    public final void afegeixArticle(Article a, int quantitat) {
        ArticlesPerQuantitat axq = new ArticlesPerQuantitat(a, quantitat);
       
        this.carrito.add(axq);  // no es revisa si existeix o no ...
    }
    
    @Override
    public final Article cercaArticle(String nom) {
        // cerca el article per 'nom', si es troba: retorna 'Article'
        for (ArticlesPerQuantitat axq : this.carrito) {
           if (axq.article.nom.equals(nom))
                return axq.article;
        }
        
        return null;
    }

    @Override
    public void afegeixAlCarrito(Supermercat s, String text, int quantitat) {
        Article article = s.cercaArticle(text);
        
        if (article != null) {
            this.afegeixArticle(article, quantitat);
            s.descomptaArticle(text,quantitat);
        } else
            System.out.println("Article " + text + " no es troba");
    }

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
