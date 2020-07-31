package domain.event;

import domain.Attendee;

import java.time.LocalDateTime;
import java.util.Collection;

public class Event {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

    private Collection<Attendee> attendees;
}
