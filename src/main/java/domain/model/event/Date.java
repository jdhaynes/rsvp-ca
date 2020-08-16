package domain.model.event;

import domain.model.common.DomainException;

import java.time.LocalDateTime;

/**
 * Value object representing the date(s) of an event as a range between two dates with time components.
 */
public class Date implements Comparable<Date> {
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Creates a new date range for an event.
     * @param start An object representing the start date of the event.
     * @param end An object representing the end date of the event.
     */
    public Date(LocalDateTime start, LocalDateTime end) {
        if(start == null || end == null) {
            throw new DomainException("Date must have both a start and an end");
        }

        setStart(start);
        setEnd(end);
    }

    @Override
    public int compareTo(Date date) {
        return this.start.compareTo(date.start);
    }

    public int compareTo(LocalDateTime date) {
        return this.start.compareTo(date);
    }

    // Setters.
    private void setStart(LocalDateTime start) {
        // Assumes start date is set before end date through constructor, else exception.
        if(this.end.compareTo(start) >= 0) {
            throw new DomainException("Start date must be before the end date");
        }

        this.start = start;
    }

    private void setEnd(LocalDateTime end) {
        // Assumes start date is set before end date through constructor, else exception.
        if(end.compareTo(this.start) <= 0) {
            throw new DomainException("End date must be after the start date");
        }

        this.end = end;
    }
}
