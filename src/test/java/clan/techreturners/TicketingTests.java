package clan.techreturners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketingTests {
    private static final String VENUE_NAME = "Cinnamon";

    @Test
    void checkCinemaName() {
        // Arrange
        Venue cinema = new Cinema(VENUE_NAME);

        // Act
        String venueName = cinema.getName();

        // Assert
        assertEquals(VENUE_NAME, venueName);
    }

    @Test
    void checkCinemaCapacity() {
        // Arrange
        String[] rows = new String[3];
        int seatsPerRow = 5;
        int expectedCapacity = 15;
        Venue cinema = new Cinema(VENUE_NAME, rows, seatsPerRow);

        // Act
        int capacity = cinema.getCapacity();

        // Assert
        assertEquals(expectedCapacity, capacity);
    }
}
