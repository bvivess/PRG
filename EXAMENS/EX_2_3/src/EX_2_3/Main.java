package EX_2_3;

import EX_2_3.Consumicions.*;

public class Main {
    
    public static void main(String[] args) {
        Dolc pastis1 = new Dolc("Pastís de Poma", 10);
        Dolc pastis2 = new Dolc("Pastís de maduixa", 10);
        Salat patatilla = new Salat("Patatilla", 10);
        
        Refresc tonica = new Refresc("Refresc de tonica", 10);
        Infusio cafe = new Infusio("Café", 10, true);
        Alcohol gin = new Alcohol("Ginebra", 10, 5);
        Combinat ginTonic = new Combinat("Gintonic", 20);
        ginTonic.afegeixBeure(tonica);
        ginTonic.afegeixBeure(tonica);  // prova de no duplicitat
        ginTonic.afegeixBeure(gin);
        ginTonic.afegeixBeure(cafe);
        ginTonic.eliminaBeure("Café");  // Prova d'eliminació
        
        Carta carta = new Carta();
        carta.afegeixConsumicio(pastis1);
        carta.afegeixConsumicio(pastis1);  // prova de no duplicitat
        carta.afegeixConsumicio(pastis2);
        carta.eliminaConsumicio("Pastís de maduixa");  // Prova d'eliminació
        carta.afegeixConsumicio(patatilla);
        carta.afegeixConsumicio(tonica);
        carta.afegeixConsumicio(cafe);
        carta.afegeixConsumicio(gin);
        carta.afegeixConsumicio(ginTonic);
        
        System.out.println(carta.toString());
    }
    
}
