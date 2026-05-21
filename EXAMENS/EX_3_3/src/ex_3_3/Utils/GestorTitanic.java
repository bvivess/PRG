package ex_3_3.Utils;

import ex_3_3.Classes.EmbarkationPort;
import ex_3_3.Classes.Gender;
import ex_3_3.Classes.Passenger;
import ex_3_3.Classes.Ticket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;


public class GestorTitanic {
    Set<Ticket> tickets = new HashSet<>();
    Set<Passenger> passengers = new HashSet<>();
    
    public void llegeixCSV( String arxiu, String arxiuLog) throws FileNotFoundException, IOException {
        String linea="";
        int numLinia = 0;
        Passenger _passenger;
        try ( BufferedReader br = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bw = new BufferedWriter(new FileWriter(arxiuLog)) ) { 
            while ((linea = br.readLine()) != null) {                
                _passenger = parsePassenger(linea, ++numLinia, bw);
                
                if (_passenger != null) {
                    passengers.add(_passenger);
                    tickets.add(_passenger.getTicket());
                }
            }
        } catch (IOException e) {
            System.err.println("Error carregant CSV: " + e.getMessage());
        }
    }

    private Passenger parsePassenger(String linea, int numLinia, BufferedWriter bw) throws IOException {
        try {
            if (!(linea.isEmpty() || linea.startsWith("#"))) {
                // format: #PassengerID,Survived,"Name",Gender,Birthdate (DD-MM-YYYY),SibSp,Parch,"TicketID",Fare,"CabinID",ClassID,EmbarkationPort
                //         0            1        2      3      4                      5     6     7          8    9         10      11 
                // Passenger:
                String[] parts = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");;
                int     _passengerId = Integer.parseInt(parts[0]);
                boolean _survived    = parts[1].equals("1");
                String  _name        = parts[2].replace("\"", "");
                Gender  _gender      = Gender.valueOf(parts[3].toUpperCase());
                //LocalDate _bithdate = (parts[4].isBlank() ? null : LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                LocalDate _bithdate = null;
                if (!parts[4].isBlank()) {
                    String[] dateParts = parts[4].split("-");
                    _bithdate = LocalDate.of(Integer.parseInt(dateParts[2]),   // YYYY
                                             Integer.parseInt(dateParts[1]),   // MM
                                             Integer.parseInt(dateParts[0]));  // DD
                }
                EmbarkationPort _embarkationPort = EmbarkationPort.valueOf(parts[11].replace("\"", ""));
                // Ticket:
                String _ticketId = parts[7].replace("\"", "");
                double _fare     = Double.parseDouble(parts[8]);
                String _cabinId  = parts[9].replace("\"", "");
                int    _classId  = Integer.parseInt(parts[10]);
                Ticket _ticket   = cercaTicket(new Ticket(_ticketId));
                if (_ticket == null)
                    _ticket = new Ticket(_ticketId, _fare, _cabinId, _classId);

                return new Passenger( _passengerId,
                                      _survived,
                                      _name,
                                      _gender,
                                      _bithdate,
                                      _ticket,
                                      _embarkationPort );
            }
        } catch (NumberFormatException e) {
            bw.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bw.newLine();
        } catch (IllegalArgumentException e) {
            bw.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bw.newLine();
        } catch (Exception e) {
            bw.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bw.newLine();
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
    
    
}
