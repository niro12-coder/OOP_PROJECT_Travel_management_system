package cis.travel.eg.Main;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Service.CarRental.*;
import cis.travel.eg.Service.FlightSystem.*;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import cis.travel.eg.Service.Hotels.Reservation.*;
import cis.travel.eg.Trip.Trip;

public class Ticket implements Serializable {
    Scanner in = new Scanner(System.in);
    int Id ;
    int NumberOfTicket=0;
    Voucher voucher;
    String type;
    public double price;
    String confirmationNumber;
    Car car;
    boolean rentCar;
    public boolean hotelReservation;
    public hotelReservation Hotel;
    public boolean RoundFlight;
    public boolean OneWayFlight;
    ArrayList <Flight> Bookedflights=new ArrayList<>(2);
    private int numberOfSeats; //
    private String ticketType; //
    private String CustomerLocation; //
    //public String CustomerLocation;
    public String CustomerDestination;
    public static int numberOfTotalTickets;
    public Trip trip;
    public String customerContactInfo;

    public Ticket() {
        confirmationNumber= "TCK"+ numberOfTotalTickets;
        NumberOfTicket=numberOfTotalTickets;
        numberOfTotalTickets++;
    }
    public Scanner getIn() {
        return in;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getCustomerLocation() {
        return CustomerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        CustomerLocation = customerLocation;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isRentCar() {
        return rentCar;
    }

    public void setRentCar(boolean rentCar) {
        this.rentCar = rentCar;
    }

    public void ticketAim(Ticket ticket) {
        System.out.println("Now you will be directed to book the trip you want./n");
        //book a trip function is called here
        System.out.println("What do you want to do now?");
        System.out.println("1. Book a flight.");
        System.out.println("2. Rent a car.");
        System.out.println("3. Search for hotel.");
        int assignToTicket = helpingMethods.choice(1, 3);
        switch (assignToTicket) {
            case 1: //book a flight function
                bookAFlight("A","B");
                break;
            case 2: //rent car function
                break;
            case 3:

                break;
        }


    }
    // carrentall
    public void WantToRentCar(String StartDateForTrip,String EndDateForTrip, String destinationForTrip) {

        Date pickupDate=new Date();
        Date retuenDate=new Date();

        System.out.println("-----  Pickup Date -----");
        pickupDate.TakeDateFromUser();

        System.out.println("-----  Return Date -----");
        retuenDate.TakeDateFromUser();
        boolean CheckIfRentingInDurationForTrip= helpingMethods.isDateInTheTripeDuration(pickupDate.getDate(),retuenDate.getDate(),StartDateForTrip,EndDateForTrip);
        if (!CheckIfRentingInDurationForTrip){
            System.out.println("Warning: The duration you entered does not match the trip date.\n Do you want to edit dates you entered ( y / n )");
            char ans=in.next().charAt(0);
            ans= helpingMethods.InputYesOrNo(ans);
            switch (ans)
            {
                case 'y':
                case 'Y':
                    this.WantToRentCar(StartDateForTrip, EndDateForTrip,destinationForTrip);
                    break;
                case 'n':
                case 'N':
                    break;
            }

        }

        ArrayList <Car> c=new ArrayList<>();
        int NumberOfAvailableCarsForRenting = 0;

        for (Car value : Car.cars) {
            if (value.IsCarAvailableForRenting(pickupDate, retuenDate) && destinationForTrip.equals(value.getLocation())) {
                System.out.print(NumberOfAvailableCarsForRenting + 1 + " ");
                c.add(NumberOfAvailableCarsForRenting, value);
                NumberOfAvailableCarsForRenting++;
            }
            value.DisplayAvailableCarsForRenting(pickupDate, retuenDate, destinationForTrip);
        }
        if (NumberOfAvailableCarsForRenting == 0) {
            System.out.println("sorry there are not available cars in this duration");
        }
        else {
            System.out.println("pleas enter the number of car you want to rent ");
            int choice;
            choice = in.nextInt();
            choice=helpingMethods.InputValidOrNot(1, NumberOfAvailableCarsForRenting, choice);

            this.car = new Car(c.get(choice-1));
            rentCar = true;
            AddCarInTicket(pickupDate,retuenDate);
            int index=Car.cars.indexOf(this.car);
            Car.cars.get(index).AddRenting(pickupDate,retuenDate);


        }


    }
    public void AddCarInTicket(Date pickupDate,Date retuenDate) {
        this.car.AddRenting(pickupDate,retuenDate);
        System.out.println("car rented successfully");
        this.price+=this.car.rentingCars.get(0).getTotalCostForRenting();
    }
    public void cancelRentedCar() {
        rentCar=false;
        car.rentingCars.remove(0);
    }

    public void DisplayRentedCar() {
        if (rentCar) {
            System.out.println(this.car);
            System.out.println(this.car.rentingCars.get(0));
        }
        else {
            System.out.println("you haven't rented a car yet");
        }
    }


    //Flightsss
    public void bookAFlight(String CustomerLocation,String  destination) {
        System.out.println("Choose the type of Flight:");
        System.out.println("1. Round Trip");
        System.out.println("2. one-way Trip");
        int choice = helpingMethods.choice(1, 2);

        if (choice == 1) {
            // bookARoundFlight(trip.getDestination(),CustomerLocation,trip.getStartDate())
            bookARoundFlight("A","B","2023-12-01");

        } else {
            System.out.println("Choose the destination");
            System.out.println("1. going");
            System.out.println("2. coming back");
            int ans = helpingMethods.choice(1, 2);

            if (ans == 1) {
                bookAOneWayFlight(destination,CustomerLocation,"2023-12-01");

//                bookAOneWayFlight(trip.getDestination(),CustomerLocation,trip.getStartDate());
            } else {
                // bookAOneWayFlight(CustomerLocation,trip.getDestination(),trip.getEndDate());
                bookAOneWayFlight(CustomerLocation,destination,"2023-12-01");
            }
        }


    }
    public void bookARoundFlight(String to, String from, String tripDateString) {
        this.RoundFlight=true;
        System.out.println("Available flights for the outbound journey:");
        bookAOneWayFlight(to, from, tripDateString);

        System.out.println("Available flights for the return journey:");
        bookAOneWayFlight(from, to, tripDateString);
    }
    public void bookAOneWayFlight ( String To , String From, String tripDateString ) {
        // to display available flights  trip location (From )match with flight arrival && customer location = ( to ) match with departure && date the same
        // trip day == flight day    &&   number of seats available
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tripDate = LocalDate.parse(tripDateString, formatter);
        DayOfWeek TripdayOfWeek = tripDate.getDayOfWeek();


        ArrayList<Flight> availableFlights=new ArrayList<>();
        //Airport.Airports
        for (int i = 0; i< Airport.Airports.size(); i++)
        {
            for (int j = 0; j< Airport.Airports.get(i).flights.size(); j++)
            {
                if(To.equals(Airport.Airports.get(i).flights.get(j).getArrival())
                        && From.equals(Airport.Airports.get(i).flights.get(j).getDeparture())
                        && TripdayOfWeek.equals(Airport.Airports.get(i).flights.get(j).getFlightDayOfWeek())
                        && (Airport.Airports.get(i).flights.get(j).getAvailableSeats() >= this.numberOfSeats)){
                    availableFlights.add(Airport.Airports.get(i).flights.get(j));
                }

            }
        }
        if (availableFlights.isEmpty())
        {
            System.out.println("sorry there is not available flights ");
        }
        else
        {
            int numbers=availableFlights.size();
            for (int i = 0; i < numbers; i++) {
                availableFlights.get(i).setFlightPrice(this.numberOfSeats*availableFlights.get(i).getFlightPrice());
                System.out.print((i+1));
                System.out.println(availableFlights);
            }
            System.out.println("please enter the flight Number you want to book");
            int ans=helpingMethods.choice(1,numbers);
            ans --;
            DisplayAvailableSeatsInFlight(availableFlights.get(ans),Airport.Airports);
            AddFlightsToTicket(availableFlights.get(ans), Airport.Airports);
            this.OneWayFlight=true;
        }

    }
    public void AddFlightsToTicket(Flight f,ArrayList<Airport> airports) {
        this.Bookedflights.add(f);
        this.price+=f.getFlightPrice();
    }
    public void DisplayAvailableSeatsInFlight(Flight f,ArrayList<Airport> airports) {
        int IndexInArrayOfFlights=-1,IndexInArrayOfAirport=-1;
        for (int i = 0; i < airports.size(); i++) {
            IndexInArrayOfFlights = airports.get(i).flights.indexOf(f);
            if (IndexInArrayOfFlights>-1)
            {
                IndexInArrayOfAirport=i;
                break;
            }
        }

        boolean falseInput=false;
        for (int k = 0; k < this.numberOfSeats; k++) {

            do {
                System.out.println("Available seats  number ");
                for (int i = 0; i < airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).bookedSeats.size(); i++) {
                    if (airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).bookedSeats.get(i)) {
                        System.out.print((i + 1) + "   ");
                    }
                }
                System.out.print("\n Please Choose Seat Number ");
                int choice = helpingMethods.choice(1, airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).bookedSeats.size());
                choice--;
                if (airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).bookedSeats.get(choice)) {
                    f.bookedSeats.add(true);
                    airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).bookedSeats.set(choice, false);
                    falseInput = false;
                    airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).setNumberOfBookedSeat(airports.get(IndexInArrayOfAirport).flights.get(IndexInArrayOfFlights).getNumberOfBookedSeat()+1);
                } else {
                    System.out.println("\n sorry this seat is booked please enter another Number");
                    falseInput = true;
                }
            } while (falseInput);
        }
    }
    public void CancelBookingForFlight(){
        if (this.RoundFlight)
        {
            this.Bookedflights.remove(0);
            this.Bookedflights.remove(1);
        }
        else
        {
            this.Bookedflights.remove(0);
        }
    }
    public void EditBookingForFlight(){
        if (this.RoundFlight)
        {
            System.out.println("Your Flight Details ");
            System.out.println(this.Bookedflights);

        }
        else
        {
            System.out.println("Your Flight Details ");
            System.out.println(this.Bookedflights);
        }
    }
    public void ticketDetails(boolean oneticket){
        System.out.println(" Ticket ID: "+Id );
        System.out.println(" Trip Assigned: "+ trip.getTripName());
        System.out.println(" From: "+ CustomerLocation + " to "+ CustomerDestination);
        System.out.println(" Ticket type: "+ type);
        System.out.println(" Number of seats booked: "+ numberOfSeats);
        System.out.println(" - - - - - - - - - - - - - - - - - - - -");
        if(oneticket){
            System.out.println(" >> Services:");
            if(rentCar) System.out.println(" Car: "+ car.getModel());
            else System.out.println(" Car : none");

            if(hotelReservation) System.out.println(" Hotel: "+ Hotel.getHotelName());
            else System.out.println(" Hotel : none");

            if(OneWayFlight) System.out.println(" Flight: One way flight");
            else if (RoundFlight) System.out.println(" flight: Round flight");
            else System.out.println(" Flight : none");
        }
        System.out.println(" - - - - - - - - - - - - - - - - - ");
        System.out.println(" - Total payments: "+ price);

    }


