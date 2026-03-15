package ACT10_0Q;

public class Main {

    public static void main(String[] args) {
        // Declaració d''ArraySet'
        ArraySet<String> elements = new ArraySet<>();
       
        // Prova de 'ArraySet'
        elements.add("Element1");
        elements.add("Element2");
        elements.add("Element3");
        elements.add("Element1");  // No s'admeten 2 elements repetits
        
        for (String e : elements) {
            System.out.println(e); 
        }

    }
}

