package PROVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author winadmin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Persona> persones = Arrays.asList( new Persona("Juan", 30),
                                                new Persona("Jordi",31),
                                                new Persona("Joan", 26),
                                                new Persona("Pere", 24),
                                                new Persona("Maria", 18),
                                                new Persona("Joaquim", 13),
                                                new Persona("Jaume", 26),
                                                new Persona("Judith", 10) );


        Set<Persona> resultado = 
        persones.stream()
                .filter(p->p.getNom().startsWith("J"))
                .sorted(  )
                .limit(3)
                .collect(Collectors.toSet());

        List<Persona> hola = new ArrayList<>(resultado);
        
    }
}
