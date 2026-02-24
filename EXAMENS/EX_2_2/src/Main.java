public class Main {
    public static void main(String[] args) {
        // 1. Crear Característiques (nom, esPremium)
        Caracteristica seient = new Caracteristica("Seient XL", 10, true);
        Caracteristica maleta = new Caracteristica("Maleta 20kg", 10, true);
        
        Caracteristica llit = new Caracteristica("Llit Doble", 10, true);
        Caracteristica vistes = new Caracteristica("Vistes Mar", 10, true);

        
        // 2. Crear Transports i afegir-hi les característiques
        Vol anada1 = new Vol("PMI-BCN", false);
        anada1.afegeixCaracteristica(seient);
        anada1.afegeixCaracteristica(maleta);
        
        Vol anada2 = new Vol("PMI-BCN", true);
        anada2.afegeixCaracteristica(seient);
        anada2.afegeixCaracteristica(maleta);
        
        Maritim tornada = new Maritim("BCN-PMI", true);
        tornada.afegeixCaracteristica(seient);
        tornada.afegeixCaracteristica(maleta);

        Estancia hotel = new Estancia("Hotel", "TI"); 
        hotel.afegeixCaracteristica(llit);
        hotel.afegeixCaracteristica(vistes);
        

        PaquetVacacional paquet = new PaquetVacacional("Vacances a BCN", hotel);
        paquet.afegeixTransport(anada1);
        paquet.afegeixTransport(anada2);
        //paquet.eliminaTransport("BCN-BCN");
        paquet.afegeixTransport(tornada);
        
        System.out.println(paquet.toString());
    }
}