package cis.travel.eg.User.TourGuideDetails;

import cis.travel.eg.Trip.Trip;

import java.time.LocalDate;
import java.util.Comparator;

public class ChronologicalTripsComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Trip t1= (Trip) o1;
        Trip t2=(Trip) o2;
        LocalDate startDate1 = LocalDate.parse(t1.getStartDate());
        LocalDate startDate2 = LocalDate.parse(t2.getStartDate());
        if(startDate1.isBefore(startDate2)) return -1;
        else if(startDate1.isAfter(startDate2)) return 1;
        else return 0;
    }
}