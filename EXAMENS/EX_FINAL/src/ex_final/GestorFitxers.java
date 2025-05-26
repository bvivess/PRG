package ex_final;

import ex_final.GestorCentre;
import java.io.*;

public class GestorFitxers {
    public static void guardar(GestorCentre centre, String nomFitxer) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFitxer))) {
            oos.writeObject(centre);
        }
    }

    public static GestorCentre carregar(String nomFitxer) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFitxer))) {
            return (GestorCentre) ois.readObject();
        }
    }
}
