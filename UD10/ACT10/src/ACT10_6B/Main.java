package ACT10_6B;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayMax'
        ArrayMax<Tasca> tasques = new ArrayMax<>(5);  // nombre màxim d'elements permès? 5
        
        // Prova de 'ArrayMax'
        tasques.add(new Tasca(LocalDateTime.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDateTime.now(), "Anar a classe"));
        tasques.add(new Tasca(LocalDateTime.now(), "Comprar menjar"));
        tasques.add(new Tasca(LocalDateTime.now(), "Fer els ejercicis"));
        tasques.add(new Tasca(LocalDateTime.now(), "Sopar"));
        tasques.add(new Tasca(LocalDateTime.now(), "Domir"));  // Error: no s'admeten més de 5 tasques
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

