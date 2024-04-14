package ACT11_6;

import java.time.LocalDate;

public class Main_ArrayMax {

    public static void main(String[] args) {
        // Declaració d''ArrayMax'
        ArrayMax<Tasca> tasquesMax = new ArrayMax<>(5);
        
        // Prova de 'ArrayMax'
        tasquesMax.add(new Tasca(LocalDate.now(), "Anar al metge"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Anar a classe"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Comprar menjar"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Fer els ejercicis"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Sopar"));
        tasquesMax.add(new Tasca(LocalDate.now(), "Domir"));  // Error: no s'admeten més de 5 tasques
        
        for (Tasca t : tasquesMax) {
            System.out.println(t.toString()); 
        }
    }
}

