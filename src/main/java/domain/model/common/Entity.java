package domain.model.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity<Id> {
    private Id id;
    private List<DomainEvent> domainEvents;

    public Entity() {
        this.domainEvents = new ArrayList<DomainEvent>();
    }

    public List<DomainEvent> getDomainEvents() {
        return domainEvents;
    }

    public void raiseDomainEvent(DomainEvent event) {
        this.domainEvents.add(event);
    }

    public void clearDomainEvent(DomainEvent event) {
        this.domainEvents.remove(event);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}
