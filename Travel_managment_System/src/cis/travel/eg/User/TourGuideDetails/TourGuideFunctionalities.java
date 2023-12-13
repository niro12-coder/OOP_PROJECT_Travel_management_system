package cis.travel.eg.User.TourGuideDetails;

import cis.travel.eg.Trip.Trip;

import java.io.Serializable;
import java.util.ArrayList;

public interface TourGuideFunctionalities extends Serializable {
double calculateMonthlySalary(int year, int month, ArrayList<Trip> Trips);  // yyyy-mm-dd
int ViewTrips_Complaints() throws InvalidNumberOfComplaints;
int update_TravelHistory();   //trips
boolean isAvailable(String startDate, String endDate);
int view_statistics_SalaryMonthly();
int Logout_exist();
}
