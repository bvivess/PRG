package ACT11_6;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ArraySet<Tasca> tasques = new ArraySet<>();
        
        tasques.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDate.now(), "Anar a classe"));
        tasques.add(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasques.add(new Tasca(LocalDate.now(), "Fer els ejercicio"));
        tasques.add(new Tasca(LocalDate.now(), "Sopar"));
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

