package domain.event;

import java.time.LocalDateTime;

/**
 * Value object representing the date(s) of an event as a range between two dates.
 */
public class Date {
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Creates a new date range for an event.
     * @param start An object representing the start date of the event.
     * @param end An object representing the end date of the event.
     */
    public Date(LocalDateTime start, LocalDateTime end) {
        if(start == null) {
            throw new IllegalArgumentException("Start date cannot be null.");
        }

        if(end == null) {
            throw new IllegalArgumentException("End date cannot be null.");
        }

        this.start = start;
        this.end = end;
    }

    // Getters.
    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
