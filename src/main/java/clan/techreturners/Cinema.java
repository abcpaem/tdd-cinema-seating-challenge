package clan.techreturners;

public class Cinema extends Venue {
    public Cinema(String name, String[] rows, int seatsPerRow) {
        super(name, rows.length * seatsPerRow);
    }
}
