package EX_3_2.Utils;

import EX_3_2.Classes.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class GestorEVA {
    /**
    * @param arxiu
     * @param arxiuLog
     * @param evas
     * @param astronauts
     * @throws java.io.IOException
     */
    public int llegeixCSV( String arxiu, String arxiuLog,
                            Map<Integer, EVA> evas,
                            Set<Astronaut>    astronauts) throws IOException {
        int numLinia = 1;
        String linia = "";
        try ( BufferedReader br = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bw = new BufferedWriter(new FileWriter(arxiuLog)) ) {   
            linia = br.readLine();  // Es rebutja la primera línia
            while ((linia = br.readLine()) != null) {
                try {
                    // Format: EVAId,Country,Crew,Vehicle,Date,Duration,Purpose 
                    //         Crew: Astronaut1 Astronaut2 ...
                    //         Date ::= MM/dd/yyyy
                    //         Duration ::= HH:mm

                    numLinia++;
                    if (!(linia.isEmpty() || linia.startsWith("#"))) {
                        String[] parts = linia.split(",", 7);
                        int _evaId = Integer.parseInt(parts[0].trim());
                        String _countryId = parts[1].trim();
                        String _vehicleId = parts[3].trim();
                        String _purpose = parts[6].trim();
                        // _crew
                        String[] partsCrew = parts[2].trim().split(" ");
                        Set<Astronaut> _crew = new HashSet<>();
                        for (String c : partsCrew) {
                            if (!(c.trim().isBlank())) {
                                Astronaut astronaut = new Astronaut(c.trim());
                                astronauts.add(astronaut); 
                                _crew.add(astronaut);
                            }
                        }
                        //LocalDate _date = (parts[4] == null ? LocalDate.now() : LocalDate.parse( parts[4],DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                        String[] partsDate = parts[4].split("/"); 
                        LocalDate _date = (parts[4] == null || parts[4].isBlank())
                                            ? null
                                            : LocalDate.of(Integer.parseInt(partsDate[2]),   // YYYY
                                                           Integer.parseInt(partsDate[0]),   // MM 
                                                           Integer.parseInt(partsDate[1]));  // DD
                        //LocalTime _duration = LocalTime.parse(parts[5], DateTimeFormatter.ofPattern("H:mm"));
                        /*
                        String[] partsDuration = parts[5].split(":"); 
                        LocalTime _duration = (parts[5] == null || parts[5].isBlank())
                                              ? null
                                              :  LocalTime.of(Integer.parseInt(partsDuration[0]),   // HH
                                                              Integer.parseInt(partsDuration[1]));  // MM
                        */
                        LocalTime _duration = LocalTime.parse(parts[5].trim()); 
                        evas.put(_evaId, new EVA(_evaId, _countryId, _vehicleId, _date, _duration, _purpose, _crew));
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
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant CSV: " + e.getMessage());
        }
        return numLinia - 1;  // no cal contar la primera línia
    }

    /**
     *
     * @param gestorBBDD
     * @param evas
     * @param astronauts
     * @throws SQLException
     * @throws IOException
     */
    public void estructuresABBDD( GestorBBDD gestorBBDD, Map<Integer, EVA> evas, Set<Astronaut> astronauts) throws SQLException, IOException {
        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            conn.setAutoCommit(false);

            // Insertar ASTRONAUT 
            System.out.println("... Carregant ASTRONAUTES");
            for (Astronaut a : astronauts) {
                try {
                    gestorBBDD.executaSQL( conn, 
                                           """
                                           INSERT INTO astronauts (astronaut_id)
                                           VALUES (?)
                                           """,
                                           a.getId()
                                          );
                    conn.commit();
                } catch (SQLException e) {
                    if (!(e.getSQLState().equals("23000") && e.getErrorCode() == 1062)) {
                        System.out.println(e.getMessage());
                        throw e;
                    }
                }
            }

            // Insertar/Actualitzar EVA + CREW
            System.out.println("... Carregant EVA i CREW");
            for (EVA eva : evas.values()) {   
                try {
                    // EVAs
                    gestorBBDD.executaSQL( conn,
                                           """
                                           INSERT INTO evas (eva_id, country_id, vehicle_id, date, duration, purpose)
                                           VALUES (?, ?, ?, ?, ?, ?)
                                           """,
                                           eva.getEvaId(),
                                           eva.getCountryId(),
                                           eva.getVehicleId(),
                                           eva.getDate(),
                                           eva.getDuration(),
                                           eva.getPurpose()
                                          );
                   
                    // Crew
                    for (Astronaut a : eva.getCrew())
                        gestorBBDD.executaSQL( conn,
                                               """
                                               INSERT INTO crew (eva_id, astronaut_id)
                                               VALUES (?, ?)
                                               """,
                                               eva.getEvaId(),
                                               a.getId()
                                              );
                    conn.commit();                    
                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        gestorBBDD.executaSQL( conn,
                                               """
                                               UPDATE evas
                                               SET country_id = ?,
                                                   vehicle_id = ?,
                                                   date       = ?,
                                                   duration   = ?,
                                                   purpose    = ?
                                               WHERE eva_id = ?
                                               """,
                                               eva.getCountryId(),
                                               eva.getVehicleId(),
                                               eva.getDate(),
                                               eva.getDuration(),
                                               eva.getPurpose(),
                                               eva.getEvaId() 
                                              );
                    else {
                        System.out.println(e.getMessage());
                        throw e;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de connexió a la BD: " + e.getMessage());
        }
    }

}
