package ACT10_7E;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Declaració d''CircularArray'
        CircularArray<Tasca> tasques = new CircularArray<>();  // nombre màxim d'elements permès? 5
        
        try {
            // Prova de 'CircularArray'
            tasques.add(new Tasca(LocalDateTime.now(), "Anar a classe"));
            tasques.add(new Tasca(LocalDateTime.now(), "Comprar menjar"));
            tasques.add(new Tasca(LocalDateTime.now(), "Fer els ejercicis"));
            tasques.add(new Tasca(LocalDateTime.now(), "Sopar"));
            tasques.add(new Tasca(LocalDateTime.now(), "Llegir un llibre"));
            tasques.add(new Tasca(LocalDateTime.now(), "Domir"));  // Error: no s'admeten més de 5 tasques

            System.out.println(tasques.get(6).toString()); 
            System.out.println(tasques.get(7).toString());
            System.out.println(tasques.get(21).toString());
        } catch (Exception e) {
            System.out.println("S'ha produït un error: " + e.getMessage());
        }
    }
}

