package domain.invitation;

import domain.common.AggregateRoot;
import domain.exception.DomainException;

import java.time.LocalDateTime;

public class Invitation {
    private Attendee attendee;
    private Response response;
    private LocalDateTime dateCreated;

    public Invitation(Attendee attendee, Response response) {
        setAttendee(attendee);
        setResponse(response);
        setDateCreated(LocalDateTime.now());
    }

    public void respond(Response response) {
        if(hasResponse()) {
            throw new DomainException("Cannot respond to invitation already responded to");
        }

        setResponse(response);

        // Todo: raise domain event.
        // Todo: Check event date is in the future.
    }


    private boolean hasResponse() {
        return this.response != null;
    }


    public Attendee getAttendee() {
        return attendee;
    }

    public Invitation setAttendee(Attendee attendee) {
        this.attendee = attendee;
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public Invitation setResponse(Response response) {
        this.response = response;
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
