package ACT12_0A;

import java.io.FileReader; import java.io.FileWriter;
import java.io.IOException; import java.io.FileNotFoundException;

/**
 *
 * @author winadmin
 */


public class Main {
    public static void main(String[] args) {
        char[] c = new char[128]; 
        int cLen = c.length;
        String nomArxiu = "c:\\temp\\arxiu.txt";
        String nomArxiu2 = "c:\\temp\\arxiu2.txt";
        // Example use of InputStream methods
        try ( FileReader lector = new FileReader(nomArxiu);
              FileWriter escriptor = new FileWriter(nomArxiu2)
            ) {
            int count = 0;
            int read = 0;
            while ((read = lector.read(c)) != -1) {
                if (read < cLen) 
                    escriptor.write(c, 0, read);
                else 
                    escriptor.write(c);
                count += read;
            }
            System.out.println("Wrote: " + count + " characters.");
        } catch (FileNotFoundException f) {
            System.out.println("File " + args[0] + " not found.");
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
}
