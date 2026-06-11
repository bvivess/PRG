package ex_final.Classes;

import java.util.HashSet;
import java.util.Set;


public class Customer extends Person {
    private MaritalStatus maritalStatus;
    private Gender gender;
    private Set<Order> orders;

    public Customer( int id, String firstName, String lastName, String email, String phoneNumber,
                     MaritalStatus maritalStatus, Gender gender ) {
        super(id, firstName, lastName, email, phoneNumber);
        this.maritalStatus = maritalStatus;
        this.gender = gender;
        this.orders = new HashSet<>();
    }

    public Customer( int id ) {
        super(id);
    }
    
    public boolean afegeixOrder(Order o) {
        return this.orders.add(o);
    }

    public Order cercaOrder(int orderId) {
        return this.getOrders().stream()
                               .filter(new Order(orderId)::equals)
                               .findFirst()
                               .orElse(null);
    }
    
    public boolean eliminaOrder(int orderId) {
        return this.getOrders().remove(new Order(orderId));
    }
    
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return super.toString() + " Customer{" + "maritalStatus=" + maritalStatus + ", gender=" + gender + ", orders=" + orders + '}';
    }
    
}
