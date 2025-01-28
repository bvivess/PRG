package ACT7_1A;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Engineer engineer = new Engineer(101, "Jane Smith", "012-34-5678", 120345.27);
        Manager manager = new Manager(207, "Barbara Johnson", "054-12-2367", 109501.36, "US Marketing");
        Admin admin = new Admin(304,"Bill Monroe", "108-23-6509", 75002.34);
        Director director = new Director(12,"Bill Monroe", "099-45-2340", 120567.36, "Global Marketing", 1000000.00);
        
        if (manager.addEmployee(admin)) 
            System.out.println(admin.getName() + " added properly to " + manager.getName() + "'s staff.");
        else
            System.err.println(admin.getName() + " NOT added properly to " + manager.getName() + "'s staff.");
        
        if (manager.addEmployee(director)) 
            System.out.println(director.getName() + " added properly to " + manager.getName() + "'s staff.");
        else
            System.err.println(director.getName() + " NOT added properly to " + manager.getName() + "'s staff.");
        
        manager.raiseSalary(10000);
        
        System.out.println(engineer.printEngineer());
        System.out.println(manager.printManager());
        System.out.println(admin.printAdmin());
        System.out.println(director.printDirector());
    }
    
}
