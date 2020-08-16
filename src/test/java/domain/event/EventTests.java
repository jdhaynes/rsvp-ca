package domain.event;

import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.common.EmailAddress;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class EventTests {
    @Test
    public void TestCancel() {
        EventId id = new EventId("123");
        Organiser organiser = new Organiser("Bob",
                "Doe",
                new EmailAddress("bob.doe@example.com"));
        Date date = new Date(LocalDateTime.)
        Event event = Event.register(id, "Test event", organiser, );
    }
}
