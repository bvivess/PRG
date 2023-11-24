package ACT5_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author winadmin
 */
public class ACT5_1_3 {

    public static void main(String[] args) {
        String pathArxiu = "C:/Users/winadmin/Desktop/a.html";

        try {
            if (okArxiu(pathArxiu)) {
                llegirArxiu(pathArxiu);
            } else {
                throw new IOException( "Error a l'obrir l'axiu" );
            }
        } catch (IOException e) {
            System.out.println("L'arxiu " + pathArxiu + " no existe.");
            e.getMessage();
        }
    }

    private static void llegirArxiu(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }

    private static boolean okArxiu(String pathArxiu) {
        Path path = Paths.get(pathArxiu);
        return Files.exists(path) && Files.isRegularFile(path);
    }
}

