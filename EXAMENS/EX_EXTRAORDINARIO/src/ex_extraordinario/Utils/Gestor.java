package ex_extraordinario.Utils;

import ex_extraordinario.Classes.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Gestor {
    private Set<Marca> marcas = new HashSet<>();
    private Set<Vehiculo> vehiculos = new HashSet<>();
    
    public Set<Vehiculo> llegeixCSV( String arxiu, String arxiuLog) throws FileNotFoundException, IOException {
        try ( Stream<String> linies = Files.lines(Paths.get(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {
            int[] numLinia = {0};  // objecte en comptes de tipus primitiu perqu? pugui variar en les cridada a 'parseMeteorit'

            return vehiculos = linies.map(linia -> parseVehicle(linia, ++numLinia[0], bufferedWriter))  // rep 'String' torna 'Meteorit'
                                     .filter(Objects::nonNull)  // s'eliminen els errors del 'parseVehicle()'
                                     .collect(Collectors.toSet());           
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer o creant el log: " + e.getMessage());
        }
        return null;
    }

    private Vehiculo parseVehicle(String linia, int numLinia, BufferedWriter bufferedWriter) {
        try {
            if (!(linia.isEmpty() || linia.startsWith("#"))) {
                // format: #idMarca,nombreMarca,paisOrigen,matricula,modelo,anyo,color,combustible
                //         0        1           2          3         4      5    6     7
                // Marca:
                String[] parts = linia.split(",");
                int     _idMarca    = Integer.parseInt(parts[0].trim());
                String _nombreMarca = parts[1].trim();
                String  _paisOrigen = parts[2].trim();
                // Vehiculo
                String _matricula   = parts[3].trim();
                String _modelo      = parts[4].trim();
                int _anyo           = Integer.parseInt(parts[5].trim());
                String _color       = parts[6];
                Combustible _combustible = Combustible.valueOf(parts[7].toUpperCase().trim());
                
                Marca _marca = marcas.stream()
                                     .filter(new Marca(_idMarca)::equals)  // 'cercaMarca'
                                     .findFirst()
                                     .orElseGet(()->new Marca(_idMarca, _nombreMarca, _paisOrigen));  // millor que '.orElse(new Ticket(_ticketId, _fare, _cabinId, _classId));'
               
                Vehiculo v = new Vehiculo( _matricula,
                                           _modelo,
                                           _anyo,
                                           _color,
                                           _combustible,
                                           _marca );
                System.out.println(v);
                return v;
            }
        } catch (NumberFormatException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (IllegalArgumentException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (Exception e) {
            logError(bufferedWriter, numLinia, e);

        }
        return null;
    }
    
    public void mostraDades( Set<Marca> marcas, Set<Vehiculo> vehiculos ) {
        System.out.println("\n----------------------------------------------------");
        System.out.println("Lista de las diferentes 'nombreMarca' de 'marcas' ordenadas por 'paisOrigen'");
        System.out.println("----------------------------------------------------");

        marcas.stream()
              .sorted((a,b)->a.compareTo(b))
              .collect(Collectors.toList())
              .forEach(m -> System.out.println(m.getNombreMarca()));
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Lista de 'vehiculos' ordenados por 'anyo'");
        System.out.println("----------------------------------------------------");
        vehiculos.stream()
                 .sorted((a,b)->Integer.compare(a.getAnyo(),b.getAnyo()))
                 .collect(Collectors.toList())
                 .forEach(System.out::println);

        System.out.println("\n----------------------------------------------------");
        System.out.println("Llista de 'vehiculos' cuyo combustible = ELECTRICO");
        System.out.println("----------------------------------------------------");

        vehiculos.stream()
                 .filter(v -> "Electrico".equals(v.getCombustible().getDescription()))
                 .forEach(System.out::println);
        
        System.out.println("\n----------------------------------------------------");
        System.out.println("Llista de los diferentes 'modelo' de los 'vehiculos' cuya marca = 'Toyota'");
        System.out.println("----------------------------------------------------");
        vehiculos.stream()
                 .filter(m -> "Toyota".equals(m.getMarca().getNombreMarca()))
                 .map(v -> v.getModelo())
                 .forEach(System.out::println);        
        
        
    }
    
    private void logError(BufferedWriter bufferedWriter, int numLinia, Exception e) {
        try {
            bufferedWriter.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("Error escrivint al log: " + ex.getMessage());
        }
    }

    public Set<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(Set<Marca> marcas) {
        this.marcas = marcas;
    }

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
}
