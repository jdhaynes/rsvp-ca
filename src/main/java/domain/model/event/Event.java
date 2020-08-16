package domain.model.event;

import domain.model.common.DomainException;
import domain.model.invitation.Attendee;
import domain.model.invitation.Invitation;
import domain.model.invitation.InvitationId;

import java.time.LocalDateTime;

public class Event {
    private EventId eventId;
    private String name;
    private Organiser organiser;
    private Location location;
    private Date date;
    private String description;
    private LocalDateTime created;
    private boolean isCancelled;

    private Event() {
        // Client must construct aggregate through factory methods for encapsulation.
    }

    public static Event register(EventId id, String name, Organiser organiser, Date date,
                                 String description, Location location) {
        Event event = new Event();
        event.setEventId(id);
        event.setName(name);
        event.setOrganiser(organiser);
        event.setDate(date);
        event.setDescription(description);
        event.setCreated(LocalDateTime.now());
        event.setIsCancelled(false);
        event.setLocation(location);
        return event;
    }

    public Invitation sendInvitation(InvitationId invitationId, Attendee attendee) {
        if (!isInFuture()) {
            throw new DomainException("Cannot send invitation for event in the past");
        }

        if (isCancelled) {
            throw new DomainException("Cannot send invitation for a cancelled event");
        }

        return Invitation.send(invitationId, this.eventId, attendee);
    }

    public void cancel() {
        if (!isInFuture()) {
            throw new DomainException("Cannot cancel event in the past");
        }

        if (isCancelled) {
            throw new DomainException("Cannot cancel event already cancelled");
        }

        setIsCancelled(true);
    }

    public void reschedule(Date newDate, String newDescription) {
        if (!isInFuture()) {
            throw new DomainException("Cannot reschedule event in the past");
        }

        if (isCancelled) {
            throw new DomainException("Cannot reschedule a cancelled event");
        }

        setDate(newDate);
        setDescription(description);
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

    private void setEventId(EventId eventId) {
        this.eventId = eventId;
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
}
