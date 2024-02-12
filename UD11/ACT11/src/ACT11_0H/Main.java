package ACT11_0H;

import java.util.EnumMap;

public class Main {
    public static void main(String[] args) {
        EnumMap<Direccio, String> mapaDirecciones = new EnumMap<>(Direccio.class);

        mapaDirecciones.put(Direccio.NORTE, "Ir hacia el norte");
        mapaDirecciones.put(Direccio.SUR, "Ir hacia el sur");
        mapaDirecciones.put(Direccio.ESTE, "Ir hacia el este");
        mapaDirecciones.put(Direccio.OESTE, "Ir hacia el oeste");

        // Iteración sobre el EnumMap
        for (Direccio direccion : mapaDirecciones.keySet()) {
            System.out.println(direccion + ": " + mapaDirecciones.get(direccion));
        }
    }
}
