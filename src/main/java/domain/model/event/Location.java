package domain.model.event;

import domain.model.common.DomainException;

public class Location {
    private String firstLine;           // Required.
    private String secondLine;          // Optional.
    private String city;                // Required.
    private String stateProvince;       // Required.
    private String postCode;            // Required.
    private String country;             // Required.

    public Location(String firstLine, String secondLine, String city,
                    String stateProvince, String postCode, String country) {
        setFirstLine(firstLine);
        setSecondLine(secondLine);
        setCity(city);
        setStateProvince(stateProvince);
        setPostCode(postCode);
        setCountry(country);
    }

    public void setFirstLine(String firstLine) {
        if(firstLine == null || firstLine.isBlank()) {
            throw new DomainException("First line cannot be blank");
        }
        this.firstLine = firstLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public void setCity(String city) {
        if(city == null || city.isBlank()) {
            throw new DomainException("First line cannot be blank");
        }
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        if(stateProvince == null || stateProvince.isBlank()) {
            throw new DomainException("State/province cannot be blank");
        }
        this.stateProvince = stateProvince;
    }

    public void setPostCode(String postCode) {
        if(postCode == null || postCode.isBlank()) {
            throw new DomainException("Postcode cannot be blank");
        }
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        if(country == null || country.isBlank()) {
            throw new DomainException("Country cannot be blank");
        }
        this.country = country;
    }
}
