package ACT12_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

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
            int indexInici=0, indexFinal=0;
            String tag;
            while ((linia = br.readLine()) != null) {  // tractament de cada l�nia
                while ((indexInici = linia.indexOf('<', indexInici)) != -1) {  // tractament de tots els tags de cada l�nia
                    indexFinal = linia.indexOf('>', indexInici+1);

                    if (indexFinal != -1) {
                        tag = linia.substring(indexInici, indexFinal+1);
                        
                        AnalitzaTags(tags, tag);

                        indexInici = indexFinal + 1;
                    } else {
                        break;
                    }
                }
            }
            
            comprovaTags(tags);
            
            System.out.println("HTML Ok");
            
        } catch (ErrorFormatHTML e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // Capturar y manejar la excepci�n si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
    
    private static void AnalitzaTags(Queue<String> tags, String tag) {
        int indexMajor = tag.indexOf('>');
        int indexEspai = (tag.indexOf(' ')==-1 ? indexMajor : tag.indexOf(' '));
      
        String tagtemp = tag.substring(0,Math.min(indexMajor,indexEspai));
        
        // tags no analitzables: '<!DOCTYPE>', '<input ...>'
        if (! (tagtemp.startsWith("<input") | tagtemp.startsWith("<!DOCTYPE")) )
            
            if (tagtemp.startsWith("</")) {
                tags.poll();
                // System.out.println("OUT " + tag);
            } else {
                tags.offer(tag);
                //System.out.println("IN " + tag);
            }

    }
    
    private static void comprovaTags(Queue<String> tags) throws ErrorFormatHTML {
        if (tags.size() != 0) {
            for (String s:tags) 
                System.out.println(s);

            throw new ErrorFormatHTML("HTML amb format incorrecte");
        }
    }

}