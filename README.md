# TDD exercise for a cinema seating challenge.
Test Driven Development exercise for the Cinnamon Cinemas Movie Theatre Seating Challenge.

### What is the goal?

Develop a program to allocate seats to customers purchasing tickets for a movie theatre under the following criteria:
- Well-designed and tested code representing real-world scenarios
- Evidence of Test-Driven Development being applied
- Clear communication and documentation

### Business Requirements

The Cinnamon Cinemas Movie Theatre has 15 seats, arranged in 3 rows of 5
- Rows are assigned a letter from A to C
- Seats are assigned a number from 1 to 5

### User Story
*As a Cinnamon Cinemas Movie Theatre Manager*<br>
*I want to allocate seats to customers*<br>
*So that I can control reserved seating for the theatre*

**GIVEN** a customer wants to request some tickets<br>
**WHEN** they request a number of seats between 1 and 3 for a movie<br>
**THEN** the customer should be allocated the required number of seats<br>
from the available seats on the seating plan<br>
**AND** the seats should be recorded as allocated

### Acceptance Criteria and Assumptions
- Write a program that allocates seats based on a random integer “number of seats” between 1 and 3.
- Your program should allocate the required number of seats from the available seats starting from seat A1 and filling the auditorium from left to right, front to back.
- All the seats are available for sale when the program starts.
- The program should continue to allocate a random number of seats until it finds there are not enough seats left to complete the request.
- Once there are not enough seats available to be allocated then the program can halt.

## Solution

Let's start by drawing a user case diagram to have a graphical description of the user interaction with the ticketing system:

<img src="/docs/UserCaseDiagram.png" width="500">

The user will:
- Look at the seating plan.
- Request a maximum of 3 tickets.
- Wait for the system to allocate the seats.
- View the allocated tickets.

The following flow diagram will show in more detail the steps followed to allocate tickets:

<img src="/docs/FlowchartDiagram.png" width="500">

As you can see, the system will:
- Show the seating plan.
- Allocate tickets as long as they are available, otherwise it will stop the booking process.
- Show the allocated tickets.
- Wait for user to request more tickets.

### Class Diagram
The following diagram will map out the structure of the ticketing system by modeling its classes, attributes, operations and relationships between objects:

<img src="/docs/ClassDiagram.png" width="980">

These are the assumptions and considerations:
- The purpose of the ticketing system is to allocate seats requested by a customer, therefore:
    - There is a *Customer* class that contains the seats allocated for a specific customer.
    - The allocated tickets can be added, removed or fetched from the customer.
- There is one abstract class called *Venue*, which:
    - Contains the basic information for a venue, like name, capacity and seating plan.
    - Implements the *VenueBehaviour*, which contains methods to interact with the venue.
    - Can be extended by any type of venue.
    - It contains a property called *autoAllocate* that indicates the automatic allocation of seats, meaning that the customer cannot select the seats.
- The *Cinema* class is a specific type of venue, where:
    - Its seating plan is formed by rows and a number of seats in those rows. 
    - The identifiers of the rows and the number of seats will be passed at creation time.
    - It will automatically create the seating plan at construction time.
- The *Seat* class:
    - Will be used by *Cinema* and *Customer* as seat lists for the seating plan and the allocated seats respectively.
    - Contains a property called *isAllocated* that indicates if the seat has been allocated to a customer or not.
    - Contains the row name and seat number for the seat.

## Test Driven Development process

The TDD approach will start with the simplest case scenario, then it will grow in complexity until all the requirements have been satisfied:

1) Add test to check the Cinema name. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults01.html).
2) Add test to check the Cinema capacity. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults02.html).
3) Refactors TicketingTests to apply DRY principle. See all tests passing [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults03.html).
4) Add test to check the Cinema seating plan. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults04.html).
5) Add test to check if the Cinema has seats available. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults05.html).
6) Add test to check if the Cinema will allocate seats automatically. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults06.html).
7) Add test to allocate one seat for a customer. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults07.html).
8) Add test to allocate two seats for a customer. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults08.html).
9) Add test to allocate three seats for a customer. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults09.html).
10) Refactor seats allocation for one customer. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults10.html).
11) Add test to check multiple seats allocation with different customers. See test [here](https://htmlview.glitch.me/?https://github.com/abcpaem/tdd-cinema-seating-challenge/blob/main/docs/TestResults11.html).


---
### How to run the tests
1) cd to the project root folder in the command line
2) `mvn compile`
3) `mvn test`

## Technology
This project was built using:
- Java version 17.0.2
- JUnit 5.8.2 for unit testing
- Apache Maven 3.8.5 as project manager
- Community Edition for the IntelliJ 2021.3.2 development environment.