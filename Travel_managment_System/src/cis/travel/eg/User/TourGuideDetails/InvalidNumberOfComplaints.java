package cis.travel.eg.User.TourGuideDetails;

import java.io.Serializable;

public class InvalidNumberOfComplaints extends Throwable implements Serializable {
    int numberOfTrips;
    public InvalidNumberOfComplaints(int numberOfTrips)
    {
        super("You can't decline all trips!");
        this.numberOfTrips=numberOfTrips;
    }

}
