package clan.techreturners.ticketing.users;

import clan.techreturners.ticketing.location.Seat;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Seat> seats = new ArrayList<>();

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
