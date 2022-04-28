package clan.techreturners;

public abstract class Venue {
    private String name;

    public Venue(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
