package domain.common;

import domain.event.Date;

public interface DomainEvent {
    int eventVersion();
    Date occuredOn();
}
