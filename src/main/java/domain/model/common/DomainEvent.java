package domain.model.common;

import domain.model.event.Date;

public interface DomainEvent {
    int eventVersion();
    Date occuredOn();
}
