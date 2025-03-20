package ACT10_2B1;

import ACT10_2B2.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        
        // Càrrega de l'agenda
        agenda.afegeixTasca("1/1/2004", LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca("1/1/2004", LocalTime.of(12,00), "Tasca2");
        agenda.afegeixTasca("1/1/2004", LocalTime.of(18,00), "Tasca3");
        agenda.afegeixTasca("2/1/2004", LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca("3/1/2004", LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca("3/1/2004", LocalTime.of(12,00), "Tasca2");

        System.out.println(agenda.toString());
        
        agenda.afegeixTasca("2/1/2004", LocalTime.of(12,00), "Tasca2");
        agenda.afegeixTasca("2/1/2004", LocalTime.of(18,00), "Tasca3");
        System.out.println("-------------------------");
        System.out.println(agenda.toString());      
        
        // 
        agenda.eliminaTasca(LocalDate.of(2024, 1, 01), LocalTime.of(10,00));
        System.out.println("-------------------------");
        System.out.println(agenda.toString());
        System.out.println("-------------------------");
        System.out.println("Tasca per 01/01/2024-12:00 - " +
                            agenda.obteTasca("1/1/2004", LocalTime.of(12,00)));
        System.out.println("Tasca per 02/01/2024-11:00 - " +
                            agenda.obteTasca("2/1/2004", LocalTime.of(11,00)));
    }
}

