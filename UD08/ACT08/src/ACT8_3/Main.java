package ACT8_3;

// Clase principal Main

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Llibre llibre = new Llibre("Java Programming", 2020, 10.0, "John Smith");
        Revista revista = new Revista("Tech Magazine", 2021, 10.0, 25);
        
        ArrayList<PublicacioBase> libreria = new ArrayList<>();
                
        libreria.add(llibre);
        libreria.add(revista);
        
        for (Publicacio p : libreria) 
            System.out.println( p.calculaPrecio() );
        
    }
}



