package ACT09_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ACT09_5B {

    public static void main(String[] args) {
        // S'utilitza un recurs que implementa la interf�cie AutoCloseable (per exemple, BufferedReader)
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\a.html"))) {
            // Aqu� les operacions que poden llan�ar una 'excepci�'
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            // Capturar y manejar la excepci�n si ocurre
            System.err.println("Error de lectura: " + e.getMessage());
        }
        // No cal un bloc final i expl�cit, ja que el recurs es tancar� autom�ticament.
    }
}



