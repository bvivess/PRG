package ACT10_5;


// Classe de prova
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();

        taller.registraVehicle("1234ABC", "Toyota", "Corolla", 2015);
        taller.registraVehicle("5678DEF", "Honda", "Civic", 2018);
        taller.registraVehicle("9999XYZ", "Ford", "Focus", 2020);

        taller.mostraVehiclesRegistrats();
        taller.iniciaDiagnostic();
        taller.iniciaDiagnostic();

        taller.enviaAReparacio("1234ABC");
        taller.enviaAReparacio("5678DEF");

        taller.finalitzaReparacio("1234ABC");

        taller.mostraVehiclesPerEstat();
        taller.mostraHistorics();
        taller.mostraCuaRecepcio();
    }
}