package cis.travel.eg.User.TourGuide;

public class InvalidHistoryYear extends RuntimeException {
    int year;
    public InvalidHistoryYear(int year)
    {
        super("Invalid year "+year+" ! You are only allowed to enter former years.");
        this.year=year;
    }
}
