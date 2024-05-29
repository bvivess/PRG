package EX_UD13;

import java.util.Objects;

public class Country {
    private String countryId;
    private String countryName;
    private int regionId;

    public Country(String countryId, String countryName, int regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }
    
    public Integer getRegionId() {
        return regionId;
    }
    
    @Override
    public String toString() {
        return "Country{" + "countryId=" + countryId + ", countryName=" + countryName + ", regionId=" + regionId + '}';
    }

    
}
