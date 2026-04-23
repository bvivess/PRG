package ACT12_3.Utils;

import ACT12_3.Classes.Meteorit;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;

public class Gestor {

    public Set<Meteorit> llegeixArxiu(String fitxerCSV, String arxiuLog) {
        try ( BufferedReader br = new BufferedReader(new FileReader(fitxerCSV));
              BufferedWriter bw = new BufferedWriter(new FileWriter(arxiuLog)) ) {
            AtomicInteger numLinia = new AtomicInteger(0);

            return br.lines()
                     .filter(linia -> !linia.isBlank() && !linia.startsWith("#") && !linia.startsWith("name"))
                     .map(linia -> parseMeteorit(linia, numLinia.incrementAndGet(), bw))
                     .filter(Objects::nonNull)
                     .collect(Collectors.toCollection(HashSet::new));
            
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer o creant el log: " + e.getMessage());
        }
        return new HashSet<>();
    }

    private Meteorit parseMeteorit(String linia, int numLinia, BufferedWriter bufferedWriter) {
        try {
            // Elimina el camp GeoLocation "(lat, lon)" del final, que conté comes internes
            String netejada = linia.replaceAll(",\"\\(.*?\\)\"$", "");
            String[] parts = netejada.split(",");

            int    _id        = Integer.parseInt(parts[1].trim());
            String _nom       = parts[0].trim();
            String _type      = parts[2].trim();
            double _massa     = parts[4].isEmpty() ? 0 : Double.parseDouble(parts[4].trim());
            String _fell      = parts[5].trim();
            int    _any       = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6].trim());
            LocalDate _data   = (_any == 0) ? null : LocalDate.of(_any, 1, 1);
            double _latitude  = parts[7].isEmpty() ? 0 : Double.parseDouble(parts[7].trim());
            double _longitude = parts[8].isEmpty() ? 0 : Double.parseDouble(parts[8].trim());

            return new Meteorit(_id, _nom, _type, _massa, _fell, _data, _latitude, _longitude);

        } catch (NumberFormatException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (IllegalArgumentException e) {
            logError(bufferedWriter, numLinia, e);
        } catch (Exception e) {
            logError(bufferedWriter, numLinia, e);
        }
        return null;
    }

    private void logError(BufferedWriter bw, int numLinia, Exception e) {
        try {
            bw.write("Error carregant Línia " + numLinia + ": " + e.getMessage());
            bw.newLine();
        } catch (IOException ex) {
            System.err.println("Error escrivint al log: " + ex.getMessage());
        }
    }
}