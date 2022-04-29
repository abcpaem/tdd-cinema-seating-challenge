package clan.techreturners.ticketing.location;

import clan.techreturners.ticketing.users.Customer;

import java.util.List;

public interface VenueBehaviour {
    List<Seat> getSeatingPlan();
    boolean hasSeatsAvailable();
    List<Seat> allocateSeats(int numberOfSeats, Customer customer);
}
