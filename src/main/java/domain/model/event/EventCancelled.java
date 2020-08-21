package domain.model.event;

import domain.model.common.DomainEvent;

public class EventCancelled implements DomainEvent {
    private EventId id;

    public EventCancelled(EventId eventId) {
        this.id = eventId;
    }
}
