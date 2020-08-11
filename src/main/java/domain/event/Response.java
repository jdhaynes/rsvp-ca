package domain.event;

import java.time.LocalDateTime;

public class Response {
    private Rsvp rsvp;
    private LocalDateTime dateResponded;
    private String message;

    public Response(Rsvp rsvp, String message) {
        setRsvp(rsvp);
        setDateResponded(LocalDateTime.now());
        setMessage(message);
    }

    // Getters.
    public Rsvp getRsvp() {
        return rsvp;
    }

    public Response setRsvp(Rsvp rsvp) {
        this.rsvp = rsvp;
        return this;
    }

    public LocalDateTime getDateResponded() {
        return dateResponded;
    }

    // Setters.
    public Response setDateResponded(LocalDateTime dateResponded) {
        this.dateResponded = dateResponded;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Response setMessage(String message) {
        this.message = message;
        return this;
    }
}
