import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) {

        try (Stream<String> linies = Files.lines(Paths.get("c:\\temp\\clients.csv"))) {
            
            linies.filter(linia -> !linia.isBlank() && !linia.startsWith("#"))
                  .map(linia -> linia.split(","))
                  .forEach(parts -> System.out.println("ID: " + parts[0] +  " Nom: " + parts[1] +  " Email: " + parts[2]));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
