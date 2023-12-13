package cis.travel.eg.Main;
import cis.travel.eg.Service.Activity;
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
