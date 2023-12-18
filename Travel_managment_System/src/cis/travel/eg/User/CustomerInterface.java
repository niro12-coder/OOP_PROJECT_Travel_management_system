package cis.travel.eg.User;

import cis.travel.eg.Service.Activity;

import java.io.Serializable;
import java.util.ArrayList;

public interface CustomerInterface extends Serializable {
    void BookTicket();

    //void Edit_travel_itinerary(String tripName, int activityID, Activity editedActivity);// activities

    void delete_travel_itinerary_By_Name(String activityName, ArrayList<Activity> activities);

    void displayAllActivities();

    void displayActivitiesByTripType(String tripType);
    // void display_travel_itinerary(String tripName);
    // boolean checkDiscountTicket();
    // void rescheduleBooking();
    //cars ticket -->change trip with another trip of diff time or seats [must be the same kind]
    //test case: if there isn't such a trip then he can only cancel
    // void cancellingBooking();
    // don't be fooled by it, everything must return back to normal (deleted)
    // void FeedbackTrip_calc_localtime();
    // display option feedback
    // don't forget logout and exit


}
