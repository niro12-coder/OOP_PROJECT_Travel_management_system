package cis.travel.eg.Main;
import cis.travel.eg.Service.Activity;
import cis.travel.eg.Service.helpingMethods.helpingMethods;
import cis.travel.eg.Service.CarRental.*;
import cis.travel.eg.Service.FlightSystem.*;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import cis.travel.eg.Service.Hotels.Reservation.*;
import cis.travel.eg.Trip.Family_Tour;
import cis.travel.eg.Trip.General_Tour;
import cis.travel.eg.Trip.Couple_Tour;
import cis.travel.eg.Trip.Trip;

import static cis.travel.eg.Main.Main.in;

public class Ticket implements Serializable {
    private String tourType;
    private int Id ;
    private int NumberOfTicket=0;
    private Voucher voucher;
    private String type;
    private double price;
    private String confirmationNumber;
    private Car car;
    private boolean rentCar;
    public boolean HotelReservation;

    public hotelReservation Hotel;
    private boolean RoundFlight;
    private ArrayList<Activity>activities = new ArrayList<>();
    private boolean OneWayFlightGoing;
    private boolean OneWayFlightReturn;
    public ArrayList <Flight> Bookedflights=new ArrayList<>(2);
    private int numberOfSeats;
    private String CustomerLocation;
    private String CustomerDestination;
    public static int numberOfTotalTickets;
    private Trip trip;

    private String customerContactInfo;

