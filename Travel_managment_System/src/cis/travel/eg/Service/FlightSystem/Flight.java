package cis.travel.eg.Service.FlightSystem;

import cis.travel.eg.Service.CarRental.Car;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.User.CustomerDetails.*;
import cis.travel.eg.Main.Main;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

import static cis.travel.eg.Main.Main.in;

public class Flight implements Serializable {
    public ArrayList<Boolean> bookedSeats = new ArrayList<>();
    private int flightNumber;
    private String departure;
    private String arrival;
    private ArrayList<LocalDate> FlightDate = new ArrayList<>();
    private DayOfWeek flightDayOfWeek;
    private LocalTime flightTime;
    private int numberOfAvailableSeats = 0;
    private double flightPrice;
    private String classLevel;
    private int numberOfBookedSeat = 0;

    public Flight(int flightNumber, String departure, String arrival, DayOfWeek dayy, LocalTime flightTime, int numberAvailableSeats, double flightPrice, String classLevel) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.flightDayOfWeek = dayy;
        this.flightTime = flightTime;
        this.numberOfAvailableSeats = numberAvailableSeats;
        this.flightPrice = flightPrice;
        this.classLevel = classLevel;
        for (int i = 0; i < this.numberOfAvailableSeats; i++) {
            bookedSeats.add(true);
        }
    }

    public Flight() {

    }

    public void EditFlightDetails(ArrayList<Customer> customers) {

        LocalDate currentDate = LocalDate.now();
        boolean editAnotherThing;
        do {
            System.out.println("What do you want to edit ");
            System.out.println("\n1 flightNumber \n2 departure \n3 arrival\n4 Flight day of week\n5 flightTime\n6 numberOfAvailableSeats\n7 flightPrice");
            int choice = helpingMethods.choice(1, 7);

            switch (choice) {
                case 1:
                    System.out.print("Enter Flight Number: ");
                    this.flightNumber = in.nextInt();
                    break;
                case 2:
                    System.out.print("Enter Departure Location: ");
                    this.departure = in.next();
                    break;
                case 3:
                    System.out.print("Enter Arrival Location: ");
                    this.arrival = in.next();
                    break;
                case 4:
                    boolean invalidDay = false;
                    do {
                        try {
                            System.out.print("Enter Flight day of week :");
                            DayOfWeek flightDayOfWeek = DayOfWeek.valueOf(in.next().toUpperCase());
                            System.out.println("Selected day: " + flightDayOfWeek);
                            invalidDay = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid day of the week entered.");
                            invalidDay = true;
                        }

                    } while (invalidDay);
                case 5:
                    System.out.println("Enter Flight time ");
                    this.TackFlightTimeFromUser();
                    break;
                case 6:
                    System.out.print("Enter Number of  Seats: ");
                    this.numberOfAvailableSeats = in.nextInt();
                    break;
                case 7:
                    System.out.print("Enter Ticket Price: ");
                    this.flightPrice = in.nextDouble();
                    break;
            }

            System.out.println("do you want to edit something else");

            char continueorNot = in.next().charAt(0);
            editAnotherThing = helpingMethods.confirm(continueorNot);
            ArrayList<Integer> CustomerIndex = new ArrayList<>();
            ArrayList<Integer> TicketIndex = new ArrayList<>();

            for (int customerIndex = 0; customerIndex < customers.size(); customerIndex++) {
                Customer c = customers.get(customerIndex);

                for (int ticketIndex = 0; ticketIndex < c.getTickets().size(); ticketIndex++) {

                    for (int bookedFlightIndex = 0; bookedFlightIndex < c.getTickets().get(ticketIndex).Bookedflights.size(); bookedFlightIndex++) {

                        // hal aslan hia de wla la2
                        if (c.getTickets().get(ticketIndex).Bookedflights.get(bookedFlightIndex).getFlightNumber() == this.flightNumber) {

                            if (currentDate.isBefore(c.getTickets().get(ticketIndex).Bookedflights.get(0).getFlightDate().get(bookedFlightIndex))) {
                                CustomerIndex.add(customerIndex);
                                TicketIndex.add(ticketIndex);

                            }
                        }
                    }
                }
            }
            for (int i = 0; i < CustomerIndex.size(); i++) {
                // sent emails for customer
                customers.get(CustomerIndex.get(i)).getTickets().get(TicketIndex.get(i)).CancelBookingForFlight();
            }

        } while (editAnotherThing);

    }

    public void AddNewFlight() {
        System.out.print("Enter Flight Number: ");
        this.flightNumber = in.nextInt();

        System.out.print("Enter Departure Location: ");
        this.departure = in.next();

        System.out.print("Enter Arrival Location: ");

        this.arrival = in.next();


        boolean invalidDay = false;
        do {
            try {
                System.out.print("Enter Flight day of week :");
                DayOfWeek flightDayOfWeek = DayOfWeek.valueOf(in.next().toUpperCase());
                System.out.println("Selected day: " + flightDayOfWeek);
                invalidDay = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid day of the week entered.");
                invalidDay = true;
            }

        } while (invalidDay);

        System.out.print("Enter Number of Available Seats: ");
        this.numberOfAvailableSeats = in.nextInt();

        while (numberOfAvailableSeats <= 0) {
            System.out.println("Not an Available Number");
            numberOfAvailableSeats = in.nextInt();
        }
        for (int i = 0; i < this.numberOfAvailableSeats; i++) {
            bookedSeats.add(true);
        }

        System.out.print("Enter Ticket Price: ");
        this.flightPrice = in.nextDouble();

    }

    public void TackFlightTimeFromUser() {
        System.out.print("Enter hours (0-23): ");
        int hours = in.nextInt();
        hours = helpingMethods.InputValidOrNot(0, 24, hours);

        System.out.print("Enter minutes (0-59): ");
        int minutes = in.nextInt();
        minutes = helpingMethods.InputValidOrNot(0, 59, minutes);

        this.flightTime = LocalTime.of(hours, minutes);
    }

    public DayOfWeek getFlightDayOfWeek() {
        return flightDayOfWeek;
    }

    public void setFlightDayOfWeek(DayOfWeek flightDayOfWeek) {
        this.flightDayOfWeek = flightDayOfWeek;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public LocalTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        this.flightTime = flightTime;
    }

    public int getAvailableSeats() {
        return numberOfAvailableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.numberOfAvailableSeats = availableSeats;
    }

    public double getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(double flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public int getNumberOfBookedSeat() {
        return numberOfBookedSeat;
    }

    public void setNumberOfBookedSeat(int numberOfBookedSeat) {
        this.numberOfBookedSeat = numberOfBookedSeat;
    }

    public ArrayList<LocalDate> getFlightDate() {
        return FlightDate;
    }

    public void setFlightDate(ArrayList<LocalDate> flightDate) {
        FlightDate = flightDate;
    }
  public void DisplayFlight()
    {
        System.out.println("   ╠═══════════════════════════════════════════");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"FLIGHT NUMBER :"+Main.ANSI_COLORS[5]+this.flightNumber+"                                     ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"DEPARTURE :"+Main.ANSI_COLORS[5]+this.departure+"                                 ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"ARRIVAL :"+Main.ANSI_COLORS[5]+this.arrival+"                                 ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"FLIGHT TIME :"+Main.ANSI_COLORS[5]+this.flightTime+"                               ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"NUMBER OF AVAILABLE SEATS :"+Main.ANSI_COLORS[5]+this.numberOfAvailableSeats+"     ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"FLIGHT PRICE:"+Main.ANSI_COLORS[5]+this.flightPrice+"$"+"                   ");
        System.out.println("   ║    "+Main.ANSI_COLORS[1]+"CLASS LEVEL :"+Main.ANSI_COLORS[5]+this.classLevel+"                          ");
        System.out.println("   ║                                           ");
        System.out.println("   ╚═══════════════════════════════════════════");
    }
    @Override
    public String toString() {
        return "Flight{" +

                "\nflightNumber=" + flightNumber +
                "\n departure='" + departure + '\'' +
                "\n arrival='" + arrival + '\'' +
                "\n flightDayOfWeek=" + flightDayOfWeek +
                "\n flightTime=" + flightTime +
                "\n numberOfAvailableSeats=" + numberOfAvailableSeats +
                "\n flightPrice=" + flightPrice +
                '}';


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber);
    }
}
