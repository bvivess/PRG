package prova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Prova {

    public static void main(String[] args) {
        Map<Integer,Persona> prova = new HashMap<>();
        Persona p;
        
        prova.put(3,new Persona("Element1",10));
        prova.put(2,new Persona("Element2",10));
        prova.put(1,new Persona("Element1",10));
        
        System.out.println(prova);

    }
    
}
