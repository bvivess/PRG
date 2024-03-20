package ACT11_2B;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        
        // Càrrega de l'agenda
        agenda.afegeixTasca(LocalDate.of(2024, 1, 01), LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 01), LocalTime.of(12,00), "Tasca2");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 01), LocalTime.of(18,00), "Tasca3");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 02), LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 03), LocalTime.of(10,00), "Tasca1");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 03), LocalTime.of(12,00), "Tasca2");

        System.out.println(agenda.toString());
        
        agenda.afegeixTasca(LocalDate.of(2024, 1, 02), LocalTime.of(12,00), "Tasca2");
        agenda.afegeixTasca(LocalDate.of(2024, 1, 02), LocalTime.of(18,00), "Tasca3");
        System.out.println("-------------------------");
        System.out.println(agenda.toString());      
        
        // 
        agenda.eliminaTasca(LocalDate.of(2024, 1, 01), LocalTime.of(10,00));
        System.out.println("-------------------------");
        System.out.println(agenda.toString());
    }
}

