package ACT11_2F;

import java.time.LocalDate;

public class Meteorit implements Comparable<Meteorit> {
    private int id;
    private String name;
    private String type;
    private double mass;
    private String fall;
    private LocalDate year;
    private double latitude;
    private double longitude;

    public Meteorit(int id, String name, String type, double mass, String fall, LocalDate year, double latitude, double longitude) {
        setId(id);
        setName(name);
        setType(type);
        setMass(mass);
        setFall(fall);
        setYear(year);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " no pot ser null ni buit");
        }
    }

    private void validateNonNegative(double value, String field) {
        if (value < 0) {
            throw new IllegalArgumentException(field + " no pot ser negatiu");
        }
    }

    private void validateLatitude(double lat) {
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Latitud fora de rang");
        }
    }

    private void validateLongitude(double lon) {
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Longitud fora de rang");
        }
    }

    public void setId(int id) {
        validateNonNegative(id, "id");
        this.id = id;
    }

    public void setName(String name) {
        validateString(name, "name");
        this.name = name;
    }
    
    public void setType(String type) {
        validateString(type, "type");
        if (type.equals("Valid") || type.equals("Relict")) 
            this.type = type;
        else
            throw new IllegalArgumentException("Type fora de rang");
    }

    public void setMass(double mass) {
        validateNonNegative(mass, "mass");
        this.mass = mass;
    }
    
    public void setFall(String fall) {
        validateString(fall, "fall");
        if (fall.equals("Fell") || fall.equals("Found")) 
            this.fall = fall;
        else
            throw new IllegalArgumentException("Fall fora de rang");
    }

    public void setYear(LocalDate year) {
        if (year == null) throw new IllegalArgumentException("year no pot ser null");
        this.year = year;
    }

    public void setLatitude(double lat) {
        validateLatitude(lat);
        this.latitude = lat;
    }

    public void setLongitude(double lon) {
        validateLongitude(lon);
        this.longitude = lon;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public double getMass() { return this.mass; }
    public String getFall() { return this.fall; }
    public LocalDate getYear() { return this.year; }
    public double getLatitude() { return this.latitude; }
    public double getLongitude() { return this.longitude; }

    @Override
    public int compareTo(Meteorit o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " (" + mass + "g)";
    }
}
