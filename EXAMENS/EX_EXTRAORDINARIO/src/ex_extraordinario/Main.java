package ex_extraordinario;

import ex_extraordinario.Classes.*;
import ex_extraordinario.Utils.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static String arxiu = "c:\\temp\\vehiculos.csv";
    static String arxiuLog = "c:\\temp\\vehiculos.log";
    
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        
        try {            
            Set<Marca> marques = gestor.getMarcas();
            Set<Vehiculo> vehicles = gestor.getVehiculos();
            
            gestor.llegeixCSV(arxiu, arxiuLog);

            
            System.out.println("RESUM DE LA CÀRREGA:");
            System.out.println("\tMarcas: " + marques.size());
            System.out.println("\tVehiculos: " + vehicles.size());

            // 1
            
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
    
}
