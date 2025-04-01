package ACT11_2B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        String arxiu1 = "C:\\temp\\ACT11_2B_departments.cvs";
        String arxiu2 = "C:\\temp\\ACT11_2B_employees.cvs";
        Map<Integer, Employee> employees = new HashMap<>();
        Map<Integer, Department> departments = new HashMap<>();
        Map<Department, List<Employee>> depEmps = new HashMap<>();

        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader(arxiu1));
              BufferedReader bufferedReader2 = new BufferedReader(new FileReader(arxiu2));
            ) {
            
            // Llegir el contingut línia a línia
            LlegeixArxiuDepartments(bufferedReader1, departments);
            LlegeixArxiuEmployees(bufferedReader2, employees);
           
            // Càrrega 'depEmps'
            carregaDepEmps(depEmps, departments, employees);
            // Mostrar el map
            //mostraDepartments(departments);
            //mostraEmployees(employees);
            mostraDepEmps(depEmps);

        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }

    private static void LlegeixArxiuDepartments(BufferedReader bufferedReader, Map<Integer,Department> departments) throws IOException, Exception {
        String linea;
        String[] parts;
        Integer clau;
        Department department;
        
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: xxxx; yyyy; zzzz; ...
                if (!(linea.isEmpty() || linea.startsWith("#"))) {
                    parts = linea.split(";");
                    if (!linea.substring(0, 1).equals("#")) {
                        clau = Integer.valueOf(parts[0].trim());
                        department = new Department(Integer.parseInt(parts[0]), parts[1].trim());
                        departments.put(clau, department);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error carregant Employee: " + e.getMessage());
            }
        }
    }
    
    private static void LlegeixArxiuEmployees(BufferedReader bufferedReader, Map<Integer,Employee> employees) throws IOException, Exception {
        String linea;
        String[] parts;
        Integer clau;
        Employee employee;
        
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: xxxx; yyyy; zzzz; ...
                if (!(linea.isEmpty() || linea.startsWith("#"))) {
                    parts = linea.split(";");
                    if (!linea.substring(0, 1).equals("#")) {
                        clau = Integer.valueOf(parts[0].trim());
                        employee = new Employee(Integer.parseInt(parts[0]), parts[1].trim(), parts[2].trim(), parts[3].trim(), Integer.valueOf(parts[4].trim()));
                        employees.put(clau, employee);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error carregant Employee: " + e.getMessage());
            }
        }
    }

    private static void mostraDepartments(Map<Integer,Department> departments) {
        for (Integer k : departments.keySet()) {
            Department v = departments.get(k);
            System.out.println(k + " = " + v);
        }
    }
    
    private static void mostraEmployees(Map<Integer,Employee> employees) {
        for (Integer k : employees.keySet()) {
            Employee v = employees.get(k);
            System.out.println(k + " = " + v);
        }
    }
    
    private static void carregaDepEmps(Map<Department, List<Employee>> depEmps, Map<Integer,Department> departments, Map<Integer,Employee> employees) {
        for (Department d : departments.values()) {
            depEmps.put(d, new ArrayList<>());
        }
        for (Employee e : employees.values()) {
            Department d_ = new Department(e.getDepartmentId(),null);
            List<Employee> e_ = depEmps.get(d_); // cerca per 'departmentId'
            e_.add(e);
            depEmps.put(d_,e_);  // Modifica l'array
        }
    }
    
    private static void mostraDepEmps(Map<Department, List<Employee>> depEmps) {
        for (Map.Entry<Department, List<Employee>> tupla : depEmps.entrySet()) {
            if (!tupla.getValue().isEmpty())
                System.out.println("Clau: " + tupla.getKey().toString() + ", Valor: " + tupla.getValue().toString());
        }
    }

}

