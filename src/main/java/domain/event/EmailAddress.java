package domain.event;

public class EmailAddress {
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }

    public String getFull() {
        return email;
    }
}
