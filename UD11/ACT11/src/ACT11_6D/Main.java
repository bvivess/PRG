package ACT11_6D;

import ACT11_6C.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayMax'
        ArrayDeque<Tasca> tasques = new ArrayDeque<>();  // nombre màxim d'elements permès? 5
        
        // Prova de 'ArrayMax'
        tasques.offer(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.offer(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.offer(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.offer(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.offer(new Tasca(LocalDate.now(), "Sopar"));
        tasques.offer(new Tasca(LocalDate.now(), "Domir"));
        tasques.poll();
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

