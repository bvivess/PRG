package ex_final.Classes;

import java.time.LocalDate;


public class Order implements Comparable<Order>{
    private int id;
    private LocalDate date;
    private double total;

    public Order(int id, LocalDate date, double total) {
        this.id = id;
        this.date = date;
        this.total = total;
    }

    public Order(int id) {
        this.id = id;
    }
    
    @Override
    public int compareTo(Order o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        return this.id == other.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", total=" + total + '}';
    }
    
    
}
