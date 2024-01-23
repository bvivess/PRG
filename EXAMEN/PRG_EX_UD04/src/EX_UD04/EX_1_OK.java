package EX_UD04;



import java.util.ArrayList;

public class EX_1_OK {

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
        retrocedir(historial,-10); // retrocedir 10 posicions (o bé fins a l'inici) --> historial[0]
        avancar(historial);         // avançar 1 posició --> historial[1]
        avancar(historial,2);     // avançar 2 posicions --> historial[3]
        
        System.out.println(visitarPagina(historial));       // visitar actual --> "www.terceraPagina.com"
        System.out.println(visitarPagina(historial,100)); // visitar posició 100 (o bé fins el final) --> "www.paginaFinal.com"
        System.out.println(visitarPagina(historial));       // visitar actual--> "www.paginaFinal.com"

    }
    
    private static String visitarPagina(ArrayList<String> historial) {
        String web;
        
        // es comprova si la llista està buida
        if (!(historial.isEmpty())) 
            web = historial.get(index);
        else
            web = "";
        
        return web;
    }

    private static String visitarPagina(ArrayList<String> historial, int i) {
        String web;
        
        // es comprova si la llista està buida
        if (!(historial.isEmpty())) {
            // es comprova si l'índex està entre els límits
            index = Math.max(0,Math.min(historial.size()-1, i));
            web = historial.get(index);
        } else
            web = "";
        
        return web;
    }
    
    private static void retrocedir(ArrayList<String> historial) {
        // es comprova si la llista està buida
        if (!(historial.isEmpty()))
            retrocedir(historial,1);  // es reutilitza el mètode sobrecarregat
    }
    
    private static void retrocedir(ArrayList<String> historial, int i) {
        // es comprova si la llista està buida
        if (!(historial.isEmpty()))
            index = Math.max(0, index-i);  // es comprova si l'índex està entre els límits
    }
    
    private static void avancar(ArrayList<String> historial) {
        if (!(historial.isEmpty()))
            avancar(historial,1);  // es reutilitza el mètode sobrecarregat
    } 
    
    private static void avancar(ArrayList<String> historial, int i) {
        if (!(historial.isEmpty()))
            index = Math.min(historial.size()-1, index+i);  // es comprova si l'índex està entre els límits
    }

    private static void mostrarHistorial(ArrayList<String> historial) {
        // es comprova si la llista està buida
        if(historial.isEmpty() == true)
            for (String h : historial)
                System.out.println(h);
    }

}