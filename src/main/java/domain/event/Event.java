package domain.event;

import domain.common.DomainException;
import domain.invitation.Attendee;
import domain.invitation.Invitation;
import domain.invitation.InvitationId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Event {
    private EventId eventId;
    private String name;
    private Organiser organiser;
    private Date date;
    private String description;
    private LocalDateTime created;
    private boolean isCancelled;

    private Event() {
        // Client must construct aggregate through factory methods.
    }

    public static Event register(EventId id, String name, Organiser organiser, Date date,
                                 String description) {
        Event event = new Event();
        event.setEventId(id);
        event.setName(name);
        event.setOrganiser(organiser);
        event.setDate(date);
        event.setDescription(description);
        event.setCreated(LocalDateTime.now());
        event.setCancelled(false);

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

        setCancelled(true);
        // Todo: raise domain exception
    }

    public void reschedule(Date newDate) {
        if (!isInFuture()) {
            throw new DomainException("Cannot reschedule event in the past");
        }

        if (isCancelled) {
            throw new DomainException("Cannot reschedule a cancelled event");
        }

        setDate(newDate);
        // Todo: raise domain exception
    }

    private boolean isInFuture() {
        return this.date.compareTo(LocalDateTime.now()) > 0;
    }

    // Setters.
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

    private void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
}
