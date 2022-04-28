package clan.techreturners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketingTests {
    private static final String VENUE_NAME = "Cinnamon";
    private Venue cinema;

    @BeforeEach
    void Init() {
        String[] rows = new String[]{"A", "B", "C"};
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

    @Test
    void checkCinemaSeatingPlan() {
        // Arrange
        String expectedFirstSeat = "A1";
        String expectedLastSeat = "C5";

        // Act
        List<Seat> seatingPlan = cinema.getSeatingPlan();
        String firstSeat = seatingPlan.get(0).toString();
        String lastSeat = seatingPlan.get(seatingPlan.size() - 1).toString();

        // Assert
        assertAll(() -> assertEquals(expectedFirstSeat, firstSeat), () -> assertEquals(expectedLastSeat, lastSeat));
    }
}
