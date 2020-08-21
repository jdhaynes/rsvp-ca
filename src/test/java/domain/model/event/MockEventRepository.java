package domain.model.event;

import domain.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class MockEventRepository implements EventRepository {
    private Event event;
    private EventId nextEventId;

    public MockEventRepository() {
        this.event = null;
        this.nextEventId = new EventId(Integer.toString(0));
    }

    @Override
    public Event getByEventId(EventId eventId) {
        return event;
    }

    @Override
    public void save(Event event) {
        this.event = event;
    }

    @Override
    public EventId nextEventId() {
        return nextEventId;
    }
}
