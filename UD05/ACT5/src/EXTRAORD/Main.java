package EXTRAORD;

// Main Class
public class Main {
    public static void main(String[] args) {
        Flota flota = new Flota();

        // Creació de vehicles
        Cotxe cotxe1 = new Cotxe("1234ABC", 12000, 5);
        Cotxe cotxe2 = new Cotxe("1234DEF", 16000, 4);
        Camio camio1 = new Camio("6789TVW", 25000, 10000);
        Camio camio2 = new Camio("6789XYZ", 35000, 15000);
        
        // Afegir vehicles a la flota
        flota.afegeixVehicle(cotxe1);
        flota.afegeixVehicle(cotxe2);
        flota.afegeixVehicle(camio1);
        flota.afegeixVehicle(camio2);

        // Creació de conductors
        Conductor conductor1 = new Conductor("Joan", 45, "Professional");
        Conductor conductor2 = new Conductor("Anna", 30, "Professional");
        Conductor conductor3 = new Conductor("Pere", 28, "Particular");

        // Afegir conductors a la flota
        flota.afegeixConductor(conductor1);
        flota.afegeixConductor(conductor2);
        flota.afegeixConductor(conductor3);

        // Assignar vehicles a conductors
        conductor1.assignaConductor(cotxe1);
        conductor1.assignaConductor(cotxe2);
        conductor2.assignaConductor(camio1);
        conductor2.assignaConductor(camio2);

        // Gestionar vehicles i conductors
        System.out.println("\n--- Flota ---");
        System.out.println(flota.toString());
    }
}
