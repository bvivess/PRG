package ex_final.Utils;

import ex_final.Classes.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.HashSet;

public class Gestor {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    Set<Person> people = new HashSet<>();
    Set<Department> departments = new HashSet<>();
    Set<Order> orders = new HashSet<>();
    
    // --- CARREGA EMPLOYEES    
    public void carregaDadesBBDD(){
        carregaEmployeesBBDD();
        carregaCustomersBBDD();
    }
    
    private void carregaEmployeesBBDD() {
        String sql = """
                     SELECT employee_id, first_name, last_name, email, phone_number,
                            hire_date, salary, commission_pct, d.department_id, department_name
                     FROM employees e, departments d
                     WHERE d.department_id = e.department_id
                     """;

        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) {
            Department department = null;
            
            while (resultSet.next()) {
                // cercaDepartment
                department = departments.stream()
                                        .filter(new Department(resultSet.getInt("department_id"))::equals)  
                                        .findFirst()
                                        .orElse(new Department(resultSet.getInt("department_id"),
                                                               resultSet.getString("department_name")));
                
                departments.add(department);
                
                people.add( new Employee( resultSet.getInt("employee_id"),
                                          resultSet.getString("first_name"),
                                          resultSet.getString("last_name"),
                                          resultSet.getString("email"),
                                          resultSet.getString("phone_number"),
                                          resultSet.getDate("hire_date").toLocalDate(),
                                          resultSet.getDouble("salary"),
                                          resultSet.getDouble("commission_pct"),
                                          department ));
            }

        } catch (SQLException e) {
            System.out.println("Error SQL carregant clients: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error llegint fitxer de configuració BBDD: " + e.getMessage());
        }
    }
    
    private void carregaCustomersBBDD() {
        String sql = """
                     SELECT 1000+c.customer_id customer_id, cust_first_name, cust_last_name, cust_email, phone_numbers,
                            marital_status, gender,
                            order_id, order_date, order_total
                     FROM customers c, orders o
                     WHERE c.customer_id = o.customer_id
                     """;

        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) {
            while (resultSet.next()) {
                // Customer
                Customer customer =  people.stream()
                                           .filter(p -> p instanceof Customer)
                                           .map(p -> (Customer) p)
                                           .filter(new Customer(resultSet.getInt("customer_id"))::equals)  
                                           .findFirst()
                                           .orElse(new Customer( resultSet.getInt("customer_id"),
                                                                 resultSet.getString("cust_first_name"),
                                                                 resultSet.getString("cust_last_name"),
                                                                 resultSet.getString("cust_email"),
                                                                 resultSet.getString("phone_numbers"),
                                                                 MaritalStatus.valueOf(resultSet.getString("marital_status").toUpperCase()),
                                                                 Gender.valueOf(resultSet.getString("gender").toUpperCase()) ));
                people.add( customer );
                
                // Order
                Order order = new Order( resultSet.getInt("order_id"),
                                         resultSet.getDate("order_date").toLocalDate(),
                                         resultSet.getDouble("order_total"));
                orders.add(order);
                
                // Customer-Orders
                customer.afegeixOrder( order );
            }
        } catch (SQLException e) {
            System.out.println("Error SQL carregant clients: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error llegint fitxer de configuració BBDD: " + e.getMessage());
        }
    }
    
    public void descarregaDadesCVS(String path) {
        try {
            Files.write( Paths.get(path),
                people.stream()
                      .sorted()
                      .map(person -> person.getId() + ";" +
                                     person.getFirstName() + ";" +
                                     person.getLastName() + ";" +
                                     person.getEmail() + ";" +
                                     person.getPhoneNumber())
                      .toList()
            );

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CSV: " + e.getMessage());
        }
    }
    
    // MOSTRA
    public void mostraDades(){
        System.out.println("CÀRREGA DADES");
        System.out.println("DEPARTMENTS-----------------------------------------");
        System.out.println("1. Nom departaments ordenats descendentment");
        this.departments.stream()
                        .map(d->d.getName())
                        .sorted((a, b) -> b.compareTo(a))
                        .forEach(System.out::println);
        System.out.println("PERSONES-----------------------------------------");
        System.out.println("2. Nom empleats dpt=80 ordenats alfabèticament");
        this.people.stream()
                   .filter(p -> p instanceof Employee)
                   .map(p -> (Employee) p)
                   .filter(p->p.getDepartment().getId() == 80)
                   .map(p->p.getLastName()+", "+p.getFirstName())
                   .sorted()
                   .forEach(System.out::println);
        System.out.println("ORDERS----------------------------------------------");
        System.out.println("Mitjana import de les orders: " + 
            this.orders.stream()
                       .mapToDouble(p->p.getTotal())
                       .sum() / (double) this.orders.size()
        );
    }
    
    public void mostraDepartments() {
        this.departments.stream()
                        .sorted()
                        .forEach(System.out::println);
    }
    
    public void mostraPeople() {
        this.people.stream()
                      .sorted()
                      .forEach(System.out::println);
    }
    
    public void mostraOrders() {
        this.orders.stream()
                   .sorted()
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
    
    
    // GETTER
    public GestorBBDD getGestorBBDD() {
        return gestorBBDD;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Set<Order> getOrders() {
        return orders;
    }
    
}