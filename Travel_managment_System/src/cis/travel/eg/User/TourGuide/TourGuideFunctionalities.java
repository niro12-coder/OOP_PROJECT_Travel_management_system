package cis.travel.eg.User.TourGuide;

import cis.travel.eg.Trip.Trip;
import cis.travel.eg.User.Admin;
import cis.travel.eg.User.Customer;
import cis.travel.eg.User.Manager;
import cis.travel.eg.User.TourGuide.TourGuide;

import java.util.ArrayList;

public interface TourGuideFunctionalities {
double calculateMonthlySalary(int year, int month, ArrayList<Trip> Trips);  // yyyy-mm-dd
int ViewTrips_Complaints() throws InvalidNumberOfComplaints;
int update_TravelHistory();   //trips
boolean isAvailable(String startDate, String endDate);
int view_statistics_SalaryMonthly();
int Logout_exist();
}
