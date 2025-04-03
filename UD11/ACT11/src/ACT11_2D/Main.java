package ACT11_2D;

import ACT11_2C.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\ACT11_2D_products_per_warehouses.cvs";
        
        // Estructures de memòria:
        List<Warehouse> warehouses = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Map<Warehouse, List<Product>> warehouseProducts = new HashMap<>();   // Relació M:N
        Map<Product, List<Warehouse>> productWarehouses = new HashMap<>();   // Relació N:M
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            LlegeixArxiu(arxiu, products, warehouses);

            // Càrrega els 'Map' 'depEmps' i 'empDeps' a partir de les 'List' 'departments' i 'employees'

            //carregaDepEmps(depEmps, departments, employees);  // Relacio 1:N
            //carregaEmpDeps(empDeps, departments, employees);  // Relació N:1

            // Mostrar les estructures de memòria:
            System.out.println("PRODUCTS");
            mostraProducts(products);
            System.out.println("WAREHOUSES");
            mostraWarehouses(warehouses);
/*
            System.out.println("DEPEMPS");
            mostraDepEmps(depEmps);
            System.out.println("EMPDEPS");
            mostraEmpDeps(empDeps);
*/
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    private static void LlegeixArxiu(String arxiu,  List<Product> products, List<Warehouse> warehouses) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        String[] parts;
        Product product;
        Warehouse warehouse;
        int indexProducts;
        int indexWarehouses;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split(";", 5);
                        
                        // Products
                        indexProducts = products.indexOf(new Product(Integer.parseInt(parts[0].trim()),".",0));
                        if (indexProducts == -1) {
                            product = new Product( Integer.parseInt(parts[0].trim()),
                                                   parts[1].trim(),
                                                   1 );
                            products.add(product);
                        } else {
                            products.get(indexProducts).setNumWarehouses( products.get(indexProducts).getNumWarehouses() + 1 );
                        }
                        
                        // Warehouses
                        indexWarehouses = warehouses.indexOf(new Warehouse(Integer.parseInt(parts[2].trim()),".",0));
                        if (indexWarehouses == -1) {
                            warehouse = new Warehouse( Integer.parseInt(parts[2].trim()),
                                                       parts[3].trim(),
                                                       Integer.parseInt(parts[4].trim()) );
                            warehouses.add(warehouse);
                        } else {
                            warehouses.get(indexWarehouses).setNumProducts( warehouses.get(indexWarehouses).getNumProducts() + Integer.parseInt(parts[4].trim()) );
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }

    private static void mostraProducts(List<Product> products) {
        Collections.sort(products); // Ordena la llista 'departments'
        
        for (Product p: products) {
            System.out.println(p.toString());
        }
    }
    
    private static void mostraWarehouses(List<Warehouse> warehouses) {
        Collections.sort(warehouses); // Ordena la llista 'employees'

        for (Warehouse w : warehouses) {  
            System.out.println(w.toString());
        }
    }

}

