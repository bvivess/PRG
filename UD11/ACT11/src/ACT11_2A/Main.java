package ACT11_2A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        String arxiu = "C:\\temp\\ACT11_2A.csv";
        Map<Integer, Employee> employees  = new HashMap<>();
        Map<Boolean, Set<Employee>> empAntiguitat  = new HashMap<>();

        try {
            // Llegir el contingut línia a línia
            llegeixArxiu(arxiu, employees, empAntiguitat);
            
            // Mostrar el map
            mostraEmployees(employees, empAntiguitat);
        } catch (Exception e) {
            System.err.println("Error general llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static void llegeixArxiu(String arxiu, Map<Integer,Employee> employees, Map<Boolean, Set<Employee>> empAntiguitat) throws IOException, Exception {
        String linia;
        int numLinia = 0;
        String[] parts;
        Integer clau;
        Employee employee;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    numLinia++;
                    
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        parts = linia.split(";");
                        if (!linia.substring(0, 1).equals("#")) {
                            employee = new Employee( Integer.parseInt(parts[0].trim()),  // millor que: "Integer.valueOf(parts[0].trim())"
                                                     parts[1].trim(), 
                                                     parts[2].trim(), 
                                                     parts[3].trim(),
                                                     Double.parseDouble(parts[4].trim()),  // millor que: "Integer.valueOf(parts[0].trim())"
                                                     LocalDate.parse(parts[5].trim()) );
                            // employees: id-Employee
                            employees.put(Integer.valueOf(parts[0].trim()), employee);

                            // empAntiguitat: teAntiguitat-Set()
                            boolean teAntiguitat = Period.between(employee.getHireDate(), LocalDate.now()).getYears() >= 20;
                            if (!empAntiguitat.containsKey(teAntiguitat))
                                empAntiguitat.put(teAntiguitat, new HashSet<>());
                            empAntiguitat.get(teAntiguitat).add(employee);
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Employee: " + numLinia + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Employee: " + numLinia + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error carregant Employee: " + numLinia + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }

    private static void mostraEmployees(Map<Integer,Employee> employees, Map<Boolean, Set<Employee>> empAntiguitat) {
        // employees: id-Employee
        for (Map.Entry<Integer,Employee> entry : employees.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // empAntiguitat: teAntiguitat-Set()
        Set<Employee> llista = empAntiguitat.get(true);
        System.out.println(">=20" + "-->" );
        for (Employee e : llista) 
            System.out.println(e.toString());

    }

}

