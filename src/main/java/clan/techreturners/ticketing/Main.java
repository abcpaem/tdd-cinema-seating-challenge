package clan.techreturners.ticketing;

import clan.techreturners.ticketing.location.*;
import clan.techreturners.ticketing.users.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        List<Seat> totalAllocatedSeats = new ArrayList<>();
        int totalSeatsRequested = 0;

        System.out.println("Welcome to Cinnamon Cinema\n");
        System.out.println("The Seating plan contains 3 rows with an assigned letter from A to C and 5 seats per row.\n");
        System.out.println("The program will start allocating seats based on a random number of seats between 1 and 3 until it reaches the cinema capacity, which is 15.\n");
        System.out.println("The seats allocated will start from row A and will finish in row C, meaning that first allocated seat will be A1 and the last will be C5.\n");

        Venue cinema = new Cinema("Cinnamon", new String[]{"A", "B", "C"}, 5);

        while (cinema.hasSeatsAvailable()) {
            Customer newCustomer = new Customer();
            int numberOfSeats = rnd.nextInt(3) + 1;

            totalAllocatedSeats.addAll(cinema.allocateSeats(numberOfSeats, newCustomer));
            String allocatedSeats = newCustomer.getSeats().stream().map(Objects::toString).collect(Collectors.joining(","));
            totalSeatsRequested += numberOfSeats;

            System.out.println(String.format("For %s seat(s) requested, the allocation is: %s", numberOfSeats, allocatedSeats));
        }

        System.out.println(String.format("\nTotal seats requested: %s", totalSeatsRequested));

        System.out.println(String.format("Total seats allocated: %s\n", totalAllocatedSeats.size()));
    }
}
