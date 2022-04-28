package clan.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketingTests {
    private static final String VENUE_NAME = "Cinnamon";
    private Venue cinema;

    @BeforeEach
    void Init() {
        String[] rows = new String[3];
        int seatsPerRow = 5;
        cinema = new Cinema(VENUE_NAME, rows, seatsPerRow);
    }

    @Test
    void checkCinemaName() {
        assertEquals(VENUE_NAME, cinema.getName());
    }

    @Test
    void checkCinemaCapacity() {
        assertEquals(15, cinema.getCapacity());
    }
}
