package clan.techreturners;

import java.util.ArrayList;
import java.util.List;

public class Cinema extends Venue {
    String[] rows;
    int seatsPerRow;
    List<Seat> seatingPlan = new ArrayList<>();

    public Cinema(String name, String[] rows, int seatsPerRow) {
        super(name, rows.length * seatsPerRow);
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        createSeatingPlan();
    }

    private void createSeatingPlan() {
        for (String row : this.rows) {
            for (int seat = 1; seat <= this.seatsPerRow; seat++) {
                seatingPlan.add(new Seat(row, seat));
            }
        }
    }

    @Override
    public List<Seat> getSeatingPlan() {
        return seatingPlan;
    }

    @Override
    public boolean hasSeatsAvailable() {
        return seatingPlan.stream().filter(seat -> !seat.isAllocated()).count() > 0;
    }
}
