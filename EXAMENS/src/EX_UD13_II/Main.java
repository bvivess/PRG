package EX_UD13_II;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {
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
    
    private static void arxiuAObjectes(String nomArxiu, Set<Job> jobs, Set<Employee> employees) throws FileNotFoundException, IOException{
        File nomArxiu2 = new File(nomArxiu); 
        int employeeId=0;
        String firstName="";
        String lastName="";
        String eMail="";
        String jobId="";
        String jobTitle="";
        
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu))) {
            String linia = linia = bufInput.readLine();
            while ((linia = bufInput.readLine()) != null) {
                if (!linia.startsWith("-"))
                    try {
                        String[] parts = linia.split("\\s",2);
                        String clau = parts[0].trim();
                        String valor = parts[1].trim();

                        switch (clau) {
                            case "employee_id" -> employeeId = Integer.parseInt(valor);
                            case "first_name" -> firstName = valor;
                            case "last_name" -> lastName = valor;
                            case "email" -> eMail = valor;
                            case "job_id" -> jobId = valor;
                            case "job_title" -> jobTitle = valor;
                            default -> System.err.println("Clau no vàlida: " + clau);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        // En cas de '#', l'split no funciona
                        // No fer res
                    }

                else {
                    Job job = new Job(jobId, jobTitle);
                    Employee employee = new Employee(employeeId, firstName, lastName, eMail, jobId);

                    //if (!regions.containsKey(regionId))
                        jobs.add(job);

                    //if (!countries.containsKey(countryId))
                        employees.add(employee);
                }
            }
        } catch (FileNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void mostrarObjectes(Set<Job> jobs, Set<Employee> employees) {
        List<Job> sJobs = new ArrayList<>(jobs);
        
        // Ordenar la lista por countryId
        Collections.sort(sJobs, Comparator.comparing(Job::getJobId));
        for (Job r : sJobs) {
            System.out.println(r.toString());
        }
        
        System.out.println("--------------------------------------------");
        
        List<Employee> sEmployees = new ArrayList<>(employees);
        
        // Ordenar la lista por countryId
        Collections.sort(sEmployees, Comparator.comparing(Employee::getEmployeeId));
        for (Employee c : sEmployees)
            System.out.println(c.toString());
    }
    
    private static void objectesASerialitzacio(String nomArxiu, Set<Job> jobs, Set<Employee> employees) throws IOException {
        // Serialització
        try ( FileOutputStream fos = new FileOutputStream(nomArxiu);
            ObjectOutputStream out = new ObjectOutputStream(fos)
            ) {
            // Iterar cada 'jobs'
            for (Job j : jobs) {
                out.writeObject(j);
            }
            // Iterar cada 'employee'
            for (Employee e : employees) {
                out.writeObject(e);
            }
        } catch (IOException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
    
    private static void objectesADeserialitzacio(String nomArxiu, Set<Job> newJobs, Set<Employee> newEmployees) throws IOException, ClassNotFoundException {
        // Deserialització
        try (FileInputStream fis = new FileInputStream(nomArxiu);
             ObjectInputStream in = new ObjectInputStream(fis)) {

            Object object;
            while (true) {
                try {
                    object = in.readObject();
                    if (object instanceof Job) 
                        newJobs.add((Job) object);
                    if (object instanceof Employee) 
                        newEmployees.add((Employee) object);

                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw e;  // Es propaga l'excepció al mètode anterior
        }
    }
}