    public Ticket() {
        confirmationNumber= "TCK"+ numberOfTotalTickets;
        NumberOfTicket=numberOfTotalTickets;
        numberOfTotalTickets++;
    }
    public String getType() {
        return type;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
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

    public String getCustomerLocation() {
        return CustomerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        CustomerLocation = customerLocation;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isRentCar() {
        return rentCar;
    }

    public void setRentCar(boolean rentCar) {
        this.rentCar = rentCar;
    }
    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
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
            case 1:
                bookAFlight();
                break;
            case 2:
                this.WantToRentCar(trip.getStartDate(),trip.getEndDate(),CustomerDestination);//rent car function
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

        ArrayList <Car> Availablecarsforrenting=new ArrayList<>();
        int NumberOfAvailableCarsForRenting = 0;

        for (Car value : Car.in) {
            if (value.IsCarAvailableForRenting(pickupDate, retuenDate) && destinationForTrip.equals(value.getLocation())) {
                System.out.print(NumberOfAvailableCarsForRenting + 1 + " ");
                Availablecarsforrenting.add(NumberOfAvailableCarsForRenting, value);
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

            this.car = new Car(Availablecarsforrenting.get(choice-1));
            rentCar = true;
            AddCarInTicket(pickupDate,retuenDate);
            int index=Car.in.indexOf(this.car);
            Car.in.get(index).AddRenting(pickupDate,retuenDate);


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
    public void bookAFlight() {
        System.out.println("Choose the type of Flight:");
        System.out.println("1. Round Trip");
        System.out.println("2. one-way Trip");
        int choice = helpingMethods.choice(1, 2);

        if (choice == 1) {
            // bookARoundFlight(trip.getDestination(),CustomerLocation,trip.getStartDate())
            bookARoundFlight(CustomerDestination,CustomerLocation,trip.getStartDate(),trip.getEndDate());

        } else {
            System.out.println("Choose the destination");
            System.out.println("1. going");
            System.out.println("2. coming back");
            int ans = helpingMethods.choice(1, 2);

            if (ans == 1) {
                OneWayFlightGoing=bookAOneWayFlight(CustomerDestination,CustomerLocation,"2023-12-01");


//                bookAOneWayFlight(trip.getDestination(),CustomerLocation,trip.getStartDate());
            } else {
                // bookAOneWayFlight(CustomerLocation,trip.getDestination(),trip.getEndDate());
                OneWayFlightReturn= bookAOneWayFlight(CustomerLocation,CustomerDestination,"2023-12-01");

            }
        }


    }
    public void bookARoundFlight(String to, String from, String tripDateString,String tripEndDateString) {
        this.RoundFlight=true;
        System.out.println("Available flights for the outbound journey:");
        bookAOneWayFlight(to, from, tripDateString);

        System.out.println("Available flights for the return journey:");
        bookAOneWayFlight(from, to, tripEndDateString);
    }
    public boolean bookAOneWayFlight ( String To , String From, String tripDateString ) {
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
            return false;
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
            if (To.equals(CustomerDestination)&&From.equals(CustomerLocation))
            {
                OneWayFlightGoing=true;
            }
            else {
                OneWayFlightReturn=true;
            }
            AddFlightsToTicket(availableFlights.get(ans), Airport.Airports);
        }
        return true;

    }
    public void AddFlightsToTicket(Flight f,ArrayList<Airport> airports) {
        this.Bookedflights.add(f);
        if (this.RoundFlight)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(trip.getStartDate(), formatter);
            this.Bookedflights.get(0).getFlightDate().set(0,start);
            LocalDate end = LocalDate.parse(trip.getStartDate(), formatter);
            this.Bookedflights.get(0).getFlightDate().set(1,end);
        }
        else if(OneWayFlightGoing)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate start = LocalDate.parse(trip.getStartDate(), formatter);
            this.Bookedflights.get(0).getFlightDate().set(0,start);
        }
        else if(OneWayFlightReturn)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate end = LocalDate.parse(this.trip.getEndDate(), formatter);
            this.Bookedflights.get(0).getFlightDate().set(0,end);
        }
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate end = LocalDate.parse(trip.getStartDate(), formatter);
            this.Bookedflights.get(0).getFlightDate().set(0,end);
        }


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
            RoundFlight=false;

        }
        else
        {
            this.Bookedflights.remove(0);
            OneWayFlightGoing=false;


        }
    }
    public void EditBookingForFlight(){

        if (this.RoundFlight)
        {
            System.out.println("Your Flights Details ");
            System.out.println(this.Bookedflights);
            System.out.println("press 1 to cancel first flight \npress 2 to cancel second flight \npress 3 to cancel both of them\npress 4 to return");
            int choice=helpingMethods.choice(1,4);
            switch (choice)
            {
                case 1:
                    this.Bookedflights.remove(0);
                    RoundFlight=false;
                    OneWayFlightGoing=true;
                    break;
                case 2:
                    this.Bookedflights.remove(1);
                    RoundFlight=false;
                    OneWayFlightReturn=true;
                    break;
                case 3:
                    this.Bookedflights.remove(0);
                    this.Bookedflights.remove(1);
                    RoundFlight=false;
                    OneWayFlightGoing=false;
                    OneWayFlightReturn=false;
                    break;
            }

        }
        else if(OneWayFlightReturn||OneWayFlightGoing) {
            System.out.println("Your Flight Details ");
            System.out.println(this.Bookedflights);
            System.out.println("press 1 to cancel first flight \npress 2 to return back");
            int choice=helpingMethods.choice(1,2);
            if (choice==1)
            {
                this.Bookedflights.remove(0);
            }
        }
        else {
            System.out.println("sorry you havent ");
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

            if(HotelReservation) System.out.println(" Hotel: "+ Hotel.getHotelName());
            else System.out.println(" Hotel : none");

            if(RoundFlight) System.out.println(" flight: Round flight");
            else if (OneWayFlightGoing) System.out.println("Flight: One way flight");
            else System.out.println(" Flight : none");
        }
        System.out.println(" - - - - - - - - - - - - - - - - - ");
        System.out.println(" - Total payments: "+ price);

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "in=" + in +
                ", Id=" + Id +
                ", NumberOfTicket=" + NumberOfTicket +
                ", voucher=" + voucher +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", confirmationNumber='" + confirmationNumber + '\'' +
                ", car=" + car +
                ", rentCar=" + rentCar +
                ", hotelReservation=" + HotelReservation +
                ", Hotel=" + Hotel +
                ", RoundFlight=" + RoundFlight +
                ", Bookedflights=" + Bookedflights +
                ", numberOfSeats=" + numberOfSeats +
                ", CustomerLocation='" + CustomerLocation + '\'' +
                ", CustomerDestination='" + CustomerDestination + '\'' +
                ", trip=" + trip +
                ", customerContactInfo='" + customerContactInfo + '\'' +
                '}';
    }


    // public static void main(String[] args) {

