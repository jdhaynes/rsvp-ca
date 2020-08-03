package domain.event;

import java.time.LocalDateTime;

/**
 * Value object representing a person registering (assumed "organising") an event.
 */
public class Organiser {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private LocalDateTime datetimeRegistered;

    /**
     *
     * @param firstName
     * @param lastName
     * @param emailAddress
     */
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
