package EX_RECUPERACIO_13B;

import java.util.List;

public class Customer extends Persona {

    private List<Order> orders;

    public Customer(int customerId, String FirstName, String LastName, List<Order> orders ) {
        super(customerId, FirstName, LastName);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        String texte = this.getCustomerId() + "; " + this.getFirstName() + "; " + this.getLastName();
        for (Order o : this.orders)
                texte +=  "\n\t"+o.getOrderId() + "; " + o.getCustomerId() + "; " + o.getDate() + "; " + o.getMode() + "; " + o.getTotal();
        texte += "\n\n";
        return texte;
    }

}