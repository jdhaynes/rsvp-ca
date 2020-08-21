package domain.repository;

import domain.model.event.Event;
import domain.model.event.EventId;

public interface EventRepository {
    Event getByEventId(EventId eventId);
    void save(Event event);
    EventId nextEventId();
}
