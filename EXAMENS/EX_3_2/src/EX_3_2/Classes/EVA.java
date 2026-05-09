package EX_3_2.Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa una Activitat Extra-Vehicular (EVA / spacewalk).
 */
public class EVA implements Comparable<EVA> {
    private int id;
    private String countryId;
    private String vehicleId;
    private LocalDate date;
    private LocalTime duration;
    private String purpose;
    private Set<Astronaut> crew = new HashSet<>();

    public EVA(int id, String countryId, String vehicleId, LocalDate date, LocalTime duration, String purpose, Set<Astronaut> crew) {
        this.id = id;
        this.countryId = countryId;
        this.vehicleId = vehicleId;
        this.date = date;
        this.duration = duration;
        this.purpose = purpose;
        this.crew = crew;
    }
    public EVA(int id, String countryId, String vehicleId, LocalDate date, LocalTime duration, String purpose) {
        this.id = id;
        this.countryId = countryId;
        this.vehicleId = vehicleId;
        this.date = date;
        this.duration = duration;
        this.purpose = purpose;
    }

    public int getId()                 { return id; }
    public String getCountryId()       { return countryId; }
    public String getVehicleId()       { return vehicleId; }
    public LocalDate getDate()         { return date; }
    public LocalTime getDuration()     { return duration; }
    public String getPurpose()         { return purpose; }
    public Set<Astronaut> getCrew()    { return crew; }

    public void setEvaId(int id)                 { this.id = id; }
    public void setCountryId(String countryId)   { this.countryId = countryId; }
    public void setVehicleId(String vehicleId)   { this.vehicleId = vehicleId; }
    public void setDate(LocalDate date)          { this.date = date; }
    public void setDuration(LocalTime duration)  { this.duration = duration; }
    public void setPurpose(String purpose)       { this.purpose = purpose; }

    public void addCrew(Astronaut astronaut) {
        crew.add(astronaut);
    }

    @Override
    public int compareTo(EVA o) {
        if (this.date == null && o.date == null) return 0;
        if (this.date == null) return 1;   // null va al final
        if (o.date == null)    return -1;
        return (-1) * this.date.compareTo(o.date);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EVA)) return false;
        return this.id == ((EVA) obj).id;
    }

    @Override
    public String toString() {
        return "EVA{evaId=" + id
             + ", country=" + countryId
             + ", vehicle=" + vehicleId
             + ", date=" + date
             + ", duration=" + duration
             + ", crew=" + crew;
    }
}
