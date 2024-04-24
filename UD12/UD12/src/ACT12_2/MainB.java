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
            int indexInici=0,indexFinal=0;
            while ((linia = br.readLine()) != null) {
                //System.out.println(linia);
                indexFinal=linia.length();
                indexInici = linia.indexOf('<',indexInici);
                while (indexInici!=-1) {  // si hi ha un 'tag', s'itera per cercar el 2n, 3r ...
                    indexFinal = linia.indexOf('>',indexInici+1);
                    if (indexInici != -1)  // o tamb� 'indexFinal'
                        tag = linia.substring(indexInici,indexFinal);
                    indexInici = indexFinal+1;
                    System.out.println(tag);
                    indexInici = linia.indexOf('<',indexInici);
                }
           }
            
          
            System.out.println("HTML Ok");
            
        } catch (IOException e) {
            // Capturar y manejar la excepci�n si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
}
