package ex_extraordinario;

import ex_extraordinario.Classes.*;
import ex_extraordinario.Utils.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static String arxiu = "c:\\temp\\vehicles.csv";
    static String arxiuLog = "c:\\temp\\vehicles.log";
    
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        
        try {
            gestor.llegeixCSV(arxiu, arxiuLog);
            Set<Marca> marques = gestor.getMarcas();
            Set<Vehiculo> vehiculos = gestor.getVehiculos();
            
            System.out.println("RESUM DE LA CÀRREGA:");
            System.out.println("\tTickets: " + gestor.getMarcas().size());
            System.out.println("\tPassatgers: " + gestor.getVehiculos().size());

            // 1
            
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
    
}
