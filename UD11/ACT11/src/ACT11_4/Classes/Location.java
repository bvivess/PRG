package ACT11_4.Classes;

public class Location {
    private int locationId;
    private String city;

    public Location(int locationId, String city) {
        this.locationId = locationId;
        this.city = city;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.locationId;
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
        final Location other = (Location) obj;
        return this.locationId == other.locationId;
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", city=" + city + '}';
    }
    
}
