import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prova {
    public static void main(String[] args) {
        List<Map<String, String>> listaPersonas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando la coma como separador
                String[] partes = linea.split(",");

                // Crear un mapa para almacenar los atributos de la persona
                Map<String, String> personaMapa = new HashMap<>();
                personaMapa.put("nombre", partes[0]);
                personaMapa.put("edad", partes[1]);
                personaMapa.put("direccion", partes[2]);

                // Agregar el mapa de la persona a la lista
                listaPersonas.add(personaMapa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora, puedes acceder a la información de las personas en la lista
        for (Map<String, String> personaMapa : listaPersonas) {
            System.out.println("Nombre: " + personaMapa.get("nombre"));
            System.out.println("Edad: " + personaMapa.get("edad"));
            System.out.println("Dirección: " + personaMapa.get("direccion"));
            System.out.println("-------------------------");
        }
    }
}
