package ACT11_2E;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\EXAMEN.csv";
        
        // Estructures de memòria:
        List<Article> articles = new ArrayList<>();
        Map<Integer, Order> orders = new HashMap<>();
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            LlegeixArxiu(arxiu, orders, articles);

            // Mostrar les estructures de memòria:
            System.out.println("ARTICLES");
            mostraArticles(articles);
            System.out.println("ORDERS");
            mostraOrders(orders);


        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    private static void LlegeixArxiu(String arxiu, Map<Integer, Order> orders, List<Article> articles) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        String[] parts;
        int  _orderId, _articleId, _articlePrice;
        String _articleName;
        int _dia=0, _mes=0, _any=0;
        LocalDate _orderDate;
        //String[] parts;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxx\txxx\txxx\txxx
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split("\t", 5);
                        _orderId = Integer.parseInt(parts[0].trim());
                        _dia = Integer.parseInt(parts[1].substring(0, 2));
                        _mes = Integer.parseInt(parts[1].substring(3, 5));
                        _any = Integer.parseInt(parts[1].substring(6, 10));
                        _orderDate = LocalDate.of(_any, _mes, _dia);
                        _articleId = Integer.parseInt(parts[2].trim());
                        _articleName = parts[3].trim();
                        _articlePrice = Integer.parseInt(parts[4].trim());
                        
                        // Articles
                        carregaArticles(_articleId, _articleName, _articlePrice, articles );
                        
                        // Orders
                        carregaOrders(_orderId, _orderDate, _articleId, articles, orders );

                        
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println(e.getMessage() + "-->" + _dia + "-"+ _mes + "-"+ _any + "-");
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    
    private static void carregaArticles(int productId, String productName, int productPrice, List<Article> articles) {
        Article article = new Article(productId, productName, productPrice);
        
        int indexArticles = articles.indexOf(article);
        
        if (indexArticles == -1) {
            articles.add(article);
        } 
    }

    private static void carregaOrders(int orderId, LocalDate orderDate, int articleId, List<Article> articles, Map<Integer, Order> orders) {
        Article article = articles.get(articles.indexOf( new Article(articleId, null, 0)));
        ArrayList<Article> carrito;
        
        if (orders.containsKey(orderId)) {
            orders.get(orderId).setOrderTotal(article.getProductPrice() + orders.get(orderId).getOrderTotal() );
            orders.get(orderId).getCarrito().add(article);
        } else
            orders.put(orderId, new Order(orderId, orderDate, article.getProductPrice()));

    }
    
    private static void mostraArticles(List<Article> products) {
        Collections.sort(products); // Ordena la llista 'departments'
        
        for (Article p: products) {
            System.out.println(p.toString());
        }
    }
    
    private static void mostraOrders(Map<Integer, Order> orders) {
        //Collections.sort(orders); // Ordena la llista 'employees'

        for (Map.Entry<Integer, Order> tupla : orders.entrySet()) {
            System.out.println("Clau: " + tupla.getKey().toString() + ", Valor: " + tupla.getValue().toString());
        }
    }

}

