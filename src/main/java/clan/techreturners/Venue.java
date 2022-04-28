package clan.techreturners;

public abstract class Venue implements VenueBehaviour {
    private final int capacity;
    private String name;

    public Venue(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
