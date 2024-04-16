package EX_UD11_4;

import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CircularQueue<Tasca> tasques = new CircularQueue<>(2);
        tasques.offer(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.offer(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.offer(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.offer(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasques.offer(new Tasca(LocalDate.now(), "Sopar"));
        tasques.poll();
        tasques.offer(new Tasca(LocalDate.now(), "Dormir"));
        tasques.enQueue();
        
        Iterator<Tasca> iterator = tasques.iterator();
        while (iterator.hasNext()) {
            Tasca element = iterator.next();
            System.out.println(element.toString());
            //iterator.remove();
        }
      
    }
}

