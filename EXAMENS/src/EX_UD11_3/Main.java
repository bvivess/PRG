package EX_UD11_3;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        CircularQueue<Tasca> tasques = new CircularQueue<>(5);
        
        tasques.offer(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.offer(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.offer(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.offer(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.offer(new Tasca(LocalDate.now(), "Sopar"));
        //tasques.poll();
        tasques.offer(new Tasca(LocalDate.now(), "Dormir"));
        tasques.enQueue();

        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

