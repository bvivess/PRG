package EX_2_1;

public class Main {
    public static void main(String[] args) {
        // Creació d'objectes
        // Servidor
        Servidor servidor = new Servidor("Dell", "PowerEdge R750", 3500, "ATX");
        servidor.setCaracteristica(new Caracteristica("Processador Xeon"));
        servidor.setCaracteristica(new Caracteristica("Ampliacio RAM 64GB"));
        servidor.afegeixComplement(new Complement("Memoria RAM 64GB", 300));
        servidor.afegeixComplement(new Complement("Disc SSD 1TB", 150));
        servidor.afegeixComplement(new Complement("Docking station", 200));
        
        // Escriptori
        Escriptori escriptori = new Escriptori("HP", "EliteDesk 800", 1200, "microATX");
        escriptori.setCaracteristica(new Caracteristica("Grafica NVIDIA RTX 3060"));
        escriptori.setCaracteristica(new Caracteristica("Tarjeta so AMD"));
        escriptori.afegeixComplement(new Complement("Funda de proteccio", 50));
        escriptori.afegeixComplement(new Complement("Auriculars sense fils", 120));
        
        // Tablet
        Tablet tablet = new Tablet("Apple", "iPad Pro", 1000, "12'");
        tablet.setCaracteristica(new Caracteristica("Pantalla Retinax"));
        
        // Telefon
        Telefon telefon = new Telefon("Samsung", "Galaxy S23", 900, "5'");
        telefon.setCaracteristica(new Caracteristica("Pantalla AMOLED 120Hz"));
        
        // Portatil
        Portatil portatil = new Portatil("Lenovo", "ThinkPad X1", 1800, "17'", "1.3kg");
        portatil.setCaracteristica(new Caracteristica("Teclat retroil.luminat"));


        // Impressió dels dispositius
        System.out.println("DISPOSITIUS");
        System.out.println(servidor);
        System.out.println();
        System.out.println(escriptori);
        System.out.println();
        System.out.println(tablet);
        System.out.println();
        System.out.println(telefon);
        System.out.println();
        System.out.println(portatil);
        
        // Comparacions
        System.out.println("\n\nCOMPARACIONS");
        Servidor servidor2 = new Servidor("IBM", "RS6000", 4000, "ATX");
        if (servidor.equals(servidor2))
            System.out.println("Els servidors son iguals");
        else
            System.out.println("Els servidors son diferents");
        
        Servidor servidor3 = new Servidor("Dell", "PowerEdge R750", 400, "microATX");
        if (servidor.equals(servidor3))
            System.out.println("Els servidors son iguals");
        else
            System.out.println("Els servidors son diferents");
        
        Portatil portatil2 = new Portatil("Lenovo", "ThinkPad X1", 1800, "14'", "1kg");
        if (portatil.equals(portatil2))
            System.out.println("Els portatils son iguals");
        else
            System.out.println("Els portatils son diferents");
        
        Portatil portatil3 = new Portatil("Lenovo", "ThinkPad X1", 1800, "17'", "1.5kg");
        if (portatil.equals(portatil3))
            System.out.println("Els portatils son iguals");
        else
            System.out.println("Els portatils son diferents");
    }
}



