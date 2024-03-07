package ACT12_0B;

import java.io.BufferedReader; import java.io.BufferedWriter;
import java.io.FileReader; import java.io.FileWriter;
import java.io.FileNotFoundException; import java.io.IOException;

/**
 *
 * @author winadmin
 */
public class Main {
    public static void main(String[] args) {
        String nomArxiu = "c:\\temp\\arxiu.txt";
        String nomArxiu2 = "c:\\temp\\arxiu2.txt";
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu));
              BufferedWriter bufOutput = new BufferedWriter(new FileWriter(nomArxiu2))
            ) {
            String line = "";
            while ((line = bufInput.readLine()) != null) {
                bufOutput.write(line);
                bufOutput.newLine();
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
