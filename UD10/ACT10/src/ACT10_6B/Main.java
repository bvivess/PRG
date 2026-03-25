package ACT10_6B;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArrayQueue'
        ArrayQueue<Tasca> tasques = new ArrayQueue<>(); 
        
        // Prova de 'ArrayQueue'
        tasques.offer(new Tasca(LocalDateTime.now(), "Anar a classe"));
        tasques.offer(new Tasca(LocalDateTime.now(), "Comprar menjar"));
        tasques.offer(new Tasca(LocalDateTime.now(), "Fer els ejercicis"));
        tasques.offer(new Tasca(LocalDateTime.now(), "Sopar"));
        tasques.offer(new Tasca(LocalDateTime.now(), "Llegir un llibre"));
        tasques.offer(new Tasca(LocalDateTime.now(), "Domir"));
   
        System.out.println("-------------------");
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("-------------------");        
        System.out.println(tasques.poll().toString());
        
        System.out.println("-------------------");
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("-------------------");
        System.out.println(tasques.poll().toString());
    }
}

