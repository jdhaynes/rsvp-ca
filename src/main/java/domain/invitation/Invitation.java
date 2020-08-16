package domain.invitation;

import domain.common.DomainException;
import domain.event.EventId;

import java.time.LocalDateTime;

public class Invitation {
    private InvitationId invitationId;
    private EventId eventId;
    private Attendee attendee;
    private Response response;
    private LocalDateTime dateCreated;

    private Invitation() {
        // Client must construct aggregate through factory methods.
    }

    public static Invitation send(InvitationId invitationId, EventId eventId, Attendee attendee) {
        Invitation invitation = new Invitation();
        invitation.setInvitationId(invitationId);
        invitation.setEventId(eventId);
        invitation.setAttendee(attendee);
        invitation.setResponse(null);
        return invitation;
    }

    public void respond(Rsvp rsvp, String message) {
        if(hasResponse()) {
            throw new DomainException("Cannot respond to invitation already responded to");
        }

        this.response = new Response(rsvp, message, LocalDateTime.now());
        // Todo: raise responded domain event
    }

    private boolean hasResponse() {
        return this.response != null;
    }

    // Setters.
    private Invitation setInvitationId(InvitationId invitationId) {
        this.invitationId = invitationId;
        return this;
    }

    private Invitation setEventId(EventId eventId) {
        this.eventId = eventId;
        return this;
    }

    private Invitation setAttendee(Attendee attendee) {
        this.attendee = attendee;
        return this;
    }

    private Invitation setResponse(Response response) {
        this.response = response;
        return this;
    }

    private Invitation setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
}
