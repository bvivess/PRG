package ACT09_1;


public class ACT09_4E {

    public static void main(String[] args) {
        CompteBancari compte = new CompteBancari(100);

        try {
            compte.retirar(200);
        } catch (SaldoInsuficientException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Classe del compte bancari
class CompteBancari {
    private double saldo;

    public CompteBancari(double saldo) {
        this.saldo = saldo;
    }

    public void retirar(double quantitat) throws SaldoInsuficientException, ArithmeticException {
        double a = 10/quantitat;
        
        if(quantitat > this.saldo) {
            throw new SaldoInsuficientException("Saldo insuficient. Saldo actual: " + this.saldo);
        }
        saldo -= quantitat;
        System.out.println("Retirada correcta. Nou saldo: " + saldo);
    }
}

// Excepció pròpia
class SaldoInsuficientException extends Exception {
    public SaldoInsuficientException(String missatge) {
        super(missatge);
    }
}