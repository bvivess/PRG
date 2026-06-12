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
            Set<Vehiculo> vehicles = gestor.llegeixCSV(arxiu, arxiuLog);
            Set<Marca> marques = vehicles.stream()
                                         .map(v->v.getMarca())
                                         .collect(Collectors.toSet());
                                         
            
            System.out.println("RESUM DE LA CÀRREGA:");
            System.out.println("\tMarcas: " + marques.size());
            System.out.println("\tVehiculos: " + vehicles.size());

            gestor.mostraDades(marques, vehicles);
           
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }
    
}
