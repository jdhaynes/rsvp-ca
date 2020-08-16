package domain.model.invitation;

import java.time.LocalDateTime;

public class Response {
    private Rsvp rsvp;
    private String message;
    private LocalDateTime dateResponded;

    public Response(Rsvp rsvp, String message, LocalDateTime dateResponded) {
        setRsvp(rsvp);
        setMessage(message);
        setDateResponded(dateResponded);
    }

    private void setRsvp(Rsvp rsvp) {
        this.rsvp = rsvp;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setDateResponded(LocalDateTime dateResponded) {
        this.dateResponded = dateResponded;
    }
}
