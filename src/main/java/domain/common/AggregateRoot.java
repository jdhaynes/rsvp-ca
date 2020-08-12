package domain.common;

public abstract class AggregateRoot<Id> {
    private Id id;

    public AggregateRoot(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }
}
