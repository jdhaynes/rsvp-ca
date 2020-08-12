package domain.invitation;

import domain.common.EmailAddress;

import java.time.LocalDateTime;

/**
 * Value object representing the recipient of an event invitation.
 */
public class Attendee {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private LocalDateTime registered;

    public Attendee(String firstName, String lastName, EmailAddress emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.registered = LocalDateTime.now();
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

}
