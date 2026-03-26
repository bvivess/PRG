package ACT10_5;


// Classe de prova
public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();

        taller.registraVehicle("1234ABC", "Toyota", "Corolla", 2015);
        taller.registraVehicle("5678DEF", "Honda", "Civic", 2018);
        taller.registraVehicle("9999XYZ", "Ford", "Focus", 2020);

        taller.mostraVehiclesRegistrats();
        taller.iniciaDiagnostic();  // Inicia el diagnòstic del primer de la cua
        taller.iniciaDiagnostic();  // Inicia el diagnòstic del primer de la cua

        taller.enviaAReparacio("1234ABC");  // Canvia estat
        taller.enviaAReparacio("5678DEF");  // Canvia estat

        taller.finalitzaReparacio("1234ABC");  // Canvia estat

        taller.mostraVehiclesPerEstat();
        taller.mostraHistorics();
        taller.mostraCuaRecepcio();
    }
}