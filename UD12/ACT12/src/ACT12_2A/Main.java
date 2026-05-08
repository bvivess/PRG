 package ACT12_2A;

import ACT12_2A.Classes.*;
import ACT12_2A.Utils.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String arxiuCSV = "C:\\temp\\clients.csv";
        Gestor gestor = new Gestor();
        
        // Carrega les llistes
        List<Department> departments = gestor.carregaDepartments(arxiuCSV);
        List<Client> clients = gestor.carregaClients(arxiuCSV);
        
        // Imprimeix les llistes
        System.out.println("Departments");
        departments.stream()
                   .sorted()  // Ordenat per ID (defecte)
                   .forEach(System.out::println);
        
        System.out.println("");
        
        System.out.println("Clients");
        clients.stream().sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom())).forEach(System.out::println);  // Ordenat per nom
    }
    
    
}