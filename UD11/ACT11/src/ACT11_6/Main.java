package ACT11_6;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ArraySet<Tasca> tasques = new ArraySet<>();
        ArrayMax<Tasca> tasquesMax = new ArrayMax<>(5);
        
        tasques.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasques.add(new Tasca(LocalDate.now(), "Anar a classe"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Comprar menjar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Fer els ejercicis"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Sopar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(LocalDate.now(), "Domir"));  // Error: no s'admeten 2 tasques pel mateix dia
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }
        
        System.out.println("----------------------------------------");
        
        tasquesMax.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Anar a classe"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Sopar"));
        tasques.add(new Tasca(LocalDate.now(), "Domir"));  // Error: no s'admeten més de 5 tasques
        
        for (Tasca t : tasquesMax) {
            System.out.println(t.toString()); 
        }
    }
}

