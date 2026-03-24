package ACT10_6C;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayDeque'
        ArrayDeque<Tasca> tasques = new ArrayDeque<>(); 
        
        // Prova de 'ArrayQueue'
        tasques.push(new Tasca(LocalDateTime.now(), "Anar al metge"));
        tasques.push(new Tasca(LocalDateTime.now(), "Anar a classe"));
        tasques.push(new Tasca(LocalDateTime.now(), "Comprar menjar"));
        tasques.push(new Tasca(LocalDateTime.now(), "Fer els ejercicis"));
        tasques.push(new Tasca(LocalDateTime.now(), "Sopar"));
        tasques.push(new Tasca(LocalDateTime.now(), "Domir"));
   
        System.out.println("-------------------");
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("-------------------");        
        System.out.println(tasques.pop().toString());
        
        System.out.println("-------------------");
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("-------------------");
        System.out.println(tasques.pop().toString());
    }
}

