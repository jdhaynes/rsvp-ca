package application.command;

public interface CommandHandler<Command> {
    void handle(Command command);
}
