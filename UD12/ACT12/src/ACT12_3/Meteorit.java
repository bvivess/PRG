package ACT12_3;

import java.time.LocalDate;

public class Meteorit implements Comparable<Meteorit> {
    private int id;
    private String name;
    private double mass;
    private LocalDate year;
    private double latitude;
    private double longitude;

    public Meteorit(int id, String name, double mass, LocalDate year, double latitude, double longitude) {
        setId(id);
        setName(name);
        setMass(mass);
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

    public void setMass(double mass) {
        validateNonNegative(mass, "mass");
        this.mass = mass;
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

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMass() { return mass; }
    public LocalDate getYear() { return year; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public int compareTo(Meteorit o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " (" + mass + "g)";
    }
}
