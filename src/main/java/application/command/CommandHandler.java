package application.command;

public interface CommandHandler<Command> {
    void Handle(Command command);
}
