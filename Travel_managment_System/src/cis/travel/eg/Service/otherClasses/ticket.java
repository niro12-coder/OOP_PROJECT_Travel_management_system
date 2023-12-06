package cis.travel.eg.Service.otherClasses;

import cis.travel.eg.Service.FlightSystem.*;
import cis.travel.eg.Service.Hotels.Reservation.hotelReservation;
import cis.travel.eg.Service.Hotels.person.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ticket {
    String CustomerLocation;
    static int Id;
    public Trips trip = new Trips();
    public double price = 0; // check voucher after confirmation of ticket
    public boolean hotelReservation;
    public hotelReservation Hotel;
    public boolean Flight;
    ArrayList <Flight> flights=new ArrayList<>();
    public int numberOfSeats;
    Scanner in = new Scanner(System.in);
    helpingMethods methods = new helpingMethods();
    int NumberOfTicket = 0;
    Vouchers voucher;
    String type;
    String confirmationNumber;
    String customerContactInfo;

    public void enterTicketDetails(manager Manager, ticket Ticket) {

        System.out.println("What type of otherClasses.ticket do you want to book?");
        System.out.println("1. Silver otherClasses.ticket /n2. Golden otherClasses.ticket/n3. Platinum otherClasses.ticket ");
        int ticketType = helpingMethods.choice(1, 3);
        System.out.println(" Ticket is for: /n 1.Single person /n 2.Couples /n 3.Family/n ");

        int seatsBooked = helpingMethods.choice(1, 3);
        if (seatsBooked == 3) {
            System.out.println("How many members are there in your family?");
            int familyMembers;
            do {
                familyMembers = in.nextInt();
                if (familyMembers < 3) {
                    switch (familyMembers) {
                        case 1:
                            System.out.println("you will be directed to the single otherClasses.ticket mode");
                            numberOfSeats = 1;
                            break;
                        case 2:
                            System.out.println("you will be directed to the Double otherClasses.ticket mode");
                            numberOfSeats = 2;
                            break;
                        default:
                            System.out.println("invalid input, please enter again");
                            break;
                    }
                } else {
                    numberOfSeats = familyMembers;
                }
            } while (familyMembers < 1);
        }
        ticketAim(Manager, Ticket);
    }

    public void ticketAim(manager Manager, ticket ticket) {
        System.out.println("Now you will be directed to book the trip you want./n");
        //book a trip function is called here
        System.out.println("What do you want to do now?");
        System.out.println("1. Book a flight.");
        System.out.println("2. Rent a car.");
        System.out.println("3. Search for hotel.");
        int assignToTicket = helpingMethods.choice(1, 3);
        switch (assignToTicket) {
            case 1: //book a flight function
                break;
            case 2: //rent car function
                break;
            case 3:
                customer.bookHotelRoom(ticket);
                break;
        }


    }

    public void bookAFlight(ArrayList<flightCompany> flightCompanies) {
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

                bookAOneWayFlight(flightCompanies,trip.Location,this.CustomerLocation,trip.start);
            } else {
                bookAOneWayFlight(flightCompanies,this.CustomerLocation,trip.Location,trip.end);

            }
        }


    }
    public void bookAOneWayFlight (ArrayList<flightCompany> flightCompanies, String To ,String From, LocalDate tripDate) {
      // to display available flights  trip location (From )match with flight arrival && customer location = ( to ) match with departure && date the same
     // trip day == flight day    &&   number of seats available

        DayOfWeek dayOfWeek = tripDate.getDayOfWeek();
        String tripDayOfWeek = dayOfWeek.toString();

      ArrayList<Flight> availableFlights=new ArrayList<>();
        for (flightCompany flightCompany : flightCompanies) {
            for (int j = 0; j < flightCompany.flights.size(); j++) {
                if (To.equals(flightCompany.flights.get(j).getArrival()) && From.equals(flightCompany.flights.get(j).getDeparture()) && tripDayOfWeek.equals(flightCompany.flights.get(j).getFlightWeekDay()) && flightCompany.flights.get(j).getAvailableSeats() >= this.numberOfSeats) {
                    availableFlights.add(flightCompany.flights.get(j));
                }

            }
        }
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
}
