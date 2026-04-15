package ACT11_2E;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\ACT11_2E_orders.csv";
        String arxiuLog = "C:\\temp\\ACT11_2E.log";
        
        // Estructures de memòria:
        Set<Article> articles = new HashSet<>();
        Map<Integer, Order> orders = new HashMap<>();
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            llegeixArxiu(arxiu, arxiuLog, orders, articles);

            // Mostrar les estructures de memòria:
            System.out.println("ARTICLES");
            mostraArticles(articles);
            
            System.out.println("ORDERS");
            mostraOrders(orders);


        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    private static void llegeixArxiu(String arxiu, String arxiuLog, Map<Integer, Order> orders, Set<Article> articles) throws IOException, NumberFormatException, IllegalArgumentException {
        String linia;
        int numLinia = 0;
        String[] parts;
        int  _orderId, _articleId, _articlePrice;
        String _articleName;
        int _dia=0, _mes=0, _any=0;
        LocalDate _orderDate;
        //String[] parts;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {       
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: xxx\Txxx\Ttxxx\Txxx
                    numLinia = numLinia + 1 ;
                    
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        parts = linia.split("\t", 5);
                        _orderId = Integer.parseInt(parts[0].trim());
                        _articleId = Integer.parseInt(parts[2].trim());
                        _articleName = parts[3].trim();
                        _articlePrice = Integer.parseInt(parts[4].trim());
                        // format: parts[1]: xx/xx/xxxx
                        //                   1  4  7
                        _dia = Integer.parseInt(parts[1].substring(0, 2));
                        _mes = Integer.parseInt(parts[1].substring(3, 5));
                        _any = Integer.parseInt(parts[1].substring(6, 10));
                        _orderDate = LocalDate.of(_any, _mes, _dia);
                        
                        // Articles
                        carregaArticles(articles, _articleId, _articleName, _articlePrice );
                        
                        // Orders
                        carregaOrders(articles, orders, _orderId, _orderDate, _articleId );
                    }
                } catch (NumberFormatException e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (IllegalArgumentException e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (Exception e) {
                    bufferedWriter.write("Error carregant Línia" + numLinia + ": " + e.getMessage());
                    bufferedWriter.newLine();   
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }

    private static void carregaArticles(Set<Article> articles, int productId, String productName, int productPrice) {

        articles.add(new Article(productId, productName, productPrice));

    }

    private static void carregaOrders(Set<Article> articles, Map<Integer, Order> orders, int orderId, LocalDate orderDate, int articleId) {
        Article article = cercaArticle(articles, articleId);
        
        if (article != null)
            if (orders.containsKey(orderId)) {
                orders.get(orderId).setOrderTotal(article.getProductPrice() + orders.get(orderId).getOrderTotal() );
                orders.get(orderId).getCarrito().add(article);
            } else
                orders.put(orderId, new Order(orderId, orderDate, article.getProductPrice()));

    }
    
    private static Article cercaArticle(Set<Article> articles, int articleId) {  // en Set
        for (Article a : articles) 
            if (a.getProductId() == articleId)
                return a;
        return null;
    }
    
    private static void mostraArticles(Set<Article> articles) {
        List<Article> articles_ = new ArrayList<>(articles);
        Collections.sort(articles_); // Ordena la llista 'departments'
        
        for (Article p: articles_) {
            System.out.println(p.toString());
        }
    }
    
    private static void mostraOrders(Map<Integer, Order> orders) {
      List<Order> orders_ = new ArrayList<>(orders.values()); // Llista dels valors (Order)

    Collections.sort(orders_); 

    for (Order o : orders_) {
        System.out.println(o);
    }
}

}

