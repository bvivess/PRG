package ACT12_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author winadmin
 */
public class MainA {
    
    public static class ErrorFormatHTML extends Exception { 
        // Constructor
        public ErrorFormatHTML (String errorMessage) {
            super(errorMessage);
        }
    }

    public static void main(String[] args) {
        Queue<String> tags = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            String linia;
            String tag="";
            int ini=0,fin=0;
            while ((linia = br.readLine()) != null) {
                //System.out.println(linia);
                ini = linia.indexOf('<',ini);
                fin = linia.indexOf('>',ini+1);
                //System.out.println(ini + "-" + fin);
                if (ini != -1)
                    tag = linia.substring(ini,fin);

                System.out.println(tag);
           }
            
          
            System.out.println("HTML Ok");
            
        } catch (IOException e) {
            // Capturar y manejar la excepci�n si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
}