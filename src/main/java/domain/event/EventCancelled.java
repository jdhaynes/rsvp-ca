package domain.event;

import domain.common.DomainEvent;

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
