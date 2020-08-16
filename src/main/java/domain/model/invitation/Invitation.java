package domain.model.invitation;

import domain.model.common.DomainException;
import domain.model.event.EventId;

import java.time.LocalDateTime;

public class Invitation {
    private InvitationId invitationId;
    private EventId eventId;
    private Attendee attendee;
    private Response response;
    private LocalDateTime dateCreated;

    private Invitation() {
        // Client must construct aggregate through factory methods for encapsulation.
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
    }

    private boolean hasResponse() {
        return this.response != null;
    }

    // Setters.
    private void setInvitationId(InvitationId invitationId) {
        this.invitationId = invitationId;
    }

    private void setEventId(EventId eventId) {
        this.eventId = eventId;
    }

    private void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    private void setResponse(Response response) {
        this.response = response;
    }

    private void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
