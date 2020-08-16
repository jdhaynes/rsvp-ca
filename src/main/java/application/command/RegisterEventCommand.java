package application.command;

import java.time.LocalDateTime;

public class RegisterEventCommand {
    final private String eventName;
    final private String organiserFirstName;
    final private String organiserLastName;
    final private String organiserEmailAddress;
    final private LocalDateTime startDate;
    final private LocalDateTime endDate;
    final private String description;
    final private String locationFirstLine;
    final private String locationSecondLine;
    final private String locationCity;
    final private String locationStateProvince;
    final private String locationPostcode;
    final private String locationCountry;

    public RegisterEventCommand(String eventName, String organiserFirstName,
                                String organiserLastName, String organiserEmailAddress,
                                LocalDateTime startDate, LocalDateTime endDate,
                                String description, String locationFirstLine,
                                String locationSecondLine, String locationCity,
                                String locationStateProvince, String locationPostcode,
                                String locationCountry) {
        this.eventName = eventName;
        this.organiserFirstName = organiserFirstName;
        this.organiserLastName = organiserLastName;
        this.organiserEmailAddress = organiserEmailAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.locationFirstLine = locationFirstLine;
        this.locationSecondLine = locationSecondLine;
        this.locationCity = locationCity;
        this.locationStateProvince = locationStateProvince;
        this.locationPostcode = locationPostcode;
        this.locationCountry = locationCountry;
    }

    public String getEventName() {
        return eventName;
    }

    public String getOrganiserFirstName() {
        return organiserFirstName;
    }

    public String getOrganiserLastName() {
        return organiserLastName;
    }

    public String getOrganiserEmailAddress() {
        return organiserEmailAddress;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLocationFirstLine() {
        return locationFirstLine;
    }

    public String getLocationSecondLine() {
        return locationSecondLine;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationStateProvince() {
        return locationStateProvince;
    }

    public String getLocationPostcode() {
        return locationPostcode;
    }

    public String getLocationCountry() {
        return locationCountry;
    }
}
