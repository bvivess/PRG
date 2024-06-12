package EX_RECUPERACIO_13B;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private int customerId;
    private LocalDate date;
    private String mode;
    private double total;

    public Order(int orderId, int customerId, LocalDate date, String mode, double total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.mode = mode;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMode() {
        return mode;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", date=" + date + ", mode=" + mode + ", total=" + total + '}';
    }
   
}
