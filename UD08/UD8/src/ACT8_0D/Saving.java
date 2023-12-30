package ACT8_0D;

/**
 *
 * @author winadmin
 */

public class Saving extends Account {
    private double interestRate;
    
    public Saving(double balance, double rate) { 
        super(balance);
        interestRate = rate;
    }
}
