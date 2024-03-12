package ACT11_0I;

import java.util.EnumMap;

public class Main {
    public static void main(String[] args) {
        EnumMap<Direccio, String> mapaDireccions = new EnumMap<>(Direccio.class);

        mapaDireccions.put(Direccio.NORTE, "Anar al nord");
        mapaDireccions.put(Direccio.SUR, "Anar al sud");
        mapaDireccions.put(Direccio.ESTE, "Anar a l'est");
        mapaDireccions.put(Direccio.OESTE, "Anar a l'oest");

        // Iteración sobre el EnumMap
        for (Direccio direccio : mapaDireccions.keySet()) {
            System.out.println(direccio + ": " + mapaDireccions.get(direccio));
        }
    }
}
