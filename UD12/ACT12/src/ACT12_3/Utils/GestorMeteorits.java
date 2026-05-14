package ACT12_3.Utils;

import ACT12_3.Classes.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class GestorMeteorits {
    public Set<Meteorit> meteorits = new HashSet<>();
    public Set<GeoPosition> geoPositions = new HashSet<>();
    public Map<Integer, List<Meteorit>> meteoritsPerAny = new HashMap<>();
    
    public Set<Meteorit> llegeixArxiuCSV(String fitxerCSV, String arxiuLog) {
        try ( Stream<String> linies = Files.lines(Paths.get(fitxerCSV));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {
            int[] numLinia = {0};  // objecte en comptes de tipus primitiu perqu? pugui variar en les cridada a 'parseMeteorit'

            return linies.map(linia -> parseMeteorit(linia, ++numLinia[0], bufferedWriter))  // rep 'String' torna 'Meteorit'
                         .filter(Objects::nonNull)  // s'eliminen els errors del 'parseMeteorit()'
                         .collect(Collectors.toSet());
            
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer o creant el log: " + e.getMessage());
        }
        return null;
    }

    private Meteorit parseMeteorit(String linia, int numLinia, BufferedWriter bufferedWriter) {
        try {
            if (!linia.startsWith("name")) {
                // format: name,id,nametype,recclass,mass (g),fall,year,reclat,reclong,GeoLocation (posicions 3 i 9 no es tenen en compte)
                String[] parts = linia.split(",",10);

                int    _id        = Integer.parseInt(parts[1].trim());
                String _nom       = parts[0].trim();
                String _type      = parts[2].trim();
                double _massa     = parts[4].isBlank() ? 0 : Double.parseDouble(parts[4].trim());
                String _fell      = parts[5].trim();
                int    _any       = parts[6].isBlank() ? 0 : Integer.parseInt(parts[6].trim());
                double _latitude  = parts[7].isBlank() ? 0 : Double.parseDouble(parts[7].trim());
                double _longitude = parts[8].isBlank() ? 0 : Double.parseDouble(parts[8].trim());
                GeoPosition _geoPosition = new GeoPosition(_latitude, _longitude);
                GeoPosition _geoPositionFinal = cercaGeoPosition(_geoPosition);
                if (_geoPositionFinal == null)
                    _geoPositionFinal = _geoPosition;

                return new Meteorit(_id, _nom, _type, _massa, _fell, _any, _geoPositionFinal);
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
    
    private GeoPosition cercaGeoPosition(GeoPosition geoPos) {  // cerca en un 'Set'
        for (GeoPosition g : this.geoPositions)
            if (geoPos.equals(g))
                return g;
        return null;
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