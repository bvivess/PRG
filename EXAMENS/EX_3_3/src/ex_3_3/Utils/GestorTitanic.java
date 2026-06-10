package ex_3_3.Utils;

import ex_3_3.Classes.EmbarkationPort;
import ex_3_3.Classes.Gender;
import ex_3_3.Classes.Passenger;
import ex_3_3.Classes.Ticket;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GestorTitanic {
    Set<Ticket> tickets = new HashSet<>();
    Set<Passenger> passengers = new HashSet<>();
    
    public Set<Passenger> llegeixCSV( String arxiu, String arxiuLog) throws FileNotFoundException, IOException {
        try ( Stream<String> linies = Files.lines(Paths.get(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {
            int[] numLinia = {0};  // objecte en comptes de tipus primitiu perqu? pugui variar en les cridada a 'parseMeteorit'

            return linies.map(linia -> parsePassenger(linia, ++numLinia[0], bufferedWriter))  // rep 'String' torna 'Meteorit'
                         .filter(Objects::nonNull)  // s'eliminen els errors del 'parseMeteorit()'
                         .collect(Collectors.toSet());
            
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer o creant el log: " + e.getMessage());
        }
        return null;
    }

    private Passenger parsePassenger(String linia, int numLinia, BufferedWriter bufferedWriter) {
        try {
            if (!(linia.isEmpty() || linia.startsWith("#"))) {
                // format: #PassengerID,Survived,"Name",Gender,Birthdate (DD-MM-YYYY),SibSp,Parch,"TicketID",Fare,"CabinID",ClassID,EmbarkationPort
                //         0            1        2      3      4                      5     6     7          8    9         10      11 
                // Passenger:
                String[] parts = linia.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                int     _passengerId = Integer.parseInt(parts[0].trim());
                boolean _survived    = parts[1].trim().equals("1");
                String  _name        = parts[2].replace("\"", "").trim();
                Gender  _gender      = Gender.valueOf(parts[3].toUpperCase().trim());
                //LocalDate _bithdate = (parts[4].isBlank() ? null : LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                LocalDate _bithdate = null;
                if (!parts[4].isBlank()) {
                    String[] dateParts = parts[4].split("-");
                    _bithdate = LocalDate.of(Integer.parseInt(dateParts[2]),   // YYYY
                                             Integer.parseInt(dateParts[1]),   // MM
                                             Integer.parseInt(dateParts[0]));  // DD
                }
                EmbarkationPort _embarkationPort = EmbarkationPort.valueOf(parts[11].replace("\"", "").trim());
                // Ticket:
                String _ticketId = parts[7].replace("\"", "").trim();
                double _fare     = Double.parseDouble(parts[8].trim());
                String _cabinId  = parts[9].replace("\"", "").trim();
                int    _classId  = Integer.parseInt(parts[10].trim());
                Ticket _ticket   = tickets.stream()
                                          .filter(new Ticket(_ticketId)::equals)  // 'cercaTicket'
                                          .findFirst()
                                          .orElseGet(()->new Ticket(_ticketId, _fare, _cabinId, _classId));  // millor que '.orElse(new Ticket(_ticketId, _fare, _cabinId, _classId));'

                return new Passenger( _passengerId,
                                      _survived,
                                      _name,
                                      _gender,
                                      _bithdate,
                                      _ticket,
                                      _embarkationPort );
            }
        } catch (NumberFormatException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (IllegalArgumentException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (Exception e) {
            logError(bufferedWriter, numLinia, e);

        }
        return null;
    }
    
    private Ticket cercaTicket(Ticket ticket) {
        return this.tickets.stream()
                           .filter(ticket::equals)
                           .findFirst()
                           .orElse(null);
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }
    
    private void logError(BufferedWriter bufferedWriter, int numLinia, Exception e) {
        try {
            bufferedWriter.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.err.println("Error escrivint al log: " + ex.getMessage());
        }
    }
    
}
