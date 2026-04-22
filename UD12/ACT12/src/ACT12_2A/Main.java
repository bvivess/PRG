 package ACT12_2A;

import ACT12_2A.Classes.*;
import ACT12_2A.Utils.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        
        // Carrega les llistes
        List<Department> departments = gestor.carregaDepartments("c:\\temp\\clients.csv");
        List<Client> clients = gestor.carregaClients("c:\\temp\\clients.csv");
        
        // Imprimeix les llistes
        System.out.println("Departments");
        departments.stream().sorted((d1, d2) -> d1.getId().compareTo(d2.getId())).forEach(System.out::println);  // Ordenat per Id
        
        System.out.println("");
        
        System.out.println("Clients");
        clients.stream().sorted((c1, c2) -> c1.getNom().compareTo(c2.getNom())).forEach(System.out::println);  // Ordenat per nom
    }
    
    
}