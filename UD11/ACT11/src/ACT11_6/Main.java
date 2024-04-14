package ACT11_6;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ArraySet<Tasca> tasques = new ArraySet<>();
        
        tasques.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDate.now(), "Anar a classe"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Comprar menjar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Fer els ejercicio"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Sopar"));  // Error: no s'admeten 2 tasques pel mateix dia
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
    }
}

