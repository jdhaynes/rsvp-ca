package domain.model.event;

import domain.model.common.DomainException;
import domain.model.common.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Event extends Entity<EventId> {
    private String name;
    private Organiser organiser;
    private Location location;
    private Date date;
    private String description;
    private LocalDateTime created;
    private boolean isCancelled;
    private List<Invitation> invitations;

    private Event() {
        // Client must construct aggregate through factory methods for encapsulation.
    }

    public static Event register(EventId id, String name, Organiser organiser, Date date,
                                 String description, Location location) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        event.setOrganiser(organiser);
        event.setDate(date);
        event.setDescription(description);
        event.setCreated(LocalDateTime.now());
        event.setIsCancelled(false);
        event.setLocation(location);
        event.setInvitations(new ArrayList<>());
        return event;
    }

    public Invitation sendInvitation(InvitationId invitationId, Attendee attendee) {
        validateInFuture();
        validateIsNotCancelled();

        return Invitation.send(invitationId, this.id, attendee);
    }

    public void cancel() {
        validateInFuture();
        validateIsNotCancelled();

        setIsCancelled(true);
    }

    public void reschedule(Date newDate, String newDescription) {
        validateInFuture();
        validateIsNotCancelled();

        setDate(newDate);
        setDescription(description);
    }

    public void respondToInvitation(InvitationId invitationId, Rsvp rsvp, String message) {
        validateInFuture();
        validateIsNotCancelled();

        Stream<Invitation> invitationSearch = invitations
                .stream()
                .filter(x -> x.getId() == invitationId);

        if(invitationSearch.findFirst().isPresent()) {
            Invitation invitation = invitationSearch.findFirst().get();
            invitation.respond(rsvp, message);
        } else {
            throw new DomainException("Invitation not associated with event");
        }
    }

    private void validateInFuture() {
        if (!isInFuture()) {
            throw new DomainException("Event is in the past");
        }
    }

    private void validateIsNotCancelled() {
        if (isCancelled) {
            throw new DomainException("Event is cancelled");
        }
    }

    private boolean isInFuture() {
        return this.date.compareTo(LocalDateTime.now()) > 0;
    }

    private void setDate(Date date) {
        if (this.date.compareTo(LocalDateTime.now()) < 0) {
            throw new DomainException("Cannot register an event starting in the past");
        }

        this.date = date;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(LocalDateTime created) {
        this.created = created;
    }

    private void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setInvitations(List<Invitation> invitations) {
        this.invitations = invitations;
    }
}
