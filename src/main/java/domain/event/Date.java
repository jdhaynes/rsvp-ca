package domain.event;

import java.time.LocalDateTime;

/**
 * Value object representing the date(s) of an event as a range between two dates.
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
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Date date) {
        return this.start.compareTo(date.start);
    }

    // Getters.
    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }


}
