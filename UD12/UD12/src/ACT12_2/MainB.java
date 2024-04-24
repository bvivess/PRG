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
public class MainB {
    
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
                fin=linia.length();
                ini = linia.indexOf('<',ini);
                while (ini!=-1) {
                    fin = linia.indexOf('>',ini+1);
                    //System.out.println(ini + "-" + fin);
                    if (ini != -1)
                        tag = linia.substring(ini,fin);
                    ini = fin+1;
                    System.out.println(tag);
                    ini = linia.indexOf('<',ini);
                }
           }
            
          
            System.out.println("HTML Ok");
            
        } catch (IOException e) {
            // Capturar y manejar la excepción si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
}
