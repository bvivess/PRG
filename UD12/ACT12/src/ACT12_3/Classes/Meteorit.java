package ACT12_3.Classes;

import java.time.LocalDate;

public class Meteorit implements Comparable<Meteorit> {
    private int id;
    private String name;
    private String type;
    private double mass;
    private String fall;
    private int year;
    private GeoPosition geoPosition;

    public Meteorit(int id, String name, String type, double mass, String fall, int year, GeoPosition geoPosition) {
        setId(id);
        setName(name);
        setType(type);
        setMass(mass);
        setFall(fall);
        setYear(year);
        setGeoPosition(geoPosition);
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

    public void setYear(int year) {
        this.year = year;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public double getMass() { return this.mass; }
    public String getFall() { return this.fall; }
    public int getYear() { return this.year; }
    public GeoPosition getGeoPosition() { return this.geoPosition; }

    @Override
    public int compareTo(Meteorit o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " (" + mass + "g)";
    }
}
