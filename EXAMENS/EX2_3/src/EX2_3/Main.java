package EX2_3;

// Classe Main
public class Main {
    public static void main(String[] args) {
        // Ingredients
        Ingredient enciam = new Ingredient("Enciam", true, true);
        Ingredient tomaquet = new Ingredient("Tomàquet", true, true);
        Ingredient arros = new Ingredient("Arròs", true, true);
        Ingredient marisc = new Ingredient("Marisc", false, true);
        Ingredient llet = new Ingredient("Llet", false, true);
        Ingredient sucre = new Ingredient("Sucre", true, true);

        // Plats
        PrimerPlat primer = new PrimerPlat("Amanida");
        primer.afegeixIngredient(enciam);
        primer.afegeixIngredient(enciam);  // Error
        primer.afegeixIngredient(tomaquet);

        SegonPlat segon = new SegonPlat("Paella");
        segon.afegeixIngredient(arros);
        segon.afegeixIngredient(marisc);

        Postre postre = new Postre("Gelat","dolc");
        postre.afegeixIngredient(llet);
        postre.afegeixIngredient(sucre);
        
        // Begudes
        Refresc aigua = new Refresc("Aigüa");
        Espirituosa vi = new Espirituosa("Vi Negre", 5);

        // Afegir ingredients a 'Plat'

        // Afegir plats a 'menu'
        Menu menu = new Menu("Menu1");
        menu.afegeixPlat(primer);
        menu.afegeixPlat(primer);  // Error
        menu.afegeixPlat(segon);
        menu.afegeixPlat(postre);
        
        Carta carta = new Carta();
    
        // Afegir menu i plats a 'carta'
        carta.afegeixMenu(menu);
        carta.afegeixPlat(primer);
        carta.afegeixPlat(segon);
        carta.afegeixPlat(postre);
        carta.afegeixBeguda(aigua);
        carta.afegeixBeguda(vi);

        System.out.println(carta.toString());
    }
}







