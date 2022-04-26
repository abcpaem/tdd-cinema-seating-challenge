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