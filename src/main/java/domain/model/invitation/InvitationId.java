package domain.model.invitation;

public class InvitationId {
    private String id;

    public InvitationId(String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
