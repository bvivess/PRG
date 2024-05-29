package EXAMEN2_PERE;

import java.io.*;
import java.util.*;

/**
 *
 * @author Pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Set<Job> jobs = new HashSet<>();
        Set<Employee> employees = new HashSet<>();
        Set<Job> newJobs = new HashSet<>();
        Set<Employee> newEmployees = new HashSet<>();
        try {
            arxiuAObjectes("c:\\temp\\employees.txt", jobs, employees);
            mostrarObjectes(jobs, employees);
            objectesASerialitzacio("c:\\temp\\employees.ser\\", jobs, employees);
            objectesADeserialitzacio("c:\\temp\\employees.ser\\", newJobs, newEmployees);
            mostrarObjectes(newJobs, newEmployees);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private static void arxiuAObjectes(String arxiu, Set<Job> jobs, Set<Employee> employees) {
        int employeeId = 0;
        String firstName = "";
        String lastName = "";
        String eMail = "";
        String jobId = "";
        String jobTitle = "";
        File nomArxiu = new File(arxiu);
        try (BufferedReader bR = new BufferedReader(new FileReader(nomArxiu))) {
            String linia;
            int cont = 0;
            String[] parts;
            while ((linia = bR.readLine()) != null) {
                parts = linia.split("\\s");  // CORRECCIÓ: convé fer un 'split("\\s+",2)'
                if (cont != (cont * 7)) {  // CORRECCIÓ: és més elegant emprar l'operador 'RESIDU(7)' en comptes de fer l'operació que fas
                    if (parts[0].trim().equals("employee_id")) {
                        employeeId = Integer.parseInt(parts[1].trim());
                    } else if (parts[0].trim().equals("first_name")) {
                        firstName = parts[1].trim();
                    } else if (parts[0].trim().equals("last_name")) {
                        lastName = parts[1].trim();
                    } else if (parts[0].trim().equals("email")) {
                        eMail = parts[1].trim();
                    } else if (parts[0].trim().equals("job_id")) {
                        jobId = parts[1].trim();
                    } else if (parts[0].trim().equals("job_title")) {
                        jobTitle = parts[1].trim();
                    }
                    // CORRECCIÓ: has basat l'algoritme en llegir 7 líniea (una per a cada variable)
                    // així, en tenir les 7 hauries de crear l'objecte en el set tal i com t'indic a continuació
                    // donat que no tens en compte això, cada empleat l'introdueixes 7 vegades ...
                } else {
                    employees.add(new Employee(employeeId, firstName, lastName, eMail, jobId, jobTitle));
                    jobs.add(new Job(jobId, jobTitle));
                }
                cont++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarObjectes(Set<Job> jobs, Set<Employee> employees) {
        for (Job j : jobs) {
            System.out.println(j.toString());
        }
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private static void objectesASerialitzacio(String arxiu2, Set<Job> jobs, Set<Employee> employees){
        // SerialitzaciÃ³
        try(FileOutputStream fos = new FileOutputStream(arxiu2);
            ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(employees);
        } catch (IOException e) {
            System.out.println("Exception writing 'Employees': " + e);
        }
        
        try (FileOutputStream fos = new FileOutputStream(arxiu2);
            ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(jobs);
        } catch (IOException e) {
            System.out.println("Exception writing 'Jobs': " + e);
        }
    }
    
    private static void objectesADeserialitzacio(String arxiu2, Set<Job> newJobs, Set<Employee> newEmployees) {
        try (FileInputStream fis = new FileInputStream(arxiu2);
            ObjectInputStream in = new ObjectInputStream(fis)) {
            Employee newE = (Employee) in.readObject();  // CORRECCIÓ: aquest objecte no cal crear-lo, per això tens els paràmetres d'E/S
            /*
            for (Employee e : newE.newEmployees) {
                System.out.println(e);
            }
            */
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading 'Empleats': " + i);
        }
        
        try (FileInputStream fis = new FileInputStream(arxiu2);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            Job newJ = (Job) in.readObject();  // CORRECCIÓ: aquest objecte no cal crear-lo, per això tens els paràmetres d'E/S
            /*
            for (Employee e : newJ.newJobs) {
                System.out.println(e);
            }
            */
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading 'Jobs': " + i);
        }
    }

}
