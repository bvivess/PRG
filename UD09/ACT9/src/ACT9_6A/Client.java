package ACT9_6A;

/**
 *
 * @author winadmin
 */
public class Client {
    private String nom;
    private String cognom;
    private Telefon telefon;
    private Portatil portatil;
    private Televisor televisor;

    public Client(String nom, String cognom, Telefon telefon, Portatil portatil, Televisor televisor) {
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.portatil = portatil;
        this.televisor = televisor;
    }

    // Getters i setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public Portatil getPortatil() {
        return portatil;
    }

    public void setPortatil(Portatil portatil) {
        this.portatil = portatil;
    }

    public Televisor getTelevisor() {
        return televisor;
    }

    public void setTelevisor(Televisor televisor) {
        this.televisor = televisor;
    }

    // Mètode per calcular el descompte total
    public double calcularDescompteTotal() {
        double descompteTotal = 0.0;

        if (telefon != null) {
            descompteTotal += telefon.calculaDescompte();
        }

        if (portatil != null) {
            descompteTotal += portatil.calculaDescompte();
        }

        if (televisor != null) {
            descompteTotal += televisor.calculaDescompte();
        }

        return descompteTotal;
    }

    @Override
    public String toString() {
        return "Client {" + "Nom=" + this.nom + ", Cognom=" + this.cognom + " {" +
                "\n\t," + this.telefon.toString() + 
                "\n\t," + this.portatil.toString() +
                "\n\t," + this.televisor.toString() + "\n} Descompte Total: " + this.calcularDescompteTotal();
    }
    
    
}