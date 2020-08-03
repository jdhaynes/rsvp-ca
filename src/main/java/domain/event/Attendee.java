package domain.event;

import java.time.LocalDateTime;

/**
 * Entity representing a person attending an event.
 */
public class Attendee {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private LocalDateTime registered;
    private String requirements;

    /**
     * Registers a new attendee for an event.
     * @param firstName The first name of the attendee.
     * @param lastName The last name of the attendee.
     * @param emailAddress The email address of the attendee.
     */
    public Attendee(String firstName, String lastName, EmailAddress emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.registered = LocalDateTime.now();
    }

    /**
     * Defines optional special requirements for the attendee.
     * @param requirements A description of special requirements for the attendee.
     */
    public void defineRequirements(String requirements) {
        if(requirements == null || requirements.isBlank()) {
            throw new IllegalArgumentException("Requirements cannot be null or blank.");
        }

        this.requirements = requirements;
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

    public LocalDateTime getRegistered() {
        return registered;
    }

    public String getRequirements() {
        return requirements;
    }
}
