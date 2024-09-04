package ACT10_6B;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Declaraci� d''ArrayMax'
        ArrayMax<Tasca> tasques = new ArrayMax<>(5);  // nombre m�xim d'elements perm�s? 5
        
        // Prova de 'ArrayMax'
        tasques.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.add(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.add(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.add(new Tasca(LocalDate.now(), "Sopar"));
        tasques.add(new Tasca(LocalDate.now(), "Domir"));  // Error: no s'admeten m�s de 5 tasques
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

