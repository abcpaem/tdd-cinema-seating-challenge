package clan.techreturners;

public class Seat {
    private final String rowName;
    private final int seatNumber;
    private boolean isAllocated;

    public Seat(String rowName, int seatNumber) {
        this.rowName = rowName;
        this.seatNumber = seatNumber;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat o1 = (Seat) o;
        return rowName == o1.rowName && seatNumber == o1.seatNumber;
    }

    @Override
    public String toString() {
        return rowName + seatNumber;
    }
}
