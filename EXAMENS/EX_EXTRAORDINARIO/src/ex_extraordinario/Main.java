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
            Set<Vehiculo> vehiculos = gestor.getVehiculos();
            
            gestor.llegeixCSV(arxiu, arxiuLog);

            
            System.out.println("RESUM DE LA CÀRREGA:");
            System.out.println("\tMarcas: " + gestor.getMarcas().size());
            System.out.println("\tVehiculos: " + gestor.getVehiculos().size());

            // 1
            
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
    
}