//    public static void main(String[] args) {
//
//        ArrayList<Flight> f1 = new ArrayList<>();
//        ArrayList<Flight> f2 = new ArrayList<>();
//
//        f1.add(new Flight(101, "A", "B",1,12,2023, LocalTime.of(9, 30), 150, 200.0, "Economy"));
//        f1.add(new Flight(202, "C", "D",1,12,2023, LocalTime.of(12, 45), 120, 250.0, "Business"));
//        f1.add( new Flight(303, "A", "B", 1,12,2023, LocalTime.of(15, 0), 100, 300.0, "FirstClass"));
//        f2.add( new Flight(404, "C", "B", 10,10,2023, LocalTime.of(18, 15), 180, 180.0, "Economy"));
//        f2.add( new Flight(505, "A", "B", 1,12,2023,   LocalTime.of(21, 30), 200, 220.0, "Business"));
//
//        Airport a=new Airport("cairo","Egypt","0111212",f1);
//        Airport.Airports.add(a);
//        Airport b=new Airport("cairo","Egypt","0111212",f2);
//        Airport.Airports.add(b);
//        Ticket t =new Ticket();
//        t.numberOfSeats=2;
//        t.bookAOneWayFlight ( "B" , "A", "2023-12-01" );
//        t.EditBookingForFlight();
//
//    }

    // getters and setters


}

////// CUSTOMER CODE /////////////////////////////////////////////////////////////////////////
/*import cis.travel.eg.Service.Activity;
import cis.travel.eg.Trip.Trip;

import java.util.Scanner;
import java.util.ArrayList;

public class Ticket {
    public String getCustomerLocation() {
        return CustomerLocation;
    }


    public void setCustomerLocation(String customerLocation) {
        CustomerLocation = customerLocation;
    }

    private String CustomerLocation;
    public static int numberOfTotalTickets;

    public Trip trip;

    public ArrayList<Activity> activity;
    private String ticketType;
    public double price = 0; // check voucher after confirmation of ticket
    public boolean hotelReservation;
    //public hotelReservation Hotel;
    public boolean Flight;
    //ArrayList<Flight> flights = new ArrayList<>();
    private int numberOfSeats;
    Scanner in = new Scanner(System.in);
    int NumberOfTicket = 0;
    Voucher voucher;
    public String type;

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String TicketType) {
        this.ticketType = TicketType;
    }
    public String confirmationNumber;
    public String customerContactInfo;

    public Ticket() {
        confirmationNumber = "TCK" + numberOfTotalTickets;
        NumberOfTicket = numberOfTotalTickets;
        numberOfTotalTickets++;
    }

}
*/

