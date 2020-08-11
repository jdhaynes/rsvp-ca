package domain.event;

import java.time.LocalDateTime;

public class Invitation {
    private Attendee attendee;
    private Response rsvp;
    private LocalDateTime dateCreated;

    public Invitation(Attendee attendee, Response rsvp) {
        setAttendee(attendee);
        setRsvp(rsvp);
        setDateCreated(LocalDateTime.now());
    }

    // Getters.
    public Attendee getAttendee() {
        return attendee;
    }

    public Invitation setAttendee(Attendee attendee) {
        this.attendee = attendee;
        return this;
    }

    public Response getRsvp() {
        return rsvp;
    }

    // Setters.
    public Invitation setRsvp(Response rsvp) {
        this.rsvp = rsvp;
        return this;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public Invitation setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
