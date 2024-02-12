package ACT11_0H;

import java.util.EnumMap;

public class Main {
    public static void main(String[] args) {
        EnumMap<Direccion, String> mapaDirecciones = new EnumMap<>(Direccion.class);

        mapaDirecciones.put(Direccion.NORTE, "Ir hacia el norte");
        mapaDirecciones.put(Direccion.SUR, "Ir hacia el sur");
        mapaDirecciones.put(Direccion.ESTE, "Ir hacia el este");
        mapaDirecciones.put(Direccion.OESTE, "Ir hacia el oeste");

        // Iteración sobre el EnumMap
        for (Direccion direccion : mapaDirecciones.keySet()) {
            System.out.println(direccion + ": " + mapaDirecciones.get(direccion));
        }
    }
}
