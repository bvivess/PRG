package ACT12_2C;

import ACT12_2C.Utils.*;
import ACT12_2C.Classes.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        
        // Carrega les llistes
        List<String[]> liniesCSV = gestor.llegeixLiniesCSV("c:\\temp\\clients.csv");
        List<Department> departments = gestor.carregaDepartments(liniesCSV);
        List<Client> clients = gestor.carregaClients(liniesCSV);
        
        // Imprimeix les llistes
        System.out.println("Departaments");
        departments.stream().forEach(System.out::println);  // Ordenat per Id
        System.out.println("");
        System.out.println("Clients");
        clients.stream().forEach(System.out::println);  // Ordenat per nom
        
        // Desa les llistes
        gestor.desaDepartments(gestorBBDD, departments);
        gestor.desaClients(gestorBBDD, clients);
        
        System.out.println("BBDD modificada correctament");
    }
    
}