package ACT8_7;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Client> clients;
    private ArrayList<Llibre> llibresDisponibles;
    private ArrayList<Llibre> llibresPrestats;

    public Biblioteca() {
        this.clients = new ArrayList<>();
        this.llibresDisponibles = new ArrayList<>();
        this.llibresPrestats = new ArrayList<>();
    }
    
    public boolean afegeixClient(Client c) {
        if (!(this.clients.contains(c)))  // if (this.cercaClient(c.getNom()) != -1)
            return this.clients.add(c);
        return false;
    }
    
    private int cercaClient(String nom) {
        return this.clients.indexOf(new Client(nom));
    }

    public boolean afegeixLlibreDisponible(Llibre llibre) {
        if (!(this.llibresDisponibles.contains(llibre)))
            return llibresDisponibles.add(llibre);
        return false;
    }
    
    private int cercaLlibreDisponible(String titol) {
        return this.llibresDisponibles.indexOf(new Llibre(titol));
    }
    
    public boolean afegeixLlibrePrestat(Llibre llibre) {
        if (!(this.llibresPrestats.contains(llibre)))
            return llibresPrestats.add(llibre);
        return false;
    }
    
    public boolean prestaLlibre(String nomClient, String titol) {
        int posClient = cercaClient(nomClient);    
        if( posClient != -1) {
            Client c = this.clients.get(posClient);
            
            int posLlibre = cercaLlibreDisponible(titol);
            if (posLlibre != -1) {
                Llibre l = this.llibresDisponibles.get(posLlibre);
                
                c.afegeixLlibrePrestat(l);
                this.afegeixLlibrePrestat(l);
                this.llibresDisponibles.remove(posLlibre);
                
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String text = "Clients de la biblioteca";
        for (Client c : this.clients)
            text += "\n\t" + c.toString();       
        
        text += "\nLlibres disponibles a la biblioteca: ";
        for (Llibre l : this.llibresDisponibles)
            text += "\n\t" + l.toString();
        
        text += "\nLlibres prestats a la biblioteca: ";
        for (Llibre l : this.llibresPrestats)
            text += "\n\t" + l.toString();
        
        return text;
    }
}