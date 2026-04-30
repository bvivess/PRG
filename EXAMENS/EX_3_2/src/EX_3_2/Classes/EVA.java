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

    private int evaId;
    private String countryId;
    private String vehicleId;
    private LocalDate date;
    private LocalTime duration;
    private String purpose;
    private Set<Astronaut> crew = new HashSet<>();

    public EVA(int eva_id, String country_id, String vehicle_id, LocalDate date, LocalTime duration, String purpose, Set<Astronaut> crew) {
        this.evaId = eva_id;
        this.countryId = country_id;
        this.vehicleId = vehicle_id;
        this.date = date;
        this.duration = duration;
        this.purpose = purpose;
        this.crew = crew;
    }
    public EVA(int evaId, String countryId, String vehicleId, LocalDate date, LocalTime duration, String purpose) {
        this.evaId     = evaId;
        this.countryId = countryId;
        this.vehicleId = vehicleId;
        this.date      = date;
        this.duration  = duration;
        this.purpose   = purpose;
    }

    public int getEvaId()              { return evaId; }
    public String getCountryId()       { return countryId; }
    public String getVehicleId()       { return vehicleId; }
    public LocalDate getDate()         { return date; }
    public LocalTime getDuration()     { return duration; }
    public String getPurpose()         { return purpose; }
    public Set<Astronaut> getCrew()    { return crew; }

    public void setEvaId(int evaId)              { this.evaId = evaId; }
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
    public int hashCode() { return Objects.hash(evaId); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof EVA)) return false;
        return this.evaId == ((EVA) obj).evaId;
    }

    @Override
    public String toString() {
        return "EVA{evaId=" + evaId
             + ", country=" + countryId
             + ", vehicle=" + vehicleId
             + ", date=" + date
             + ", duration=" + duration
             + ", crew=" + crew;
    }
}
