package domain.model.common;

public class DomainException extends RuntimeException {
    private String message;

    public DomainException(String message) {
        setMessage(message);
    }

    @Override
    public String getMessage() {
        return message;
    }

    public DomainException setMessage(String message) {
        this.message = message;
        return this;
    }
}
