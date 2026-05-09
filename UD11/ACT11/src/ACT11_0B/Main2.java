package ACT11_0B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException; import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        File nomArxiu = new File("c:\\temp\\arxiu.txt");  // o també 'String'
        List<Producte> productes = new ArrayList<>();
        
        try (BufferedReader lector = new BufferedReader(new FileReader(nomArxiu))) {
            String linia;
            int numLinia = 0;
            Producte producte;
            while ((linia = lector.readLine()) != null) {
                // B. C.
                producte = parseLinia(linia, ++numLinia);

                // D. Guardar els objectes en una estructura
                if (producte != null)
                    productes.add(producte);
            }
            System.out.println(productes);
        } catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    private static Producte parseLinia(String linia, int numLinia) {
        try {
            // format: XXX XXXXXXXXXXXXXXXXXXXX XXXXXX
            //         1   5                    26
            // B. Convertir cada part al tipus correcte
            int _producteId = Integer.parseInt(linia.substring(0, 3).trim());
            String _descripcio = linia.substring(4, 24).trim();
            double _preu = Double.parseDouble(linia.substring(25, linia.length()).trim());
            
            // C. Crear objecte a partir de les dades
            return new Producte(_producteId, _descripcio, _preu);
        } catch (NumberFormatException e) {
            System.err.println("Error en parseig en línia: " + numLinia);
        }
        return null;
    }
}

