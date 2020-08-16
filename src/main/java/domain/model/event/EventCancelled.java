package domain.model.event;

import domain.model.common.DomainEvent;

public class EventCancelled implements DomainEvent {

    public EventCancelled(EventId eventId) {

    }

    @Override
    public int eventVersion() {
        return 0;
    }

    @Override
    public Date occuredOn() {
        return null;
    }
}
