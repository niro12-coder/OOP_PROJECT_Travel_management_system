package cis.travel.eg.Main;
import cis.travel.eg.Trip.Trip;

public class Ticket {
    String CustomerLocation;
    static int numberOfTotalTickets;
    public Trip trip = new Trip();
    public double price = 0; // check voucher after confirmation of ticket
    public boolean hotelReservation;
   // public hotelReservation Hotel;
    public boolean Flight;
    //ArrayList <Flight> flights=new ArrayList<>();
    public int numberOfSeats;
    int NumberOfTicket = 0;
   // Vouchers voucher;
    String type;
    String confirmationNumber;
    String customerContactInfo;

}