package ACT11_1B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Estructures de memòria:
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        
        // Arxius per a la càrrega de dades:
        String arxiu1 = "C:\\temp\\ACT11_1B_departments.csv";
        String arxiu2 = "C:\\temp\\ACT11_1B_employees.csv";
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            LlegeixArxiuDepartments(arxiu1, departments);
            LlegeixArxiuEmployees(arxiu2, departments, employees);

            // Mostrar les estructures de memòria:
            mostraDepartments(departments);
            mostraEmployees(employees);
        } catch (Exception e) {
            System.err.println("Error general llegint l'arxiu: " + e.getMessage());
        }     
    }

    private static void LlegeixArxiuDepartments(String arxiu, List<Department> departments) throws IOException, NumberFormatException, IllegalArgumentException {
        String linia;
        Department department;
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx xxxxxxxxxxxxxxxxxxxxxxx
                    //         1    6
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        department = new Department( Integer.parseInt(linia.substring(0,4).trim()),  // departmentId
                                                     linia.substring(5,linia.length()).trim());      // departmentName
                        departments.add(department);

                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static void LlegeixArxiuEmployees(String arxiu, List<Department> departments, List<Employee> employees) throws IOException, NumberFormatException, IllegalArgumentException {
        String linia;
        int numLinia = 0;
        String[] parts;
        Department department;
        Employee employee;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {   
            while ((linia = bufferedReader.readLine()) != null) {
                try {
                    // format: wwww; xxxx; yyyy; zzzz
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        parts = linia.split(";", 5);
                        department = cercaDepartment(departments, Integer.parseInt(parts[4].trim()));  // cerca 'department' en l'arraylist 'departments'
                        
                        employee = new Employee( Integer.parseInt(parts[0].trim()),    // employeeId
                                                 parts[1].trim(),                      // firstName
                                                 parts[2].trim(),                      // lastName
                                                 parts[3].trim(),                      // email
                                                 department );                         // department
                        employees.add(employee);
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

    private static Department cercaDepartment(List<Department> departments, int departmentId) {
        int index = departments.indexOf(new Department(departmentId));  // crea un 'department' temporal per a fer la cerca per 'Objecte'
        
        return (index != -1) ?  departments.get( index ) : null;
    }
    
}

