package cis.travel.eg.User.TourGuideDetails;

import java.io.Serializable;

public class InvalidHistoryYear extends RuntimeException implements Serializable {
    int year;
    public InvalidHistoryYear(int year)
    {
        super("Invalid year "+year+" ! You are only allowed to enter former years.");
        this.year=year;
    }
}
