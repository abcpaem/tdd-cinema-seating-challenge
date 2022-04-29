package clan.techreturners;

import java.util.List;

public interface VenueBehaviour {
    List<Seat> getSeatingPlan();
    boolean hasSeatsAvailable();
    List<Seat> allocateSeats(int numberOfSeats, Customer customer);
}
