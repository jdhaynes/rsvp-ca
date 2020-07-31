package domain;

import java.time.LocalDateTime;

public class Attendee {
    private String firstName;
    private String lastName;
    private EmailAddress emailAddress;
    private LocalDateTime registered;
    private String requirements;

    public Attendee(String firstName, String lastName, EmailAddress emailAddress, LocalDateTime registered, String requirements) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.registered = registered;
        this.requirements = requirements;
    }
}
