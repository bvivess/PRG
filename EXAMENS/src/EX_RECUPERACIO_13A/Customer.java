package EX_RECUPERACIO_13A;

import java.util.List;

public class Customer extends Persona implements Orderable {

    private List<Order> orders;

    public Customer(int customerId, String FirstName, String LastName, List<Order> orders ) {
        super(customerId, FirstName, LastName);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public double calculaOrders() {
        double total=0;
        for (Order o : this.orders)
            total +=  o.getTotal();
        return total;
    }

    @Override
    public String toString() {
        String texte = this.getCustomerId() + "; " + this.getFirstName() + "; " + this.getLastName()+"; " + this.calculaOrders();
        for (Order o : this.orders)
                texte +=  "\n\t"+o.getOrderId() + "; " + o.getCustomerId() + "; " + o.getDate() + "; " + o.getMode() + "; " + o.getTotal();
        texte += "\n\n";
        return texte;
    }

}
