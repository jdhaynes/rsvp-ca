package application.command;

import domain.model.common.EmailAddress;
import domain.model.event.*;
import domain.repository.EventRepository;

public class RegisterEventCommandHandler implements CommandHandler<RegisterEventCommand> {
    private EventRepository eventRepository;

    public RegisterEventCommandHandler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void handle(RegisterEventCommand command) {
        Organiser organiser = new Organiser(command.getOrganiserFirstName(),
                command.getOrganiserLastName(),
                new EmailAddress(command.getOrganiserEmailAddress()));

        Location location = new Location(command.getLocationFirstLine(),
                command.getLocationSecondLine(), command.getLocationCity(),
                command.getLocationStateProvince(), command.getLocationPostcode(),
                command.getLocationCountry());

        Date date = new Date(command.getStartDate(), command.getEndDate());

        EventId eventId = eventRepository.nextEventId();

        Event event = Event.register(eventId, command.getEventName(),
                organiser, date, command.getDescription(), location);

        eventRepository.save(event);
    }
}
