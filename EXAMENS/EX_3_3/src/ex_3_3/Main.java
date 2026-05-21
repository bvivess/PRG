package ex_3_3;

import ex_3_3.Classes.*;
import ex_3_3.Utils.GestorTitanic;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static String arxiu = "c:\\temp\\Titanic_Passengers.csv";
    static String arxiuLog = "c:\\temp\\Titanic_Passengers.log";
    
    public static void main(String[] args) {
        GestorTitanic gestor = new GestorTitanic();
        
        try {
            gestor.llegeixCSV(arxiu, arxiuLog);
            Set<Ticket> tickets = gestor.getTickets();
            Set<Passenger> passengers = gestor.getPassengers();
            
            System.out.println("RESUM DE LA CÀRREGA:");
            System.out.println("\tTickets: " + gestor.getTickets().size());
            System.out.println("\tPassatgers: " + gestor.getPassengers().size());

            // 1. Nom de les persones que varen sobreviure ordenades per nom
            System.out.println("\nPASSATGERS SUPERVIVENTS:");
            List<String> solucio1 = 
                passengers.stream()
                           .filter(Passenger::getSurvived)
                           .map(p -> p.getName())
                           .sorted()
                           .collect(Collectors.toList());
            System.out.println("\t" + solucio1);
            
            // 2. Nom de les persones amb camarot assignat (not null) i que no varen sobreviure, ordenats per TicketID
            System.out.println("\nPASSATGERS AMB CAMAROT INFORMAT:");
            List<String> solucio2 = 
                passengers.stream()
                          .filter(p -> p.getTicket().getCabinId() != null &&
                                      !p.getTicket().getCabinId().isEmpty() &&
                                      !p.getSurvived())
                          .sorted()
                          .map(Passenger::getName)
                          .collect(Collectors.toList());
            System.out.println("\t" + solucio2);
            
            // 3. Llista de tickets de classe=1
            System.out.println("\nLLISTA DE TICKETS AMB CLASSE 1:");
            List<Ticket> solucio3 = 
                tickets.stream()
                       .filter(t->t.getClassId()==1)
                       .collect(Collectors.toList());
            System.out.println("\t" + solucio3);
            
            // 4. Passatgers que ocupaven el TicketId="1601"
            System.out.println("\nPASSATGERS EN TICKET='1601':");
            List<Passenger> solucio4 =
                passengers.stream()
                          .filter(p->p.getTicket().getTicketId().equals("1601"))
                          .collect(Collectors.toList());
            System.out.println("\t" + solucio4);
            
            // 5. Ràtio de persones supervivents: núm sobrevivents / total passatgers per a cada Classe (1,2,3)
            System.out.println("\nRATIO SUPERVIVENTS PER CLASSE (1,2,3):");
            passengers.stream()
                      .map(p -> p.getTicket().getClassId())
                      .distinct()
                      .sorted()
                      .forEach(classId -> { double ratio = passengers.stream()
                                                                     .filter(Passenger::getSurvived)
                                                                     .filter(p -> p.getTicket().getClassId() == classId)
                                                                     .count() / (double) passengers.size();
                                            System.out.println("\tCLASSE " + classId + ": " + ratio); });
        } catch (IOException e) {
            System.out.println("Error I/O general: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

}