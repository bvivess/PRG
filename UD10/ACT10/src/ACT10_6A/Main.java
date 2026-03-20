package ACT10_6A;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArraySet'
        ArraySet<Tasca> tasques = new ArraySet<>();
       
        // Prova de 'ArraySet'
        LocalDateTime dataHora = LocalDateTime.now();
        tasques.add(new Tasca(dataHora, "Anar al metge"));
        tasques.add(new Tasca(dataHora, "Anar a classe"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(dataHora, "Comprar menjar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(dataHora, "Fer els ejercicis"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(dataHora, "Sopar"));  // Error: no s'admeten 2 tasques pel mateix dia
        tasques.add(new Tasca(dataHora, "Domir"));  // Error: no s'admeten 2 tasques pel mateix dia
        
        for (Tasca t : tasques) {
            System.out.println(t.toString()); 
        }

    }
}

