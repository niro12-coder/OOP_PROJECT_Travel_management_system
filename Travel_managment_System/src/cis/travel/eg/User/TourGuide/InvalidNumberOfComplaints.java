package cis.travel.eg.User.TourGuide;

public class InvalidNumberOfComplaints extends Throwable{
    int numberOfTrips;
    public InvalidNumberOfComplaints(int numberOfTrips)
    {
        super("You can't decline all trips!");
        this.numberOfTrips=numberOfTrips;
    }

}
