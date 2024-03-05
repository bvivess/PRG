package ACT12_0A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        String nomArxiu = "c:\\temp\\arxiu.txt";
        try (BufferedReader lector = new BufferedReader(new FileReader(nomArxiu))) {
            String linnia;
            while ((linnia = lector.readLine()) != null) { // Llegir cada línia del fitxer
                System.out.println(linnia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
