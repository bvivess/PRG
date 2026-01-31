package EX_2_2;

public class Main {
    public static void main(String[] args) {
        Servidor servidor = new Servidor("SRV001", "Servidor 1", 200, "i9", 64);
        servidor.afegeixModul(new Modul("Font alimentació", 30));
        servidor.afegeixComponent(new Component("HD 1TB SSD", 20));
        servidor.afegeixComponent(new Component("RAID", 20));

        Sobretaula sobretaula = new Sobretaula("ET001", "Estació de treball 1", 150, "i3", 8);
        sobretaula.afegeixModul(new Modul("Font alimentació", 20));
        sobretaula.afegeixComponent(new Component("HD 500GB SSD", 10));
        sobretaula.afegeixComponent(new Component("Tarjeta gràfica", 100));    

        Portatil portatil = new Portatil("PT001", "Portàtil 1", 0, "i5", 16);
        sobretaula.afegeixModul(new Modul("Font alimentació", 200));
        sobretaula.afegeixComponent(new Component("USB 500GB SSD", 10));  
        
        Encaminador encaminador = new Encaminador("RT001", "Router 1", 100, 16);
        encaminador.afegeixModul(new Modul("Font alimentació", 10));
        
        Commutador commutador = new Commutador("SW001", "Switch 1", 120, 32);
        commutador.afegeixModul(new Modul("Font alimentació", 10));

        System.out.println(servidor.toString());
        System.out.println("----------------------");
        System.out.println(sobretaula.toString());
        System.out.println("----------------------");
        System.out.println(portatil.toString());;
        System.out.println("----------------------");
        System.out.println(encaminador.toString());
        System.out.println("----------------------");
        System.out.println(commutador.toString());

    }
}