//        ArrayList<Flight> f1 = new ArrayList<>();
//        ArrayList<Flight> f2 = new ArrayList<>();
//
//        f1.add(new Flight(101, "A", "B",DayOfWeek.MONDAY, LocalTime.of(9, 30), 150, 200.0, "Economy"));
//        f1.add(new Flight(202, "C", "D",DayOfWeek.MONDAY, LocalTime.of(12, 45), 120, 250.0, "Business"));
//        f1.add( new Flight(303, "A", "B",DayOfWeek.MONDAY, LocalTime.of(15, 0), 100, 300.0, "FirstClass"));
//        f2.add( new Flight(404, "C", "B", DayOfWeek.MONDAY, LocalTime.of(18, 15), 180, 180.0, "Economy"));
//        f2.add( new Flight(505, "A", "B", DayOfWeek.MONDAY,   LocalTime.of(21, 30), 200, 220.0, "Business"));
//
//        Airport a=new Airport("cairo","Egypt","0111212",f1);
//        Airport.Airports.add(a);
//        Airport b=new Airport("cairo","Egypt","0111212",f2);
//        Airport.Airports.add(b);
//        Ticket t =new Ticket();
//        t.numberOfSeats=2;
//        t.trip.setEndDate("2023*12-11");
//
//        t.trip.setEndDate("2023-12-11");
//        t.bookAOneWayFlight ( "B" , "A", t.trip.getEndDate() );
//        t.EditBookingForFlight();
//        System.out.println(t.Bookedflights.size());

    //  }

    // getters and setters


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumberOfTicket() {
        return NumberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        NumberOfTicket = numberOfTicket;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public boolean isHotelReservation() {
        return HotelReservation;
    }

    public void setHotelReservation(boolean hotelReservation) {
        this.HotelReservation = hotelReservation;
    }

    public cis.travel.eg.Service.Hotels.Reservation.hotelReservation getHotel() {
        return Hotel;
    }

    public void setHotel(cis.travel.eg.Service.Hotels.Reservation.hotelReservation hotel) {
        Hotel = hotel;
    }

    public boolean isRoundFlight() {
        return RoundFlight;
    }

    public void setRoundFlight(boolean roundFlight) {
        RoundFlight = roundFlight;
    }

    public boolean isOneWayFlightGoing() {
        return OneWayFlightGoing;
    }

    public void setOneWayFlightGoing(boolean oneWayFlightGoing) {
        OneWayFlightGoing = oneWayFlightGoing;
    }

    public boolean isOneWayFlightReturn() {
        return OneWayFlightReturn;
    }

    public void setOneWayFlightReturn(boolean oneWayFlightReturn) {
        OneWayFlightReturn = oneWayFlightReturn;
    }

    public ArrayList<Flight> getBookedflights() {
        return Bookedflights;
    }

    public void setBookedflights(ArrayList<Flight> bookedflights) {
        Bookedflights = bookedflights;
    }

    public String getCustomerDestination() {
        return CustomerDestination;
    }

    public void setCustomerDestination(String customerDestination) {
        CustomerDestination = customerDestination;
    }

    public static int getNumberOfTotalTickets() {
        return numberOfTotalTickets;
    }

    public static void setNumberOfTotalTickets(int numberOfTotalTickets) {
        Ticket.numberOfTotalTickets = numberOfTotalTickets;
    }


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(General_Tour trip) {
        this.trip = trip;
    }

    public String getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(String customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }
    public void updateTicketPrice(double update){
        this.price= price+update;
    }

    public void bookHotelRoom(Ticket ticket, boolean editHotel) {
        helpingMethods methods = new helpingMethods(); //make it static

        ArrayList<hotelReservation> availableHotels = new ArrayList<>();
        // filtering hotels for the customer
        int avaHotels = hotelReservation.hotelsFiltrationForBooking(availableHotels, ticket);
        int hotelChoice = -1;
        if (avaHotels == 0) {
            System.out.println("No available hotels right now");
            return;
        } else {
            // customer choose the suitable hotel
            hotelChoice = hotelReservation.customerChooseHotel(availableHotels, ticket);
            // customer customizes the food board according to his needs
            hotelReservation.customerChooseFoodBoard(availableHotels.get(hotelChoice - 1), ticket);
        }
        ///////////////// BOOKING CONFIRMATION ////////////////////////////
        System.out.println(" Choosing details has ended successfully");
        System.out.println(" Here is your booking details");
        availableHotels.get(hotelChoice - 1).displayHotelForBooking(-1, ticket.getNumberOfSeats() > 2, ticket.getNumberOfSeats() , true);
        System.out.println(" Do you want to confirm? (Y/N)");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            if (editHotel) {
                hotelReservation.deleteHotelReservation(ticket);
            }
            ticket.HotelReservation = true;
            ticket.Hotel = availableHotels.get(hotelChoice - 1);
            ticket.price += availableHotels.get(hotelChoice - 1).totalPayments;
            System.out.println("_______________");
            System.out.println("     PROCESS HAS BEEN MADE SUCCESSFULLY");
            System.out.println("_______________");
            hotelReservation.saveHotelReservationForAgency(ticket);
        } else {
            System.out.println("Nothing changed in the ticket, thank you!\n");
        }
    }
    public void customerEditHotelBooking(Ticket ticket) {

        System.out.println("Are you sure you want to edit hotel booking ? (y/n) \n note that: You will choose the hotel from the beginning and your current booking will be cancelled.\n");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            bookHotelRoom(ticket, true);
        } else {
            System.out.println("You will be directed to home page\n");
            //customer will be directed to the page where he chose to edit hotel
        }
    }
    public void customerCancelHotelBooking(Ticket Ticket) {
        System.out.println("Are you sure you want to cancel this hotel booking ? (y/n)\n");
        if (helpingMethods.confirm(in.next().charAt(0))) {
            hotelReservation.deleteHotelReservation(Ticket);
        } else {
            System.out.println("Nothing cancelled,thank you!\n");
        }
    }
    public static void displayTicketsForCustomer(ArrayList<Ticket> tickets){
        System.out.println(" 1. All tickets\n 2. Last ticket booked");
        switch (helpingMethods.choice(1,2)){
            case 1:
                displayAllTicketsForCustomer(tickets);
                System.out.println(" For displaying whole ticket details, you will choose the ticket you want then.");
                System.out.println(" 1. Choose ticket to display\n 2. Go to homepage");
                switch(helpingMethods.choice(1,2)){
                    case 1:
                        System.out.println(" Enter number of ticket");
                        int choice =helpingMethods.choice(1,tickets.size())-1;
                        tickets.get(choice).ticketDetails(true);
                        //display trip booked
                        //display activities if exist
                        if(tickets.get(choice).isRentCar()){}//display car details
                        if(tickets.get(choice).HotelReservation) {
                            tickets.get(choice).Hotel.displayHotelForBooking( 0 , tickets.get(choice).numberOfSeats > 2,tickets.get(choice).numberOfSeats, true);
                        }
                        if(tickets.get(choice).OneWayFlightGoing){}
                        else if (tickets.get(choice).RoundFlight) {} //display  flight
                        break;
                    case 2: // return to homepage
                        break;
                }
                break;
            case 2:
                System.out.println(" >> Your last booked ticket <<");
                System.out.println(" ");
                System.out.println(" =====================================");
                tickets.get(tickets.size()-1).ticketDetails(true);
                System.out.println(" =====================================");
                System.out.println("           >> Services <<");
                //display trip booked
                //display activities if exist
                if(tickets.get(tickets.size()-1).isRentCar()){}//display car details
                if(tickets.get(tickets.size()-1).HotelReservation) {
                    tickets.get(tickets.size()-1).Hotel.displayHotelForBooking( 0 , tickets.get(tickets.size()-1).numberOfSeats > 2,tickets.get(tickets.size()-1).numberOfSeats, true);
                }
                if(tickets.get(tickets.size()-1).OneWayFlightGoing){}
                else if (tickets.get(tickets.size()-1).RoundFlight) {} //display  flight
                break;
        }
    }
    public static void displayAllTicketsForCustomer(ArrayList<Ticket> tickets){
        int counter=0;
        System.out.println(" >> Your booked tickets <<");
        System.out.println(" ");
        System.out.println(" =====================================");
        for(Ticket ticket : tickets){
            counter++;
            System.out.println(" >> Ticket "+counter );
            System.out.println(" - - - - - - - - - - - - - - - - - - -");
            ticket.ticketDetails(false);
            System.out.println(" =====================================");
        }
    }
}

///////////////////////////////////////////////////////////////////////


////// CUSTOMER CODE /////////////////////////////////////////////////////////////////////////
/*import cis.travel.eg.Service.Activity;
import cis.travel.eg.Trip.Trip;

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