package ACT11_2B;

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
        String arxiu1 = "C:\\temp\\ACT11_2B_departments.cvs";
        String arxiu2 = "C:\\temp\\ACT11_2B_employees.cvs";
        
        // Estructures de memòria:
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        Map<Department, List<Employee>> depEmps = new HashMap<>();   // Relació 1:N
        Map<Employee, Department> empDeps = new HashMap<>();   // Relació N:1
          
        // Llegir el contingut dels arxius línia a línia:
        LlegeixArxiuDepartments(arxiu1, departments);
        LlegeixArxiuEmployees(arxiu2, employees);

        // Càrrega els 'Map' 'depEmps' i 'empDeps' a partir de les 'List' 'departments' i 'employees'
        carregaDepEmps(depEmps, departments, employees);  // Relacio 1:N
        carregaEmpDeps(empDeps, departments, employees);  // Relació N:1

        // Mostrar les estructures de memòria:
        mostraDepartments(departments);
        mostraEmployees(employees);
        mostraDepEmps(depEmps);
        mostraEmpDeps(empDeps);
        
    }

    private static void LlegeixArxiuDepartments(String arxiu, List<Department> departments) throws IOException, Exception {
        String linea;
        String[] parts;
        Department department;
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split(";");

                        department = new Department( Integer.parseInt(parts[0].trim()),
                                                     parts[1].trim() );
                        departments.add(department);

                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static void LlegeixArxiuEmployees(String arxiu, List<Employee> employees) throws IOException, Exception {
        String linea;
        String[] parts;
        Employee employee;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {   
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx; yyyy; zzzz; ...
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        parts = linea.split(";");
                        employee = new Employee( Integer.parseInt(parts[0].trim()), 
                                                 parts[1].trim(), 
                                                 parts[2].trim(), 
                                                 parts[3].trim(),
                                                 Integer.parseInt(parts[4].trim()) );
                        employees.add(employee);
                    }
                } catch (Exception e) {
                    System.err.println("Error carregant Employee: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
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
    
    private static void carregaDepEmps(Map<Department, List<Employee>> depEmps, List<Department> departments, List<Employee> employees) {
        // Crea 'depEmps' a partir de 'departments'
        for (Department d : departments) {  
            depEmps.put(d, new ArrayList<>());
        }
        
        // Modifica la List de 'depEmps' a partir de cada 'employee'
        for (Employee e : employees) {  // per a cada 'employee', cerca el 'department' a la 'List' i afegeix-lo a 'depEmps'
            Department department_ = new Department(e.getDepartmentId(), null);  // es crea un 'Department' temporal 'department_' amb les dades que cal cercar --> 'department_id'
            List<Employee> llistaEmployees = depEmps.get(department_); // cerca en la List per 'departmentId'
            llistaEmployees.add(e);  // afegeix 'e' a la List
            depEmps.put(department_, llistaEmployees);  // cerca en el Map 'depEmps' per 'department_' i modifica la List de 'depEmps' amb 'llistaEmployees'
        }
    }
    
    private static void carregaEmpDeps(Map<Employee, Department> empDeps, List<Department> departments, List<Employee> employees) {
        // Per a cada employees
        for (Employee e : employees) {  
            Department department = departments.get(departments.indexOf(new Department(e.getDepartmentId(), null)));  // cerca el 'department' a 'departments'
            empDeps.put(e, department);  // afegeix a 'empDeps'
        }
    }
    
    private static void mostraDepEmps(Map<Department, List<Employee>> depEmps) {
        for (Map.Entry<Department, List<Employee>> tupla : depEmps.entrySet()) {
            if (!tupla.getValue().isEmpty())
                System.out.println("Clau: " + tupla.getKey().toString() + ", Valor: " + tupla.getValue().toString());
        }
    }
    
    private static void mostraEmpDeps(Map<Employee, Department> empDeps) {
        for (Map.Entry<Employee, Department> tupla : empDeps.entrySet()) {
            System.out.println("Clau: " + tupla.getKey().toString() + ", Valor: " + tupla.getValue().toString());
        }
    }

}

