package ACT11_1E;

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
        String arxiu = "C:\\temp\\ACT11_1E_orders.csv";
        String arxiuLog = "C:\\temp\\ACT11_1E.log";
        
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
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {       
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: xxx\Txxx\Ttxxx\Txxx
                    parseLiniaOrder(linia, numLinia++, bufferedWriter, articles, orders);
                    
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
    
    private static void parseLiniaOrder( String linia, int numLinia, BufferedWriter bufferedWriter, 
                                         Set<Article> articles, 
                                         Map<Integer, Order> orders ) {

        try {
            if (!(linia.isEmpty() || linia.startsWith("#"))) {
                String[] parts;
                
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
                    parts = linia.split("\t", 5);
                    int _orderId = Integer.parseInt(parts[0].trim());
                    int _articleId = Integer.parseInt(parts[2].trim());
                    String _articleName = parts[3].trim();
                    int _articlePrice = Integer.parseInt(parts[4].trim());
                    // format: parts[1]: xx/xx/xxxx
                    //                   1  4  7
                    int _dia = Integer.parseInt(parts[1].substring(0, 2));
                    int _mes = Integer.parseInt(parts[1].substring(3, 5));
                    int _any = Integer.parseInt(parts[1].substring(6, 10));
                    LocalDate _orderDate = LocalDate.of(_any, _mes, _dia);
                    
                    // Articles
                    Article article = new Article(_articleId, _articleName, _articlePrice );
                    afegeixArticle(articles, article);

                    // Orders
                    Order order = new Order(_orderId, _orderDate, article.getProductPrice());
                    afegeixOrder(articles, orders, order, article );
                }
            }
        } catch (NumberFormatException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (IllegalArgumentException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (Exception e) {
            logError(bufferedWriter, numLinia, e);
        }
    }
    
    private static void logError(BufferedWriter bufferedWriter, int numLinia, Exception e) {
        try {
            bufferedWriter.write("Error carregant línia " + numLinia + ": " + e.getMessage());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("Error escrivint al log: " + ex.getMessage());
        }
    }

    private static void afegeixArticle(Set<Article> articles, Article article) {
        articles.add(article);
    }

    private static void afegeixOrder(Set<Article> articles, Map<Integer, Order> orders, Order o, Article a) {
        Article article = cercaArticle(articles, a.getProductId()); 
        
        if (article != null)
            if (orders.containsKey(o.getOrderId())) {
                orders.get(o.getOrderId()).setOrderTotal(article.getProductPrice() + orders.get(o.getOrderId()).getOrderTotal() );
                orders.get(o.getOrderId()).getCarrito().add(article);
            } else
                orders.put(o.getOrderId(), o);

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

