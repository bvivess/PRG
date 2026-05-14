package PROVA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\titanic.csv"));

        String linea;

        // Saltar cabecera
        //br.readLine();

        while ((linea = br.readLine()) != null) {

            String[] parts = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            System.out.println(linea);
            for (String campo : parts) {
                System.out.println(campo);
            }

            System.out.println("---------------");
        }

        br.close();
    }
}
