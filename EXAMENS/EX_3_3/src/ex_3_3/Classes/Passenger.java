package ex_3_3.Classes;

import java.time.LocalDate;

public class Passenger implements Comparable<Passenger>{
    private int passengerId;                  // Identificador
    private boolean survived;                 // Va sobreviure o no
    private String name;                      // Nom
    private Gender gender;                    // Gènere
    private LocalDate bithdate;               // Data naixement
    private Ticket ticket;                    // Número de bitllet
    private EmbarkationPort embarkationPort;  // Port d'embarcament C:Cherbourg; Q:Queenstown; S:Southampton
    
    public Passenger(int passengerId, boolean survived, String name, Gender gender, LocalDate bithdate, Ticket ticket, EmbarkationPort embarkationPort) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.name = name;
        this.gender = gender;
        this.bithdate = bithdate;
        this.ticket = ticket;
        this.embarkationPort= embarkationPort;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public boolean getSurvived() {
        return survived;
    }
    
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBithdate() {
        return bithdate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public EmbarkationPort getEmbarkationPort() {
        return embarkationPort;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setSurvived(boolean survived) {
        this.survived = survived;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(LocalDate bithdate) {
        this.bithdate = bithdate;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setEmbarkationPort(EmbarkationPort embarkationPort) {
        this.embarkationPort = embarkationPort;
    }

    @Override
    public int compareTo(Passenger o) {
        return Integer.compare(this.passengerId, o.passengerId);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + this.passengerId +
                ", survived=" + this.survived +
                ", name='" + this.name + '\'' +
                ", sex=" + this.gender +
                ", birthdate=" + this.bithdate +
                ", ticket=" + this.ticket.toString() +
                ", embarked=" + this.embarkationPort.getPortName() +
                '}';
    }
}
