package EX_UD04;



import java.util.ArrayList;

public class EX_1 {

    static ArrayList<String> historial = new ArrayList();
    static int index;

    public static void main(String[] args) {
        // Inicialització de l'historial de navegació
        historial.add("www.paginaInicial.com"); // historial[0]
        historial.add("www.primeraPagina.com"); // historial[1]
        historial.add("www.segonaPagina.com");  // historial[2]
        historial.add("www.terceraPagina.com"); // historial[3]
        historial.add("www.quartaPagina.com");  // historial[4]
        historial.add("www.paginaFinal.com");   // historial[5]
        index = historial.size() - 1;

        // Simulació 
        retrocedir(historial);      // retrocedir 1 posició --> historial[4]
        retrocedir(historial,10); // retrocedir 10 posicions (o bé fins a l'inici) --> historial[0]
        avancar(historial);         // avançar 1 posició --> historial[1]
        avancar(historial,2);     // avançar 2 posicions --> historial[3]
        
        System.out.println(visitarPagina(historial));       // visitar actual --> "www.terceraPagina.com"
        System.out.println(visitarPagina(historial,100)); // visitar posició 100 (o bé fins el final) --> "www.paginaFinal.com"
        System.out.println(visitarPagina(historial));       // visitar actual--> "www.paginaFinal.com"

    }
    
    // visitar la posició actual
    private static String visitarPagina(ArrayList<String> historial) {
        String web = historial.get(index);
        
        return web;
    }

    // visitar la posició 'i' (sempre que es pugui)
    private static String visitarPagina(ArrayList<String> historial, int i) {
        String web = "";
        
        // TO-DO code application logic here
        
        return web;
    }
    
    // retrocedir 1 posició (sempre que es pugui)
    private static void retrocedir(ArrayList<String> historial) {
        // decrementar 'index' en 1 posicio
        // TO-DO code application logic here
        
    }
    
    // retrocedir 'i' posicions (sempre que es pugui)
    private static void retrocedir(ArrayList<String> historial, int i) {
        // decrementar 'index' en 'i' posicio
        // TO-DO code application logic here
        
    }
    
    // avançar 1 posició (sempre que es pugui)
    private static void avancar(ArrayList<String> historial) {
        // incrementar 'index' en 1 posicio
        // TO-DO
        
    } 
    
    // avançar 'i' posicions (sempre que es pugui)
    private static void avancar(ArrayList<String> historial, int i) {
        // incrementar 'index' en 'i' posicio
        // TO-DO code application logic here
        
    }

    // mostrar tot l'historial
    private static void mostrarHistorial(ArrayList<String> historial) {
        // mostrar tot l'historial
        // TO-DO code application logic here
        
    }

}

