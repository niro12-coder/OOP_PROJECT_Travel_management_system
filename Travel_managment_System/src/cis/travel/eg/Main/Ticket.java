package cis.travel.eg.Main;
import cis.travel.eg.Trip.*;
import cis.travel.eg.Service.CarRental.*;
import cis.travel.eg.Service.FlightSystem.*;
import cis.travel.eg.Service.FlightSystem.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Ticket {
    Scanner in = new Scanner(System.in);
    static int Id;
    int NumberOfTicket=0;
    public Trip trip = new Trip();
    Voucher voucher;
    String type;
    double price;
    String confirmationNumber;
    Car car;
    boolean rentCar;
    public boolean hotelReservation;
   // public hotelReservation Hotel;
    public boolean Flight;
    ArrayList <Flight> flights=new ArrayList<>();
    public int numberOfSeats;


    public Ticket() {

    }

    public void WantToRentCar(ArrayList<Car> cars) {

        Date pickupDate=new Date();
        Date retuenDate=new Date();

        System.out.println("-----  Pickup Date -----");
        pickupDate.TakeDateFromUser();

        System.out.println("-----  Return Date -----");
        retuenDate.TakeDateFromUser();
        boolean CheckIfRentingInDurationForTrip=helpingMethods.isDateInTheTripeDuration(pickupDate.getDate(),retuenDate.getDate(),this.trip.getStartDate(),this.trip.getEndDate());
        if (!CheckIfRentingInDurationForTrip){
            System.out.println("Warning: The duration you entered does not match the trip date.\n Do you want to edit dates you entered ( y / n )");
            char ans=in.next().charAt(0);
            ans= helpingMethods.InputYesOrNo(ans);
            switch (ans)
            {
                case 'y':
                case 'Y':
                    this.WantToRentCar(cars);
                    break;
                case 'n':
                case 'N':
                    break;
            }

        }

        ArrayList <Car> c=new ArrayList<>();
        int NumberOfAvailableCarsForRenting = 0;
        //1 car  ......
        //2 car  ......

        for (Car value : cars) {
            if (value.IsCarAvailableForRenting(pickupDate, retuenDate) && trip.getDestination().equals(value.getLocation())) {
                System.out.print(NumberOfAvailableCarsForRenting + 1 + " ");
                c.add(NumberOfAvailableCarsForRenting, value);
                NumberOfAvailableCarsForRenting++;
            }
            value.DisplayAvailableCarsForRenting(pickupDate, retuenDate, trip.getDestination());
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
            int index=cars.indexOf(this.car);
            cars.get(index).AddRenting(pickupDate,retuenDate);


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

//    public void enterTicketDetails(manager Manager, ticket Ticket) {
//
//        System.out.println("What type of otherClasses.ticket do you want to book?");
//        System.out.println("1. Silver otherClasses.ticket /n2. Golden otherClasses.ticket/n3. Platinum otherClasses.ticket ");
//        int ticketType = helpingMethods.choice(1, 3);
//        System.out.println(" Ticket is for: /n 1.Single person /n 2.Couples /n 3.Family/n ");
//
//        int seatsBooked = helpingMethods.choice(1, 3);
//        if (seatsBooked == 3) {
//            System.out.println("How many members are there in your family?");
//            int familyMembers;
//            do {
//                familyMembers = in.nextInt();
//                if (familyMembers < 3) {
//                    switch (familyMembers) {
//                        case 1:
//                            System.out.println("you will be directed to the single otherClasses.ticket mode");
//                            numberOfSeats = 1;
//                            break;
//                        case 2:
//                            System.out.println("you will be directed to the Double otherClasses.ticket mode");
//                            numberOfSeats = 2;
//                            break;
//                        default:
//                            System.out.println("invalid input, please enter again");
//                            break;
//                    }
//                } else {
//                    numberOfSeats = familyMembers;
//                }
//            } while (familyMembers < 1);
//        }
//        ticketAim(Manager, Ticket);
//    }
//
//    public void ticketAim(manager Manager, ticket ticket) {
//        System.out.println("Now you will be directed to book the trip you want./n");
//        //book a trip function is called here
//        System.out.println("What do you want to do now?");
//        System.out.println("1. Book a flight.");
//        System.out.println("2. Rent a car.");
//        System.out.println("3. Search for hotel.");
//        int assignToTicket = helpingMethods.choice(1, 3);
//        switch (assignToTicket) {
//            case 1: //book a flight function
//                break;
//            case 2: //rent car function
//                break;
//            case 3:
//                customer.bookHotelRoom(Manager, ticket);
//                break;
//        }
//
//
//    }

    public void bookAFlight(ArrayList<flightCompany> flightCompanies,String CustomerLocation,Trip trip) {
        System.out.println("Choose the type of Flight:");
        System.out.println("1. Round Trip");
        System.out.println("2. one-way trip Trip");
        int choice = helpingMethods.choice(1, 2);

        if (choice == 1) {

        } else {
            System.out.println("Choose the destination");
            System.out.println("1. going");
            System.out.println("2. coming back");
            int ans = helpingMethods.choice(1, 2);

            if (ans == 1) {
                bookAOneWayFlight(flightCompanies,trip.getDestination(),CustomerLocation,trip.getStartDate());
            } else {
                bookAOneWayFlight(flightCompanies,CustomerLocation,trip.getDestination(),trip.getEndDate());

            }
        }


    }
    public void bookAOneWayFlight (ArrayList<flightCompany> flightCompanies, String To ,String From, String tripDateString) {
        // to display available flights  trip location (From )match with flight arrival && customer location = ( to ) match with departure && date the same
        // trip day == flight day    &&   number of seats available
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tripDate = LocalDate.parse(tripDateString, formatter);
        DayOfWeek dayOfWeek = tripDate.getDayOfWeek();
        String tripDayOfWeek = dayOfWeek.toString();

        ArrayList<Flight> availableFlights=new ArrayList<>();
        flightCompanies.forEach(flightCompany -> IntStream.iterate(0, j -> j < flightCompany.flights.size(), j -> j + 1).filter(j -> To.equals(flightCompany.flights.get(j).getArrival()) && From.equals(flightCompany.flights.get(j).getDeparture()) && tripDayOfWeek.equals(flightCompany.flights.get(j).getFlightWeekDay()) && flightCompany.flights.get(j).getAvailableSeats() >= this.numberOfSeats).mapToObj(j -> flightCompany.flights.get(j)).forEach(availableFlights::add));
        if (availableFlights.isEmpty())
        {
            System.out.println("sorry there is not available seats in flights");
        }
        else {
            int numbers=availableFlights.size();
            for (int i = 0; i < numbers; i++) {
                availableFlights.get(i).setFlightPrice(this.numberOfSeats*availableFlights.get(i).getFlightPrice());
                System.out.print((i+1));
                System.out.println(availableFlights);
            }
            System.out.println("please enter flight Number you want to book");
            int ans=helpingMethods.choice(1,numbers);
            ans --;
            AddFlightsToTicket(availableFlights.get(ans),flightCompanies);

        }

    }
    public void AddFlightsToTicket(Flight f,ArrayList<flightCompany> flightCompanies) {

        Flight=true;
        for(int i=0;i<this.numberOfSeats;i++)
        {
            flights.add(f);
            this.price+=f.getFlightPrice();
            System.out.print("please choose seat Number ");
        }
    }
    public void DisplayAvailableSeatsInFlight(Flight f,ArrayList<flightCompany> flightCompanies) {
        int IndexInArrayOfFlights=-1,IndexInArrayOfcompany=-1;
        for (int i = 0; i < flightCompanies.size(); i++) {
            for (int j = 0; j < flightCompanies.get(i).flights.size(); j++) {
                IndexInArrayOfFlights=flightCompanies.get(i).flights.indexOf(f);
                if (IndexInArrayOfFlights>-1)
                {
                    IndexInArrayOfcompany=i;
                    break;
                }
            }

        }
        boolean falseInput=false;
        do {
            for (int i = 0; i <  flightCompanies.get(IndexInArrayOfcompany).flights.get(IndexInArrayOfFlights).bookedSeats.size(); i++) {
                if ( flightCompanies.get(IndexInArrayOfcompany).flights.get(IndexInArrayOfFlights).bookedSeats.get(i))
                {
                    System.out.println((i+1)+"   ");
                }
            }
            int choice = helpingMethods.choice(1, flightCompanies.get(IndexInArrayOfcompany).flights.get(IndexInArrayOfFlights).bookedSeats.size());
            if (flightCompanies.get(IndexInArrayOfcompany).flights.get(IndexInArrayOfFlights).bookedSeats.get(choice))
            {
                f.bookedSeats.add(true);
                flightCompanies.get(IndexInArrayOfcompany).flights.get(IndexInArrayOfFlights).bookedSeats.set(choice,false);
            }
            else
            {
                System.out.println("sorry this seat is booked please enter another Number");
                falseInput=true;
            }
        }while (falseInput);
    }

    // getters and setters
    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }


    public Scanner getIn() {
        return in;
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
}

