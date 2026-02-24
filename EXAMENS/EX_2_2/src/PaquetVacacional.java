import java.util.ArrayList;

public class PaquetVacacional implements Comercialitzable {
    private String nom;
    private Estancia estancia;
    private ArrayList<Transport> transports;

    public PaquetVacacional(String nom, Estancia estancia) {
        this.nom = nom;
        this.estancia = estancia;
        this.transports = new ArrayList<>();
    }

    public boolean afegeixTransport(Transport t) {
        if (!this.transports.contains(t)) {
            transports.add(t);
            return true;
        }
        return false;
    }

    public boolean eliminaTransport(String nom) {
        for (int i = 0; i < this.transports.size(); i++) {
            if (this.transports.get(i).getNom().equals(nom)) {
                this.transports.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculaPreu() {
        double total = this.estancia.calculaPreu();
        for (Transport t : this.transports) {
            total += t.calculaPreu();
        }
        return total;
    }

    @Override
    public String toString() {
        String text = "Paquet: " + this.nom;
        text += "\n\t" + this.estancia.toString();
        text += "\n\tTransports del paquet:";
        for (Transport t : this.transports) {
            text += "\n\t" + t.toString();
        }
        text += "\n\tPREU PAQUET: " + this.calculaPreu();
        return text;
    }
}