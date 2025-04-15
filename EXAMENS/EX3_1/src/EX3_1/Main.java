package EX3_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrador
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\EXAMEN.csv";
        String arxiuLog = "C:\\temp\\EXAMEN.log";
        
        // Estructures de memòria:
        HashSetMillorat<Client> clients = new HashSetMillorat<>();
        HashSetMillorat<Producte> productes = new HashSetMillorat<>();
        Map<String, Factura> factures = new HashMap<>();
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            LlegeixArxiu(arxiu, arxiuLog, factures, clients, productes);

            // PROVA NO DUPLIACCIÓ CLIENTS: modificar un client
            //for (Client c : clients) {
            //    if (c.getId().equals("C002")) {
            //        System.err.println("CLIENT TROBAT");
            //        c.setName("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            //        break;
            //    }
            //}
            
            // MOSTRAR LES ESTRUCTURES DE MEMÒRIA
            System.out.println("\nCLIENTS");
            mostraClients(clients);
            System.out.println("\nPRODUCTES");
            mostraProductes(productes);
            System.out.println("\nFACTURES");
            mostraFactures(factures);


        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }
    
    public static void LlegeixArxiu(String arxiu, String arxiuLog, Map<String, Factura> factures, HashSetMillorat<Client> clients, HashSetMillorat<Producte> productes) {
        String linea;
        //String[] parts;
        int numLinea = 0;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog))) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    numLinea++;
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        // PARSEIG: DESTRIAR ELS ATRIBUTS PRESENTS A L'ARXIU
                        //invoice_id  invoice_date  client_id  client_name           product_id  product_name                           import  
                        //0           13            27         38                    60          72                                     111
                        String facturaId = linea.substring(0, 12).trim();  
                        int _dia = Integer.parseInt(linea.substring(13, 15));
                        int _mes = Integer.parseInt(linea.substring(16, 18));
                        int _any = Integer.parseInt(linea.substring(19, 23));
                        // parts = linea.substring(13,23).split("/");
                        LocalDate data = LocalDate.of(_any, _mes, _dia); 
                        String clientId = linea.substring(27, 37).trim();  
                        String clientName = linea.substring(38, 60).trim(); 
                        String productId = linea.substring(60, 71).trim();  
                        String productName = linea.substring(72, 110).trim();  
                        int importValue = Integer.parseInt(linea.substring(111,linea.length()).trim());  

                        // CARREGAR LES ESTRUCTURES DE MEMORIA
                        // CARREGAR 'client' a 'clients'
                        // VARIANT2: cerca amb mètode de classe
                        // Cream l'objecte 'client' i el cercam en 'clients', que torna l'objecte existent o aquest nou 
                        //Client client = clients.cerca(new Client(clientId, clientName)); // Obtenim la instancia existent si hi es
                        Client client = clients.cerca(new Client(clientId, clientName));
                        // PROVA NO DUPLICACIÓ CLIENTS: Client client = new Client(clientId, clientName);
                        clients.add(client);
                        
                        // CARREGAR 'producte' a productes'
                        // VARIANT1: cerca amb mètode estàtic
                        // No es modifica la cerca en 'productes' per fer veure com funcionen les 2 variants 
                        Producte producte = cercaEnSet(productes, new Producte(productId, productName, importValue)); // Obtenim la instancia existent si hi es
                        productes.add(producte);

                        // CARREGAR 'factura' a 'factures'
                        // Afegim el producte a la llista de productes per aquesta factura
                        Factura factura = factures.get(facturaId);
                        if (factura == null) {
                            // Si la factura no existeix, creem una nova i afegim el producte
                            factura = new Factura(facturaId, data, client, new ArrayList<>());
                            factures.put(facturaId, factura);
                        }

                        // Afegim el producte a la factura existent
                        factura.getProductes().add(producte);

                    }
                } catch (NumberFormatException e) {
                    bufferedWriter.write("Error llegint l'arxiu en linia: " + numLinea + " --> " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (IllegalArgumentException e) {
                    bufferedWriter.write("Error llegint l'arxiu en linia: " + numLinea + " --> " + e.getMessage());
                    bufferedWriter.newLine();
                } 
            }
        } catch (Exception e) {
            System.err.println("Error llegint l'arxiu en linia: " + numLinea + "--> " + e.getMessage());
        }
    }
    
    /*
    private static Client cercaEnSet(Set<Client> clients, Client client) {
        for (Client c : clients) {
            if (c.equals(client)) {
                return c;
            }
        }
        
        return client; // Si no hi és, retornem el nou (serà afegit després)
    }
    
    private static Producte cercaEnSet(Set<Producte> productes, Producte producte) {
        for (Producte p : productes) {
            if (p.equals(productes)) {
                return p;
            }
        }
        
        return producte; // Si no hi és, retornem el nou (serà afegit després)
    }  */
    
    // Métode genèric per cercar en un Set emprant genèrics: substitueix els 2 anteriors
    private static <E> E cercaEnSet(Set<E> set, E element) {
        for (E e : set) {
            if (e.equals(element)) {
                return e;
            }
        }
        
        return element; // Si no hi és, retornem el nou (serà afegit després)
    }
    
    private static void mostraClients(HashSetMillorat<Client> clients) {
        List<Client> llista = new ArrayList<>(clients);
        Collections.sort(llista);
        
        for (Client c : llista)
            System.out.println("\t" + c.toString());
    }

    private static void mostraProductes(HashSetMillorat<Producte> productes) {
        List<Producte> llista = new ArrayList<>(productes);
        Collections.sort(llista);
        
        for (Producte p : llista)
            System.out.println("\t" + p.toString());
    }

    private static void mostraFactures(Map<String, Factura> factures) {
        for (Map.Entry<String, Factura> tupla : factures.entrySet())
            System.out.println("\n\tCLAU: " + tupla.getKey() + "\n\tVALOR: " + tupla.getValue().toString());
    }

}