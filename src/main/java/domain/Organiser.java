package domain;

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
}
