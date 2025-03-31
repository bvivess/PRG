package ACT11_0B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Prova {
    public static void main(String[] args) {
        File nomArxiu = new File("c:\\temp\\ACT11_1.cfg");  // o també 'String'
        Map<String,String> variables = new HashMap() {};
        
        try ( BufferedReader bufInput = new BufferedReader(new FileReader(nomArxiu))) {
            String line;
            String[] parts;
            while ((line = bufInput.readLine()) != null) {
                parts = line.split("=",2);
                System.out.println(line);
            }
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
