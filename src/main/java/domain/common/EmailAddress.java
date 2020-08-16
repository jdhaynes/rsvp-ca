package domain.common;

/**
 * Value object representing an email address.
 */
public class EmailAddress {
    private String email;

    /**
     * Constructs a new instance of an email address.
     * @param email Email address represented as a string.
     */
    public EmailAddress(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        if(email == null || email.isBlank()) {
            throw new DomainException("Email address cannot be blank");
        }
        this.email = email;
    }
}
