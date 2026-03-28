package ACT10_5;


// Classe de prova
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();

        System.out.println("=== Inicia Registre ===");
        taller.registraVehicle("1234ABC", "Toyota", "Corolla", 2015);
        taller.registraVehicle("5678DEF", "Honda", "Civic", 2018);
        taller.registraVehicle("9999XYZ", "Ford", "Focus", 2020);
        taller.registraVehicle("1234ABC", "BYD", "Ato III", 2025);  // Error
        taller.registraVehicle("9876XYZ", "BYD", "Ato III", 2025);

        System.out.println("=== Vehicles registrats ===");
        taller.mostraVehiclesRegistrats();
        
        System.out.println("=== Inicia Diagnòstic ===");
        taller.iniciaDiagnostic();  // Inicia el diagnòstic del primer de la cua
        taller.iniciaDiagnostic();  // Inicia el diagnòstic del primer de la cua

        System.out.println("=== Inicia reparació ===");
        taller.enviaAReparacio("1234ABC");  // Canvia estat
        taller.enviaAReparacio("5678DEF");  // Canvia estat

        System.out.println("=== Finalitza reparació ===");
        taller.finalitzaReparacio("1234ABC");  // Canvia estat

        System.out.println("=== Vehicles per estat ===");
        taller.mostraVehiclesPerEstat();

        System.out.println("=== Vehicles reparats ===");
        taller.mostraHistorics();
        
        System.out.println("=== Cua recepció ===");
        taller.mostraCuaRecepcio();
    }
}