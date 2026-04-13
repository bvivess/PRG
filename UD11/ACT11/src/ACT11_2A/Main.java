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
        String arxiu = "C:\\temp\\ACT11_2A.cvs";
        Map<Integer, Employee> employees  = new HashMap<>();;
        Map<Boolean, Set<Employee>> empAntiguitat  = new HashMap<>();;

        try {
            // Llegir el contingut línia a línia
            LlegeixArxiu(arxiu, employees, empAntiguitat);
            
            // Mostrar el map
            MostraEmployees(employees, empAntiguitat);
        } catch (Exception e) {
            System.err.println("Error general llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static void LlegeixArxiu(String arxiu, Map<Integer,Employee> employees, Map<Boolean, Set<Employee>> empAntiguitat) throws IOException, Exception {
        String linea;
        String[] parts;
        Integer clau;
        Employee employee;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split(";");
                        if (!linea.substring(0, 1).equals("#")) {
                            employee = new Employee( Integer.valueOf(parts[0].trim()), 
                                                     parts[1].trim(), 
                                                     parts[2].trim(), 
                                                     parts[3].trim(),
                                                     Double.valueOf(parts[4].trim()),
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
                } catch (Exception e) {
                    System.err.println("Error carregant Employee: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }

    private static void MostraEmployees(Map<Integer,Employee> employees, Map<Boolean, Set<Employee>> empAntiguitat) {
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

