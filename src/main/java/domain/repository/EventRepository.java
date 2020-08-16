package domain.repository;

import domain.model.event.Event;
import domain.model.event.EventId;

public interface EventRepository {
    void save(Event event);
    EventId nextEventId();
}
