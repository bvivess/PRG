package ACT11_1C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu1 = "C:\\temp\\ACT11_2C_departments.txt";
        String arxiu2 = "C:\\temp\\ACT11_2C_employees.csv";
        
        // Estructures de memòria:
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        Map<Department, List<Employee>> depEmps = new HashMap<>();   // Relació 1:N
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            llegeixArxius(arxiu1, arxiu2, departments, employees);

            // Càrrega els 'Map' 'depEmps' i 'empDeps' a partir de les 'List' 'departments' i 'employees'
            carregaDepEmps(depEmps, departments, employees);  // Relacio 1:N

            // Mostrar les estructures de memòria:
            System.out.println("DEPARTMENTS");
            mostraDepartments(departments);
            
            System.out.println("EMPLOYEES");
            mostraEmployees(employees);
            
            System.out.println("DEPEMPS");
            mostraDepEmps(depEmps);
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }
    
    private static void llegeixArxius(String arxiu1, String arxiu2, List<Department> departments, List<Employee> employees) throws IOException, NumberFormatException, IllegalArgumentException {
        // Llegir el contingut dels arxius línia a línia:
        llegeixArxiuDepartments(arxiu1, departments);
        llegeixArxiuEmployees(arxiu2, departments, employees);
    }

    private static void llegeixArxiuDepartments(String arxiu, List<Department> departments) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        int numLinia = 0;
        String[] parts;
        Department department;
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    numLinia++;
                    
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split(";", 2);

                        department = new Department( Integer.parseInt(parts[0].trim()),  // departmentId
                                                     parts[1].trim() );                  // departmentName
                        departments.add(department);

                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department" + numLinia + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Department" + numLinia + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static void llegeixArxiuEmployees(String arxiu, List<Department> departments, List<Employee> employees) throws IOException, NumberFormatException, IllegalArgumentException {
        String linia;
        int numLinia = 0;
        String[] parts;
        Employee employee;
        Department department;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {   
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    numLinia++;
                    
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        parts = linia.split(";", 5);
                        
                        department = cercaDepartment(departments, Integer.parseInt(parts[4].trim()));  // cerca 'department' en l'arraylist 'departments'
                        
                        employee = new Employee( Integer.parseInt(parts[0].trim()), // employeeId
                                                 parts[1].trim(),                   // firstName
                                                 parts[2].trim(),                   // lasttName
                                                 parts[3].trim(),                   // email
                                                 department );                      // department
                        employees.add(employee);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Employee" + numLinia + ": " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Employee" + numLinia + ": " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error carregant Employee" + numLinia + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }   
    
    private static void carregaDepEmps(Map<Department, List<Employee>> depEmps, List<Department> departments, List<Employee> employees) throws Exception {
        // Crea 'depEmps' a partir de 'departments'
        for (Department d : departments)
            depEmps.put(d, new ArrayList<>());
        
        // Modifica la List de 'depEmps' a partir de cada 'employee'
        for (Employee e : employees)  // per a cada 'employee', cerca el 'department' a la 'List' i afegeix-lo a 'depEmps'
            depEmps.get(e.getDepartment()).add(e);  // afegeix 'e' a la List del Map
    }
    
    private static Department cercaDepartment(List<Department> departments, int departmentId) {
        int index = departments.indexOf(new Department(departmentId));  // crea un 'department' temporal per a fer la cerca per 'Objecte'
        
        return (index != -1) ?  departments.get( index ) : null;
    }
    
    private static void mostraDepartments(List<Department> departments) {
        Collections.sort(departments); // Ordena la llista 'departments'
        
        for (Department d : departments) {
            System.out.println(d.toString());
        }
    }
    
    private static void mostraEmployees(List<Employee> employees) {
        Collections.sort(employees); // Ordena la llista 'employees'

        for (Employee e : employees) {  
            System.out.println(e.toString());
        }
    } 
    
    private static void mostraDepEmps(Map<Department, List<Employee>> depEmps) {
        for (Map.Entry<Department, List<Employee>> entry : depEmps.entrySet()) {
            if (!entry.getValue().isEmpty())
                System.out.println("Clau: " + entry.getKey().toString() + ", Valor: " + entry.getValue().toString());
        }
    }

}

