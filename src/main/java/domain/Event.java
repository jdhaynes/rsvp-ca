package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Event {
    private String name;
    private Organiser organiser;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private LocalDateTime created;

    private Collection<Attendee> attendees;

    public Event(String name, Organiser organiser, LocalDateTime startDate, LocalDateTime endDate, String description) {
        this.name = name;
        this.organiser = organiser;
        this.startDate = startDate;
        this.endDate  = endDate;
        this.description = description;
        this.created = LocalDateTime.now();
        this.attendees = new ArrayList<>();
    }

    public void registerAttendee(Attendee attendee) {
        if(attendee == null) {
            throw new IllegalArgumentException("Attendee cannot be null.");
        }

        attendees.add(attendee);
    }
}
