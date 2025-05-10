import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"))) {

            linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .sorted((parts1, parts2) -> parts1[1].compareTo(parts2[1])) // ordenat per nom
                  .forEach(parts -> System.out.println("ID: " + parts[0] + " Nom: " + parts[1] + " Email: " + parts[2]));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

