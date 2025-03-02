package ACT8_8;

// Classe Main per a proves
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller("AutoFix");
        taller.afegeixVehicle(new Cotxe("Toyota", "Corolla", 2020, 150));
        taller.afegeixVehicle(new Bicicleta("Orbea", "MX40", 2022, false));
        taller.afegeixVehicle(new Cotxe("BMW", "M3", 2018, 300));
        
        System.out.println(taller);
    }
}
