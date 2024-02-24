package javaapplication7;

public class JavaApplication7 {
    public static void main(String[] args) {
        Telefono myTelefono = new Telefono("Xiaomi", "laPava",1000);
        myTelefono.setCapacidad(10000);
        
        System.out.println(myTelefono.getMarca());
        System.out.println(myTelefono.duracionBateria() + "h");
        
        Tablet myTablet = new Tablet("LG", "laPava", 12500);
        System.out.println(myTablet.getMarca());
        System.out.println(myTablet.getMarca());
        System.out.println(myTablet.duracionBateria() + "h");
    }
}
