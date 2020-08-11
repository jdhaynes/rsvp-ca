package domain.event;

import domain.exception.DomainException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Aggregate root representing an event.
 */
public class Event {
    private String name;
    private Organiser organiser;
    private Date date;
    private String description;
    private LocalDateTime created;

    private Collection<Invitation> invitations;

    /**
     * Creates a new event without any attendees.
     * @param name The name describing the event.
     * @param organiser The name of the person registering and organising the event.
     * @param date The date(s) of the event taking place.
     * @param description A detailed description of the event, e.g. instructions for attendees.
     */
    public Event(String name, Organiser organiser, Date date, String description) {
        this.name = name;
        this.organiser = organiser;
        this.date = date;
        this.description = description;
        this.created = LocalDateTime.now();
        this.invitations = new ArrayList<>();
    }

    public void sendInvitation(Invitation invitation) {
        if(!isInFuture()) {
            throw new DomainException("Cannot send invitation for event in the past");
        }

        invitations.add(invitation);
    }

    private boolean isInFuture() {
        return LocalDateTime.now().compareTo(date.getStart()) < 0;
    }

    // Getters.
    public String getName() {
        return name;
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Collection<Invitation> getInvitations() {
        return invitations;
    }
}
