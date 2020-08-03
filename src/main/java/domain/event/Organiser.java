package domain.event;

import java.time.LocalDateTime;

public class Organiser {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private LocalDateTime datetimeRegistered;

    public Organiser(String firstName, String lastName, EmailAddress emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    // Getters.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public LocalDateTime getDatetimeRegistered() {
        return datetimeRegistered;
    }
}
