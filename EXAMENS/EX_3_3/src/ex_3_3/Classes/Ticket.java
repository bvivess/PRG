package ex_3_3.Classes;

import java.util.Objects;


public class Ticket {
    private String ticketId; // Id Ticket
    private double fare;     // Preu Ticket
    private String cabinId;  // Camarot
    private int classId;     // Classe

    public Ticket(String ticketId, double fare, String cabinId, int classId) {
        this.ticketId = ticketId;
        this.fare = fare;
        this.cabinId = cabinId;
        this.classId = classId;
    }
    
    public Ticket(String ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.ticketId);
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
        final Ticket other = (Ticket) obj;
        return Objects.equals(this.ticketId, other.ticketId);
    }
    
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getCabinId() {
        return cabinId;
    }

    public void setCabinId(String cabinId) {
        this.cabinId = cabinId;
    }

    public int getClassId() {
        return classId;
    }

    public void setpClass(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + this.ticketId + '\'' +
                ", fare=" + this.fare +
                ", cabin='" + this.cabinId + '\'' +
                ", class='" + this.classId + '\'' +
                '}';
    }
}
