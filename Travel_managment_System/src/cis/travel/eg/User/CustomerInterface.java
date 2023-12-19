package cis.travel.eg.User;

import cis.travel.eg.Service.Activity;
import cis.travel.eg.Trip.Trip;

import java.io.Serializable;
import java.util.ArrayList;

public interface CustomerInterface extends Serializable {
    int bookTicket(ArrayList<Trip> Trips_system);
    void bookTrip(ArrayList<Trip> Trips_system);
    boolean isTripFound(Trip t1, ArrayList<Trip>Trips_system);
    int editTicket( ArrayList<Trip>Trips_system);
    void editTrip(int indexOfTicket, ArrayList<Trip>Trips_system);
    void displayActivities(String tripType, String ticketType, int index);
    void displayActivities(String tripType, String ticketType, String activityType, int index);
    void delete_travel_itinerary_By_Name(int index);
    int viewTravelServices(ArrayList<Trip> Trips_system);
    int canceling();
    int viewBookedAllTicket();
    boolean maxBooking();
    boolean CheckDiscount_tickect(ArrayList<Trip> trip);
    void feedback(ArrayList<Trip> Trips_system);
    void displayRating(int avgRate);

}