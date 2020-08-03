package domain.event;

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

    private Collection<Attendee> attendees;

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
        this.attendees = new ArrayList<>();
    }

    /**
     * Registers a new person to attend the event.
     * @param attendee The entity representing the attendee to be registered for the event.
     */
    public void registerAttendee(Attendee attendee) {
        if(attendee == null) {
            throw new IllegalArgumentException("Attendee cannot be null.");
        }

        attendees.add(attendee);
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

    public Collection<Attendee> getAttendees() {
        return attendees;
    }
}
