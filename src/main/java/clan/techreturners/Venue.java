package clan.techreturners;

public abstract class Venue implements VenueBehaviour {
    private final int capacity;
    private String name;
    private boolean autoAllocate;

    public Venue(String name, int capacity, boolean autoAllocate) {
        this.name = name;
        this.capacity = capacity;
        this.autoAllocate = autoAllocate;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAutoAllocate() {
        return autoAllocate;
    }
}
