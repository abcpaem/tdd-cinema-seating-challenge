package clan.techreturners;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Seat> seats = new ArrayList<>();

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }
}
