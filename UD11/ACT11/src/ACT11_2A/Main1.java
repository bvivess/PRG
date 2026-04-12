package ACT11_2A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) throws Exception {
        String rutaArchivo = "C:\\temp\\ACT11_2A.cvs";
        Map<Integer, Employee> employees = new HashMap<>();
        String[] parts;

        try ( FileReader fileReader = new FileReader(rutaArchivo);
              BufferedReader bufferedReader = new BufferedReader(fileReader);
            ) {

            // Llegir el contingut línia a línia
            String linea;
            Integer clau;
            Employee employee;
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    parts = linea.split(";");
                    if (!linea.substring(0, 1).equals("#")) {
                        clau = Integer.valueOf(parts[0].trim());
                        employee = new Employee( clau, 
                                                 parts[1].trim(), 
                                                 parts[2].trim(), 
                                                 parts[3].trim(),
                                                 Double.valueOf(parts[4].trim()),
                                                 LocalDate.parse(parts[5].trim()) );

                        employees.put(clau, employee);
                    }
                } catch (Exception e) {
                    System.out.println("Error en línia: " + linea + " --> " + e.getMessage());
                }
            }
            System.out.println(employees);
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
}

