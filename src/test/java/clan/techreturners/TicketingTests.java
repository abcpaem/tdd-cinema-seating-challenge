package clan.techreturners;

import clan.techreturners.ticketing.location.*;
import clan.techreturners.ticketing.users.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TicketingTests {
    private static final String VENUE_NAME = "Cinnamon";
    private Venue cinema;
    private Customer customer;

    @BeforeEach
    void Init() {
        customer = new Customer();
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

    @Test
    void checkIfCinemaHasSeatsAvailable() {
        assertEquals(true, cinema.hasSeatsAvailable());
    }

    @Test
    void checkIfCinemaWillAllocateSeatsAutomatically() {
        assertEquals(true, cinema.isAutoAllocate());
    }

    @ParameterizedTest(name = "{index}) For {0} seat(s) requested, the allocation is: {1}")
    @CsvSource(delimiterString = "->", textBlock = """
            1 -> A1
            2 -> A1,A2
            3 -> A1,A2,A3
            """)
    void checkSeatsAllocationForOneCustomer(int numberOfSeats, String expectedSeats) {
        List<Seat> seatsAllocated = cinema.allocateSeats(numberOfSeats, customer);
        String allSeats = seatsAllocated.stream().map(Objects::toString).collect(Collectors.joining(","));

        assertEquals(expectedSeats, allSeats);
    }

    @ParameterizedTest(name = "{index}) For {0} seat(s) requested, the allocation is: {1}")
    @MethodSource
    void checkMultipleSeatsAllocationsWithDifferentCustomers(int[] numberOfSeats, String[] expectedSeats) {
        // Arrange
        List<Customer> customers = new ArrayList<>();

        // Act
        for (int i = 0; i < numberOfSeats.length; i++) {
            Customer newCustomer = new Customer();
            customers.add(newCustomer);
            cinema.allocateSeats(numberOfSeats[i], newCustomer);
        }

        List<String> seatsAllocated = new ArrayList<>();
        for (Customer customer : customers)
            seatsAllocated.add(customer.getSeats().stream().map(Objects::toString).collect(Collectors.joining(",")));

        // Assert
        assertArrayEquals(expectedSeats, seatsAllocated.toArray());
    }

    public static Stream<Arguments> checkMultipleSeatsAllocationsWithDifferentCustomers() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new String[]{"A1", "A2,A3", "A4,A5,B1"}),
                Arguments.of(new int[]{2, 2, 3, 3}, new String[]{"A1,A2", "A3,A4", "A5,B1,B2", "B3,B4,B5"}),
                Arguments.of(new int[]{2, 2, 3, 3, 2, 1, 3}, new String[]{"A1,A2", "A3,A4", "A5,B1,B2", "B3,B4,B5", "C1,C2", "C3", "C4,C5"})
        );
    }
}
