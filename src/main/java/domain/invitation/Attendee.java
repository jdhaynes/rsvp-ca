package domain.invitation;

import domain.common.DomainException;
import domain.common.EmailAddress;

/**
 * Value object representing the personal details of the recipient of an event invitation.
 */
public class Attendee {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;

    /**
     * Constructs a new instance of an attendee value object.
     * @param firstName The first name of the attendee.
     * @param lastName The last name of the attendee.
     * @param emailAddress The email address of the attendee.
     */
    public Attendee(String firstName, String lastName, EmailAddress emailAddress) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
    }

    private void setFirstName(String firstName) {
        if(firstName == null || firstName.isBlank()) {
            throw new DomainException("First name cannot be blank");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(firstName == null || firstName.isBlank()) {
            throw new DomainException("Last name cannot be blank");
        }
        this.lastName = lastName;
    }

    private void setEmailAddress(EmailAddress emailAddress) {
        if(emailAddress == null) {
            throw new DomainException("Email address must be specified");
        }
        this.emailAddress = emailAddress;
    }
}
